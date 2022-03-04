package com.nttdata.curso.client.service;

import java.util.List;

import com.nttdata.curso.client.entity.MovementsEntity;

public interface MovementsService {

	public List<MovementsEntity> listMovements();
	public MovementsEntity getOne(Long id);
	public MovementsEntity save(MovementsEntity product);
	public MovementsEntity update(Long id,MovementsEntity movements);
	public boolean delete(Long id);
	public List<MovementsEntity> listarMovementsByClientId(Long clientId);
}
