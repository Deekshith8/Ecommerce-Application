package com.ecommerceproject.ecommercespringBoot.controller;


import com.ecommerceproject.ecommercespringBoot.dto.Purchase;
import com.ecommerceproject.ecommercespringBoot.dto.PurchaseResponse;
import com.ecommerceproject.ecommercespringBoot.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {


    private CheckoutService checkoutService;


    @Autowired
    public CheckoutController(CheckoutService checkoutService){
        this.checkoutService=checkoutService;
    }


    @PostMapping("/purchase")
    public PurchaseResponse placeOrder(@RequestBody Purchase purchase){
        PurchaseResponse purchaseResponse=checkoutService.placeOrder(purchase);
        return purchaseResponse;
    }

}
