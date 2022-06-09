package com.desafio.movement.manual.service;

import com.desafio.movement.manual.converter.ManualMovementEntityConverter;
import com.desafio.movement.manual.converter.MovementDtoConverter;
import com.desafio.movement.manual.dto.MovementDto;
import com.desafio.movement.manual.model.ManualMovementEntity;
import com.desafio.movement.manual.model.ProductEntity;
import com.desafio.movement.manual.repository.ManualMovementRepository;
import com.desafio.movement.manual.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManualMovementService {

    @Autowired private ManualMovementRepository repository;
    @Autowired private ProductRepository productRepository;

    public List<MovementDto> findAll() {
        List<ManualMovementEntity> movements = repository.findAll();
        List<MovementDto> returnList = getMovementDtos(movements);
        return returnList;
    }

    public List<MovementDto> findByYearAndMonth(int year, int month) {
        List<ManualMovementEntity> movements = repository.findByYearAndMonth(year, month);
        List<MovementDto> returnList = getMovementDtos(movements);
        return returnList;
    }

    public ManualMovementEntity save(MovementDto dto) {
        Optional<Long> optionalRelease = repository.findNextRelease(dto.getYear(), dto.getMonth());
        ManualMovementEntity entity = ManualMovementEntityConverter.convert(dto);
        entity.getId().setRelease( optionalRelease.isPresent()?optionalRelease.get():1L );
        entity.setMovementDate(new Date());
        entity = repository.save(entity);
        return entity;
    }

    private List<MovementDto> getMovementDtos(List<ManualMovementEntity> movements) {
        List<MovementDto> returnList = new ArrayList<>();
        movements.stream().forEach(entity -> {
            ProductEntity product = productRepository.getReferenceById(entity.getId().getProductCode());
            MovementDto dto = MovementDtoConverter.convert(entity, product);
            returnList.add(dto);
        });
        return returnList;
    }


}
