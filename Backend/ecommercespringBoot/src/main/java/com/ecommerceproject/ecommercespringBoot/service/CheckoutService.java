package com.ecommerceproject.ecommercespringBoot.service;

import com.ecommerceproject.ecommercespringBoot.dto.Purchase;
import com.ecommerceproject.ecommercespringBoot.dto.PurchaseResponse;
import org.springframework.stereotype.Component;


public interface CheckoutService {
    PurchaseResponse placeOrder(Purchase purchase);

}
