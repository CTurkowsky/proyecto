package com.nttdata.curso.client.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.curso.client.entity.AccountEntity;
import com.nttdata.curso.client.repository.AccountRepository;
import com.nttdata.curso.client.service.AccountService;

import io.reactivex.Maybe;

@Service
public class AccountServiceImpl implements AccountService{
@Autowired
AccountRepository repositorio;

	
	

	@Override
	public AccountEntity getOne(String numberAccount) {
	
		if(numberAccount==null) {
			return null;
		}
		else {
			return repositorio.findByNumberAccount(numberAccount).get(0);
		}
	}

	@Override
	public AccountEntity update(String numberAccount, AccountEntity account) {
		
		AccountEntity a = getOne(numberAccount);
		if(a==null) {
			return new AccountEntity();
		}else {
			
		a.setCommission(a.getCommission());
		a.setLimitMonthlyMovements(a.getLimitMonthlyMovements());
		a.setAccountType(a.getAccountType());
		return repositorio.save(a);
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

	/*@Override
	public List<AccountEntity> listarAccountById(Long id) {
		return repositorio.findById(id);
	}
	 */
	@Override
	public List<AccountEntity> listAccounts() {
		return repositorio.findAll();
	}

	@Override 
	public Maybe<AccountEntity>save(AccountEntity account) {
		return  Maybe.fromCallable(() -> {
			int dnilength = account.getDni().split("").length;
			if(dnilength == 8) {
				return repositorio.save(account);
				
			} throw new Exception("DNI invalido");
		});

	}

	/*public Maybe<AccountEntity> deposit(String numberAccount, int mont) {
		AccountEntity account = new AccountEntity();
		return Maybe.fromCallable( ()-> {
			if(mont > 0) {
				
			float newBalance = account.getBalance() + mont;
			account.setBalance(newBalance);
			} throw new Exception("Monto invalido");
		
		});
	}
	 */
	/*@Override
	public Maybe<AccountEntity> withdrawal(String numberAccount, int mont) {
		AccountEntity account = new AccountEntity();
		return Maybe.fromCallable( ()-> {
			if(mont >= account.getBalance()) {
				
			float newBalance = account.getBalance() - mont;
			account.setBalance(newBalance);
			} throw new Exception("Monto invalido");
		
		});
	}
	 */
	/*@Override
	public AccountEntity getOneId(Long id) {
		if(id==null) {
			return null;
		}
		else {
			return repositorio.findById(id).get();
		}
	}
	 */
	@Override
	public AccountEntity deposit(String numberAccount, AccountEntity account, float amount) {
		AccountEntity a = getOne(numberAccount);
		if(a==null) {
			return new AccountEntity();
		}else {
			float newBalance = a.getBalance() + amount;
		a.setBalance(newBalance);
	
		return repositorio.save(a);
	}
	}
	@Override
	public AccountEntity withdrawal(String numberAccount, AccountEntity account, float amount) {
		
		AccountEntity a = getOne(numberAccount);
		if(a==null) {
			return new AccountEntity();
		}else {
			float newBalance = a.getBalance() - amount;
		a.setBalance(newBalance);
	
		return repositorio.save(a);
	}
	}

	@Override
	public AccountEntity saveDeposit(AccountEntity account) {
		return repositorio.save(account);
	}

}
