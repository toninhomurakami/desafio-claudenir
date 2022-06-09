package com.desafio.movement.manual.repository;

import com.desafio.movement.manual.model.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {

}
