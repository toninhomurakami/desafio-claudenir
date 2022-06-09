package com.desafio.movement.manual;

import com.desafio.movement.manual.model.ManualMovementEntity;
import com.desafio.movement.manual.model.ManualMovementPk;
import com.desafio.movement.manual.repository.ManualMovementRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ManualMovementTest {
    private static final int YEAR = 2022;
    private static final int MONTH = 06;

    @Autowired private ManualMovementRepository repository;

    @Test
    void findAllMovements() {
        List<ManualMovementEntity> movements = repository.findAll();
        System.out.println("Movements: "+movements);
        Assertions.assertNotNull(movements);
    }

    @Test
    void saveMovement() {
        ManualMovementPk pk = new ManualMovementPk();
        pk.setYear(YEAR);
        pk.setMonth(MONTH);
        pk.setCosifCode("abcd");
        pk.setProductCode("1234");
        pk.setRelease(1);

        ManualMovementEntity entity = new ManualMovementEntity();
        entity.setId(pk);
        entity.setMovementDate(new Date());
        entity.setDescription("Teste de inserção");
        entity.setUserCode("TESTE");
        entity.setAmount(12.07);

        entity = repository.save(entity);

        Assertions.assertNotNull(entity);
    }

    @Test
    void findByYearMonth() {
        List<ManualMovementEntity> movements = repository.findByYearAndMonth(YEAR, MONTH);
        if (movements.isEmpty()) {
            System.out.println("movements is empty");
            saveMovement();
            movements = repository.findByYearAndMonth(YEAR, MONTH);
        }
        System.out.println("Movements: "+movements);
        Assertions.assertTrue(!movements.isEmpty());
    }

    @Test
    void findNextRelease() {
        Optional<Long> optionalValue = repository.findNextRelease(YEAR, MONTH);
        if (!optionalValue.isPresent()) {
            saveMovement();
            optionalValue = repository.findNextRelease(YEAR, MONTH);
        }
        Assertions.assertTrue( optionalValue.isPresent() );
    }
}
