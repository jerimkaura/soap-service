package com.jerimkaura.soapservice.repository;

import com.jerimkaura.soapservice.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Morris.Okworo on 03/05/2023
 */

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {
}
