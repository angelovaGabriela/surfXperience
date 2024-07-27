package b.softuni.surfApp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

//    @PostMapping("/login-error")
//    public String onFailedLogin(
//            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username,
//            RedirectAttributes redirectAttributes
//    )  {
//        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
//        redirectAttributes.addFlashAttribute("bad_credentials", true);
//        return "redirect:/login";
//    }

}
