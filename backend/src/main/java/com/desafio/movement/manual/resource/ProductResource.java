package com.desafio.movement.manual.resource;

import com.desafio.movement.manual.model.ProductEntity;
import com.desafio.movement.manual.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductResource {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAllProducts() {
        List<ProductEntity> products = repository.findAll();
        return ResponseEntity.ok(products);
    }
}
