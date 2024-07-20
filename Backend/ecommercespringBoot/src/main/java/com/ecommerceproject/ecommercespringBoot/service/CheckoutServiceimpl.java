package com.ecommerceproject.ecommercespringBoot.service;

import com.ecommerceproject.ecommercespringBoot.Dao.CustomerRepository;
import com.ecommerceproject.ecommercespringBoot.dto.Purchase;
import com.ecommerceproject.ecommercespringBoot.dto.PurchaseResponse;
import com.ecommerceproject.ecommercespringBoot.entity.Customer;
import com.ecommerceproject.ecommercespringBoot.entity.Order;
import com.ecommerceproject.ecommercespringBoot.entity.OrderItems;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;
import java.util.UUID;


@Service
public class CheckoutServiceimpl implements  CheckoutService{


    private CustomerRepository customerRepository;

  public  CheckoutServiceimpl(CustomerRepository customerRepository){
      this.customerRepository=customerRepository;
  }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

         //retrieve the order info from dto
        Order order= purchase.getOrder();

        //generate trackung number
        String orderTrackingNumber=generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        //populate order with orderitem
        Set<OrderItems> orderitems=purchase.getOrderItems();
        orderitems.forEach(item->order.add(item));

        //populate order with billing Address and shipping Address
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShipppingAddress());

        //populate customer with order
        Customer customer=purchase.getCustomer();
        //check if this is an existing customer;
        String theEmail=customer.getEmail();

        Customer customerFromDB=customerRepository.findByEmail(theEmail);
        if(customerFromDB!=null){
            //we found him ...lets assign him accordingly
            customer=customerFromDB;
        }

        customer.add(order);

        //save to  the database
        customerRepository.save(customer);

        //return a response
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
      //generate a random number
        // for details see:https://en.wikipedia.org/wiki/Universally_Unique_identifier
     return UUID.randomUUID().toString();
    }
}
