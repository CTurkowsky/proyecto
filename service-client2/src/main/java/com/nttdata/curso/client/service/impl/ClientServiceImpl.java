package com.nttdata.curso.client.service.impl;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.curso.client.entity.ClientEntity;
import com.nttdata.curso.client.repository.ClientRepository;
import com.nttdata.curso.client.service.ClientService;

@Service

public class ClientServiceImpl implements ClientService{
	@Autowired
	ClientRepository repositorio;
	@Override
	public List<ClientEntity> listClients() {
		return repositorio.findAll();
	}

	@Override
	public ClientEntity getOne(String dni) {
		if(dni==null) {
			return null;
		}
		else {
			return repositorio.findByDni(dni).get(0);
		}
	}

	@Override
	public ClientEntity save(ClientEntity client) {
		return repositorio.save(client);
	}

	@Override
	public ClientEntity update(Long id, ClientEntity client) {
		return null;
	}


	@Override
	public List<ClientEntity> listarClientByDni(String dni) {
		return repositorio.findAll();
	}

	@Override
	public boolean delete(String dni) {
		return false;
	}

}
