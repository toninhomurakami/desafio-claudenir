package com.desafio.movement.manual.converter;

import com.desafio.movement.manual.dto.MovementDto;
import com.desafio.movement.manual.model.ManualMovementEntity;
import com.desafio.movement.manual.model.ManualMovementPk;

public class ManualMovementEntityConverter {

    public static ManualMovementEntity convert(MovementDto dto) {
        ManualMovementPk id = new ManualMovementPk();
        id.setYear(dto.getYear());
        id.setMonth(dto.getMonth());
        id.setRelease(dto.getRelease());
        id.setProductCode(dto.getProductCode());
        id.setCosifCode(dto.getCosifCode());

        ManualMovementEntity entity = new ManualMovementEntity();
        entity.setId(id);
        entity.setDescription(dto.getDescription());
        entity.setMovementDate(dto.getMovementDate());
        entity.setUserCode(dto.getUserCode());
        entity.setAmount(dto.getAmount());
        return entity;
    }
}
