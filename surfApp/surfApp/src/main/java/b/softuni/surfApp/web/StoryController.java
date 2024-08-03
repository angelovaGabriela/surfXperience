package b.softuni.surfApp.web;

import b.softuni.surfApp.model.binding.AddStoryBindingModel;
import b.softuni.surfApp.service.StoryService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/stories")
public class StoryController {

    private final StoryService storyService;


    public StoryController(StoryService storyService) {
        this.storyService = storyService;
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




}
