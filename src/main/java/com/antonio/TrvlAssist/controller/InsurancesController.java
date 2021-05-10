package  com.antonio.TrvlAssist.controller;

import com.antonio.TrvlAssist.model.Product;
import  com.antonio.TrvlAssist.service.MainService;
import  com.antonio.TrvlAssist.service.UserService;
import lombok.AllArgsConstructor;
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
    public String showShop(Model model) {

        model.addAttribute("user", userService.getAuthenticatedUser());
        model.addAttribute("products", mainService.listAllProducts());
        model.addAttribute("producto", new Product());
        return "insurances";
    }

    @PostMapping("/crearProducto")
    public String crearProducto2(Model modelo, Product g){
        System.out.println("He recibido" + g.toString());
        modelo.addAttribute("producto", new Product());
        mainService.saveProduct(g);
        return "redirect:/home";
    }
}