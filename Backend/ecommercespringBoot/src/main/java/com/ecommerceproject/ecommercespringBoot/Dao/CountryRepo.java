package com.ecommerceproject.ecommercespringBoot.Dao;

import com.ecommerceproject.ecommercespringBoot.entity.Country;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;



@RepositoryRestResource(collectionResourceRel = "countries",path = "countries")
public interface CountryRepo extends JpaRepository<Country, Integer> {



}
