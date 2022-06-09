package com.desafio.movement.manual.repository;

import com.desafio.movement.manual.model.ProductCosifEntity;
import com.desafio.movement.manual.model.ProductCosifPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCosifRepository extends JpaRepository<ProductCosifEntity, ProductCosifPk> {

}
