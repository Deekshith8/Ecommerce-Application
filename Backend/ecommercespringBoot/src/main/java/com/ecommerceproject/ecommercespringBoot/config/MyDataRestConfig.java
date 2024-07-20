package com.ecommerceproject.ecommercespringBoot.config;


import com.ecommerceproject.ecommercespringBoot.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.metamodel.EntityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {


    @Value("${allowed.origins}")
    private String []theAllowedOrigins;
    private EntityManager entityManager;

    @Autowired
    public MyDataRestConfig (EntityManager theentityManager){
        this.entityManager=theentityManager;
    }


    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        HttpMethod[] theunsupportedActions={HttpMethod.DELETE,HttpMethod.POST,HttpMethod.PUT,HttpMethod.PATCH};

        //disable HTTP methods for product :put,delete , pOst

       diableHttpMethods(Product.class,config,theunsupportedActions);
       //disable the http methods put post delete for products categort too
        diableHttpMethods(Productcategory.class,config,theunsupportedActions);


        diableHttpMethods(Country.class,config,theunsupportedActions);

        diableHttpMethods(State.class,config,theunsupportedActions);

        diableHttpMethods(Order.class,config,theunsupportedActions);
        //call an internal helper method
        exposeIds(config);

        //configure cors mapping
        cors.addMapping(config.getBasePath()+"/**").allowedOrigins(theAllowedOrigins);


    }

    private void diableHttpMethods(Class theclass, RepositoryRestConfiguration config, HttpMethod[] theunsupportedActions) {
        config.getExposureConfiguration()
                .forDomainType(theclass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theunsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theunsupportedActions));

    }

    private void exposeIds(RepositoryRestConfiguration config) {
         //expose entity ids

        //get a list of all entity classes from the entity manager
        Set<EntityType<?>>entities=entityManager.getMetamodel().getEntities();


        //create an array of the entity types
        List<Class>entityClasses= new ArrayList<>();

        //get the entity types for the entities
        for(EntityType tempentity:entities){
            entityClasses.add(tempentity.getJavaType());
        }

        //expose the entity ids for the array of entity /domain type
        Class[]domainTypes =entityClasses.toArray(new Class[0]);
        config.exposeIdsFor(domainTypes);

    }
}
