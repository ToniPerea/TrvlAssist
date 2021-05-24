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


    public DefaultController(UserService userService) {
        this.userService = userService;
    }

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
        System.out.println("[showRegistrationForm]");
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute("user") User user) {

        if (userService.isNewUser(user.getUsername())) {
            System.out.println("NEW USERRR");
            userService.registerUser(user);
            return "redirect:/login";
        }
        else {
            System.out.println("User is created");
            return "redirect:/login";
        }
    }

    @GetMapping("/confirmation")
    public String showConfirmation(Model model){
        return "confirmation";
    }


    // Cuidado del copy&paste 
    // las funciones no se pueden llamar igual

    @GetMapping("/products/{id}")
    public String showProduct(Model model, @PathVariable Long id){
        System.out.println("Showing product");
        return "product";
    }






}
