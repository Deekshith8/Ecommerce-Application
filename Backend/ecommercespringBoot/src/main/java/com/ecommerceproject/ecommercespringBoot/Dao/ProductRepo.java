package com.ecommerceproject.ecommercespringBoot.Dao;

import com.ecommerceproject.ecommercespringBoot.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource
public interface ProductRepo extends JpaRepository<Product,Long > {

    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);


    Page<Product> findByNameContaining(@Param("name") String name,Pageable page);
}
