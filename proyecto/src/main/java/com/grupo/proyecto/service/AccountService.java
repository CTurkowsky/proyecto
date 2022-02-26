package com.grupo.proyecto.service;

import java.util.List;

import com.grupo.proyecto.entity.AccountEntity;

public interface AccountService {

	public List<AccountEntity> listAccounts();
	public AccountEntity getOne(Long id);
	public AccountEntity save(AccountEntity account);
	public AccountEntity update(Long id,AccountEntity client);
	public boolean delete(Long id);
	public List<AccountEntity> listarAccountById(String id);
	
	
}
