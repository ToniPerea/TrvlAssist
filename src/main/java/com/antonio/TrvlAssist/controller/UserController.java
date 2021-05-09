package  com.antonio.TrvlAssist.controller;

import  com.antonio.TrvlAssist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String showUserProfile(@PathVariable("id") Long id, Model model) {

        model.addAttribute("user", userService.getUserByID(id));
        return "user-profile";
    }

    
}