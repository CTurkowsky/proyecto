package com.nttdata.curso.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.curso.client.entity.MovementsEntity;

public interface MovementsRepository extends JpaRepository<MovementsEntity, Long> {
	
	
	public List<MovementsEntity> findByClientId(Long clientId);
}
