package b.softuni.surfApp.web;

import b.softuni.surfApp.service.StoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stories")
public class StoriesController {
    private final StoryService storyService;

    public StoriesController(StoryService storyService) {
        this.storyService = storyService;
    }


    @GetMapping("/all")
    public String getAllStories(Model model) {

        model.addAttribute("allStories", storyService.getAllStories());

        return "stories";
    }
}
