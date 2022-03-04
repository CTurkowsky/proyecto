package com.nttdata.curso.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.curso.client.entity.CreditEntity;
import com.nttdata.curso.client.repository.CreditRepository;
import com.nttdata.curso.client.service.CreditService;

@Service
public class CreditServiceImpl implements CreditService {
	@Autowired
	CreditRepository repositorio;

	@Override
	public List<CreditEntity> listCredits() {
		return repositorio.findAll();
	}

	@Override
	public CreditEntity getOne(Long id) {

		if (id == null) {
			return null;
		} else {
			return repositorio.findById(id).get();
		}
	}

	@Override
	public CreditEntity save(CreditEntity credit) {
		return repositorio.save(credit);
	}

	@Override
	public CreditEntity update(Long id, CreditEntity credit) {
		CreditEntity c = getOne(id);
		if (c == null) {
			return new CreditEntity();
		} else {

			c.setCreditType(c.getCreditType());
			return repositorio.save(c);
		}
	}

	@Override
	public boolean delete(Long id) {

		try {
			repositorio.deleteById(id);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public List<CreditEntity> listarCreditsByClientId(Long clientId) {
		return repositorio.findCreditById(clientId);
	}

	@Override
	public CreditEntity pay(Long id, CreditEntity credit, float amount) {
		try {

			CreditEntity c = getOne(id);
			if (c.getConsumption() == amount) {
				c.setStatus("paid");
				return repositorio.save(c);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return credit;
	}

	@Override
	public CreditEntity charge(Long id, CreditEntity credit, float amount) {
		try {

			CreditEntity c = getOne(id);
			if (c.getLimitConsumption() <= amount) {
				float newCredit = c.getConsumption() + amount;
				c.setConsumption(newCredit);
				return repositorio.save(c);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return credit;

	}
}
