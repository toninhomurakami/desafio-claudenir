package com.desafio.movement.manual.converter;

import com.desafio.movement.manual.dto.MovementDto;
import com.desafio.movement.manual.model.ManualMovementEntity;
import com.desafio.movement.manual.model.ProductEntity;

public class MovementDtoConverter {

    public static MovementDto convert(ManualMovementEntity movement, ProductEntity product) {
        MovementDto dto = new MovementDto();
        dto.setYear(movement.getId().getYear());
        dto.setMonth(movement.getId().getMonth());
        dto.setRelease(movement.getId().getRelease());
        dto.setProductCode(movement.getId().getProductCode());
        dto.setCosifCode(movement.getId().getCosifCode());

        dto.setDescription(movement.getDescription());
        dto.setMovementDate(movement.getMovementDate());
        dto.setUserCode(movement.getUserCode());
        dto.setAmount(movement.getAmount());
        if (product!=null) {
            dto.setProductDescription(product.getDescription());
        }
        return dto;
    }
}
