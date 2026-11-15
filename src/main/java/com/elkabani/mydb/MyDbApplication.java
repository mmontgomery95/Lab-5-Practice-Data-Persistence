package com.elkabani.mydb;

import com.elkabani.mydb.entities.Address;
import com.elkabani.mydb.entities.Category;
import com.elkabani.mydb.entities.Product;
import com.elkabani.mydb.entities.User;
import com.elkabani.mydb.repositories.CategoryRepository;
import com.elkabani.mydb.repositories.ProductRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class MyDbApplication {

    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(MyDbApplication.class, args);

        var categoryRepository = context.getBean(CategoryRepository.class);
        var productRepository = context.getBean(ProductRepository.class);

        var user = User.builder()
                .id(1L)
                .name("John")
                .email("john@example.com")
                .password("Password")
                .build();

        var address = Address.builder()
                .city("Cincinnati")
                .state("Ohio")
                .street("123 Main St")
                .zipCode("45202")
                .build();

        //Create a Product with a New Category
//        var electronics = Category.builder().name("Electronics").build();
//        categoryRepository.save(electronics);
//
//        var camera = Product.builder()
//                .name("Camera")
//                .price(new BigDecimal("499.99"))
//                .category(electronics)
//                .build();
//        productRepository.save(camera);



        //Create a Product for an Existing Category
//        var existing = categoryRepository.findById(1).orElseThrow();
//        var headphones = Product.builder()
//                .name("Headphones")
//                .price(new BigDecimal("79.99"))
//                .category(existing)
//                .build();
//        productRepository.save(headphones);



        //Delete a Product
        productRepository.deleteById(1L);



        user.addAddress(address);
        System.out.println(user);
    }

}
