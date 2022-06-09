package com.desafio.movement.manual;

import com.desafio.movement.manual.model.ProductCosifEntity;
import com.desafio.movement.manual.repository.ProductCosifRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductCosif {

    @Autowired private ProductCosifRepository repository;

    @Test
    void findAllProductCosif() {
        List<ProductCosifEntity> products = repository.findAll();
        System.out.println( "Products Cosif: "+products );
        Assertions.assertTrue( !products.isEmpty() );
    }
}
