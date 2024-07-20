package com.ecommerceproject.ecommercespringBoot.Dao;

import com.ecommerceproject.ecommercespringBoot.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

  Customer findByEmail(String theEmail);


}
