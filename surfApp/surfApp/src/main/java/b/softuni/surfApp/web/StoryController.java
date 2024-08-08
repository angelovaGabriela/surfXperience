package b.softuni.surfApp.web;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;
import b.softuni.surfApp.model.view.FullStoryViewModel;
import b.softuni.surfApp.service.StoryService;
import b.softuni.surfApp.service.TranslationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/stories")
public class StoryController {

    private final StoryService storyService;
    private final TranslationService translationService;


    public StoryController(StoryService storyService, TranslationService translationService) {
        this.storyService = storyService;
        this.translationService = translationService;
    }

    @ModelAttribute
    public AddStoryBindingModel storyBindingModel() {
        return new AddStoryBindingModel();
    }

    @GetMapping("/add")
    public String add(Model model) {
        if (!model.containsAttribute("storyBindingModel")) {
            model.addAttribute("storyBindingModel", new AddStoryBindingModel());
        }

        return "story-add";
    }

    @PostMapping("add")
    public String addStory(@Valid AddStoryBindingModel addStoryBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addStoryBindingModel", addStoryBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addStoryBindingModel", bindingResult);

            return "redirect:/stories/add";
        }

        storyService.createStory(addStoryBindingModel);
        return "redirect:/stories/all";
    }
//with translation !! run libretranslate/libretranslate image in docker
    @GetMapping("/{id}")
    public String fullStory(@PathVariable("id") Long id,
                            @RequestParam(name = "lang", required = false) String lang,
                            @CookieValue(value = "lang", defaultValue = "en") String langCookie,
                            HttpServletResponse response,
                            Model model) {
        if (lang == null || lang.isEmpty()) {
            lang = langCookie.isEmpty() ? "en" : langCookie;
        } else {
            // Set the `lang` cookie with the selected language
            Cookie languageCookie = new Cookie("lang", lang);
            languageCookie.setPath("/");
            languageCookie.setHttpOnly(true); // Optional: make the cookie HTTP-only
            languageCookie.setMaxAge(7 * 24 * 60 * 60); // Optional: set the cookie to expire after one week
            response.addCookie(languageCookie);
        }


        FullStoryViewModel story = storyService.fullStory(id);

        if (!lang.equals(story.getOriginalLanguage())) {
            story.setTitle(translationService.translateText(story.getTitle(), story.getOriginalLanguage(), lang));
            story.setStoryText(translationService.translateText(story.getStoryText(), story.getOriginalLanguage(), lang));

        }
            model.addAttribute("fullStory", story);

        return "fullStory";
    }

    // without translation
//    @GetMapping("/{id}")
//    public String fullStory(@PathVariable("id") Long id,
//                            Model model) {
//
//        model.addAttribute("fullStory", storyService.fullStory(id));
//
//        return "fullStory";
//    }

}
