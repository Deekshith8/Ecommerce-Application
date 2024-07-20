package com.ecommerceproject.ecommercespringBoot.Dao;

import com.ecommerceproject.ecommercespringBoot.entity.Productcategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
public interface ProductcategoryRepo extends JpaRepository<Productcategory, Long> {
}
