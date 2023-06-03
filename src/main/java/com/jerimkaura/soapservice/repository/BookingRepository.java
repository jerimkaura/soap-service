package com.jerimkaura.soapservice.repository;

import com.jerimkaura.soapservice.entities.BookingEntity;
import com.jerimkaura.soapservice.entities.ClientEntity;
import com.jerimkaura.soapservice.entities.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @author Morris.Okworo on 03/05/2023
 */

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {

    Optional<BookingEntity> findByRoomAndAndCheckoutDateIsBefore(RoomEntity room, LocalDate date);

    List<BookingEntity> findByClient(ClientEntity client);
}
