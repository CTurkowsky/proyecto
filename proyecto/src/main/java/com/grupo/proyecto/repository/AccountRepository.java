package com.grupo.proyecto.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grupo.proyecto.entity.AccountEntity;
public interface AccountRepository extends JpaRepository<AccountEntity, Long>{

public List<AccountEntity> findByDni(String dni);
}
