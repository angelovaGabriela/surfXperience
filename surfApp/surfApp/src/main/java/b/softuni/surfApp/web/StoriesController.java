package b.softuni.surfApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/stories")
public class StoriesController {

    @GetMapping("/all")
    public String getAllStories(Model model) {
        return "stories";
    }
}
