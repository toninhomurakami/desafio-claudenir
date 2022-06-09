package com.desafio.movement.manual.resource;

import com.desafio.movement.manual.model.ProductCosifEntity;
import com.desafio.movement.manual.repository.ProductCosifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/productcosif")
public class ProductCosifResource {

    @Autowired
    private ProductCosifRepository repository;

    @GetMapping
    public ResponseEntity<List<ProductCosifEntity>> findAll() {
        List<ProductCosifEntity> products = repository.findAll();
        return ResponseEntity.ok(products);
    }
}
