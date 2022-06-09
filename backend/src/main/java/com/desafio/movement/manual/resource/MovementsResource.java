package com.desafio.movement.manual.resource;

import com.desafio.movement.manual.dto.MovementDto;
import com.desafio.movement.manual.service.ManualMovementService;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movements")
@Slf4j
public class MovementsResource {

    @Autowired
    private ManualMovementService service;

    @PostMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void save(@RequestBody MovementDto dto) {
        log.info("Saving movement "+ dto);
        service.save(dto);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<MovementDto> movements = service.findAll();
        return ResponseEntity.ok(movements);
    }

    @GetMapping("/{year}/{month}")
    public ResponseEntity findAll(@PathVariable int year, @PathVariable int month) {
        List<MovementDto> movements = service.findByYearAndMonth(year, month);
        return movements.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(movements);
    }
}
