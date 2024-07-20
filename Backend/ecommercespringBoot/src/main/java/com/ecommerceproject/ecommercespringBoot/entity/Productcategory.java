package com.ecommerceproject.ecommercespringBoot.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;

import java.util.Set;

@Entity
@Table(name = "product_category")

//@Data is known bug for one to many and many to one

@Getter
@Setter
@ToString
public class Productcategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "category_name")
    private String categoryName;


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
    private Set<Product>products;





}
