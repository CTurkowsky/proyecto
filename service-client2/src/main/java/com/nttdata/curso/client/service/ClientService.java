package com.nttdata.curso.client.service;
import java.util.List;

import com.nttdata.curso.client.entity.ClientEntity;
public interface ClientService {

	public List<ClientEntity> listClients();
	public ClientEntity getOne(String dni);
	public ClientEntity save(ClientEntity client);
	public ClientEntity update(Long id,ClientEntity client);
	public boolean delete(String dni);
	public List<ClientEntity> listarClientByDni(String dni);
}
