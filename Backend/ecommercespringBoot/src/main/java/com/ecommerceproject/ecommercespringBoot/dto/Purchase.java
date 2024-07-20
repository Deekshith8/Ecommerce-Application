package com.ecommerceproject.ecommercespringBoot.dto;


import com.ecommerceproject.ecommercespringBoot.entity.Address;
import com.ecommerceproject.ecommercespringBoot.entity.Customer;
import com.ecommerceproject.ecommercespringBoot.entity.Order;
import com.ecommerceproject.ecommercespringBoot.entity.OrderItems;
import lombok.Data;
import java.util.*;

@Data

public class Purchase {

    private Customer customer;

    private Address shipppingAddress;

    private Address billingAddress;

    private Order order;

    private Set<OrderItems>orderItems;




}
