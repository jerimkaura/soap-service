package com.jerimkaura.soapservice.repository;

import com.jerimkaura.soapservice.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Morris.Okworo on 03/05/2023
 */

public interface RoomRepository extends JpaRepository<RoomEntity, Long> {

    List<RoomEntity> findByIsBooked(Integer value);
}
