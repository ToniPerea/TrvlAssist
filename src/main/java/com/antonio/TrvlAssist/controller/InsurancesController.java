package  com.antonio.TrvlAssist.controller;

import  com.antonio.TrvlAssist.service.MainService;
import  com.antonio.TrvlAssist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
@RequestMapping("/insurances")
public class InsurancesController {

    private final MainService mainService;
    private final UserService userService;
    @GetMapping
        public String getInsurances(Model model){
            model.addAttribute("user", userService.getAuthenticatedUser());
            return "insurances";
    }
    // @GetMapping
    // public String showInsurances(Model model) {

    //     // model.addAttribute("user", userService.getAuthenticatedUser());
    //     // model.addAttribute("insurances", mainService.listAllProducts());
    //     // return "insurances";
    // }




}