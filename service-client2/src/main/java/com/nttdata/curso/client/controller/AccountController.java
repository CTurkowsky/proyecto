package com.nttdata.curso.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.curso.client.entity.AccountEntity;
import com.nttdata.curso.client.service.AccountService;

import io.reactivex.Maybe;

@RestController
@RequestMapping(value = "/account")
public class AccountController {
	@Autowired
	AccountService servicio;
	
	// List all accounts
	@GetMapping(value = "/list")
	public ResponseEntity<List<AccountEntity>> getListAccounts() {
		List<AccountEntity> lista = servicio.listAccounts();
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lista);

		}
	}
	// Save an account
	@PostMapping(value="/save")
	
	public Maybe<ResponseEntity<Map<String, Object>>>saveAccount(@RequestBody AccountEntity account) {

			return servicio.save(account)
					.map( this::buildResponseEntityOk)
					.onErrorResumeNext(this::buildResponseEntityBadRequest);
					
	}
	
	// Build response entity OK
	private ResponseEntity<Map<String, Object>> buildResponseEntityOk(AccountEntity account){
		
		Map<String, Object> body = new HashMap<>();
		body.put("data", account );
		return  ResponseEntity.ok(body);
	}
	// Build response entity bad request
	private Maybe<ResponseEntity<Map<String, Object>>> buildResponseEntityBadRequest(Throwable throwable){
		
		Map<String, Object> body = new HashMap<>();
		body.put("message", throwable.getMessage() );
		return  Maybe.just( ResponseEntity.badRequest().body(body));
	}
	
	// Get an account by number account
	@GetMapping(value = "/get/{numberAccount}")
	public ResponseEntity<AccountEntity> getAccount(@PathVariable String numberAccount) {
		AccountEntity p = servicio.getOne(numberAccount);
		
		if (p.getId() == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	// Deposit  amount in balance account
	@PutMapping(value="/deposit")
	
	public ResponseEntity<AccountEntity>deposit(@RequestBody AccountEntity account) {
		try {
			AccountEntity entidadBD = servicio.saveDeposit(account);
			if(entidadBD.getId()==null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new AccountEntity());
			}else {
				return ResponseEntity.ok(entidadBD);
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AccountEntity());
		}
}
	@PutMapping(value="/withdrawal")
	
	public ResponseEntity<AccountEntity>withdrwal(@RequestBody AccountEntity account) {
		try {
			AccountEntity entidadBD = servicio.saveDeposit(account);
			if(entidadBD.getId()==null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new AccountEntity());
			}else {
				return ResponseEntity.ok(entidadBD);
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new AccountEntity());
		}
}
	}