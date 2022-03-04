package com.nttdata.curso.client.service;

import java.util.List;

import com.nttdata.curso.client.entity.CreditEntity;


public interface CreditService {

	public List<CreditEntity> listCredits();
	public CreditEntity getOne(Long id);
	public CreditEntity save(CreditEntity account);
	public CreditEntity update(Long id,CreditEntity credit);
	public boolean delete(Long id);
	public List<CreditEntity> listarCreditsByClientId(Long clientId);
	public CreditEntity pay(Long id,CreditEntity credit, float mont);
	public CreditEntity charge(Long id,CreditEntity credit, float mont);
}
