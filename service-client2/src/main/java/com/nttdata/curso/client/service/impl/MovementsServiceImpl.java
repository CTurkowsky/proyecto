package com.nttdata.curso.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.curso.client.entity.MovementsEntity;
import com.nttdata.curso.client.repository.MovementsRepository;
import com.nttdata.curso.client.service.MovementsService;
@Service
public class MovementsServiceImpl implements MovementsService{
	@Autowired
	MovementsRepository repositorio;
	@Override
	public List<MovementsEntity> listMovements() {
		return repositorio.findAll();
	}

	@Override
	public MovementsEntity getOne(Long id) {
		
		if(id==null) {
			return null;
		}
		else {
			return repositorio.findById(id).get();
		}
	}

	@Override
	public MovementsEntity save(MovementsEntity product) {
		return repositorio.save(product);
	}

	@Override
	public MovementsEntity update(Long id, MovementsEntity product) {
		
		MovementsEntity m = getOne(id);
		if(m==null) {
			return new MovementsEntity();
		}else {
			
		m.setDescription(m.getDescription());
		return repositorio.save(m);
	}
		}

	@Override
	public boolean delete(Long id) {
		
		try {
			 repositorio.deleteById(id);
			 return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<MovementsEntity> listarMovementsByClientId(Long clientId) {
		
		return repositorio.findAll();
	}

}
