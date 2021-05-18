package com.antonio.TrvlAssist.controller;

import com.antonio.TrvlAssist.model.Product;
import com.antonio.TrvlAssist.model.Transaction;
import com.antonio.TrvlAssist.service.MainService;
import com.antonio.TrvlAssist.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/shop")
public class ShopController {

    

    @Autowired
    private final UserService userService;
    @Autowired
    private final MainService mainService;


    @GetMapping
    public String showShop(Model model) {

        model.addAttribute("user", userService.getAuthenticatedUser());
        model.addAttribute("transactions", mainService.listAllTransactions());
        //model.addAttribute("products", mainService.listAllProducts());
        //model.addAttribute("producto", new Product());
        return "insurances";
    }

    @PostMapping("/cart/{id}")
    public String addProductToShoppingCart(Model modelo, Product g, @PathVariable Long id){
        System.out.println("[Adding product to shopping cart]");
        System.out.println("Parametro id de producto recibido" + id);

        System.out.println("El usuario qeu me pide es: " + userService.getAuthenticatedUser().toString());
        //mainService.saveProduct(g);
        mainService.purchaseInsurance(id,userService.getAuthenticatedUser());
        return "redirect:/insurances";
    }

    @DeleteMapping("/cart/{id}")
    public String removeProductFromShoppingCart(Model modelo, @PathVariable Long id){
        System.out.println("[removeProductFromShoppingCart]");
        System.out.println("Parametro id de producto recibido" + id);
        mainService.eraseProductFromShoppingCart(id);
        return "redirect:/insurances";
    }

    @GetMapping("/cart")
    public String showCart(Model model){
        System.out.println("[Showing shopping cart]");
        /*ArrayList<Transaction> carts = mainService.getShoppingCart(userService.getAuthenticatedUser());
        System.out.println("[AAAA]"+ carts.toArray().toString());*/

        List<Transaction> miCarrito = mainService.getShoppingCart(userService.getAuthenticatedUser());
        model.addAttribute("transactions", miCarrito);
        // modelo.addAttribute("transactions",mainService.);
        return "cart";
    }


    @PostMapping("/purchase")
    public String purchaseNow(Model modelo){
        System.out.println("[purchaseNow]");
        System.out.println("Quiero confirmar las transacciones del usuario: ");

        // Tengo que meter los productos del carrito en la tabla purchase
        List<Transaction> miCarrito = mainService.getShoppingCart(userService.getAuthenticatedUser());
        System.out.println("Meto los productos del carrito en la tabla purchase");
        mainService.addShoppingCartToOrdersConfirmation(miCarrito,userService.getAuthenticatedUser());
        System.out.println("Fin de la primera parte");

        // tengo que borrar todos los productos del carrito para ese usuario
        mainService.removeAllShoppingCartForUser(miCarrito, userService.getAuthenticatedUser());

        return "redirect:/confirmation";
    }



}
