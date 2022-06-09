package com.desafio.movement.manual;

import com.desafio.movement.manual.model.ProductEntity;
import com.desafio.movement.manual.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ProductTest {

    @Autowired private ProductRepository repository;

    @Test
    void findAllProductsProducts() {
        List<ProductEntity> products = repository.findAll();
        System.out.println( "Products: "+products );
        Assertions.assertTrue( !products.isEmpty() );
    }

    @Test
    void saveProduct() {
        ProductEntity product = new ProductEntity();
        product.setCode("1234");
        product.setDescription("Teste");
        product.setStatus(true);
        product = repository.save(product);
        Assertions.assertNotNull(product);
    }

}
