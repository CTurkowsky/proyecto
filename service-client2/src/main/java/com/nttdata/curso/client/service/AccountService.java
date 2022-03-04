package com.nttdata.curso.client.service;

import java.util.List;

import com.nttdata.curso.client.entity.AccountEntity;

import io.reactivex.Maybe;

public interface AccountService {

	public List<AccountEntity> listAccounts();
	public AccountEntity getOne(String numberAccount);
	public Maybe<AccountEntity >save(AccountEntity account);
	public AccountEntity saveDeposit(AccountEntity account);
	public AccountEntity update(String numberAccount,AccountEntity account);
	public boolean delete(Long id);
	public AccountEntity deposit(String numberAccount, AccountEntity account, float amount);
	public AccountEntity withdrawal(String numberAccount, AccountEntity account, float amount);
}
