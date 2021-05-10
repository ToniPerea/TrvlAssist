package  com.antonio.TrvlAssist.controller;

import  com.antonio.TrvlAssist.model.User;
import  com.antonio.TrvlAssist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
@RequestMapping("/")
public class DefaultController {
    @Autowired
    private final UserService userService;


    @GetMapping("/")
    public String getIndex() {

        return "home";
        // return "redirect:/home";
    }

    @GetMapping("/home")
    public String getHome(){
        System.out.println("Ensenio home");
        return "home";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        System.out.println("Ensenio login");
        return "login";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {

        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {

        if (userService.isNewUser(user.getUsername())) {

            userService.registerUser(user);
            return "redirect:/login";
        }
        else {

            return "redirect:/register?error=true";
        }
    }





}
