package com.nttdata.curso.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.curso.client.entity.CreditEntity;

public interface CreditRepository extends JpaRepository<CreditEntity, Long> {

public List<CreditEntity> findCreditById(Long clientId);
}
