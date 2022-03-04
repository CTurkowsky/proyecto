package com.nttdata.curso.client.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.curso.client.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

public List<AccountEntity> findByNumberAccount(String numberAccount);
}
