package com.desafio.movement.manual.repository;

import com.desafio.movement.manual.model.ManualMovementEntity;
import com.desafio.movement.manual.model.ManualMovementPk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ManualMovementRepository extends JpaRepository<ManualMovementEntity, ManualMovementPk> {

    @Query("from ManualMovementEntity mme where mme.id.year = :year and mme.id.month = :month")
    List<ManualMovementEntity> findByYearAndMonth(@Param("year") int year, @Param("month") int month);

    @Query("select max(mme.id.release)+1 from ManualMovementEntity mme where mme.id.year = :year and mme.id.month = :month")
    Optional<Long> findNextRelease(@Param("year") int year, @Param("month") int month);
}
