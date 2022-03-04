package com.nttdata.curso.client.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nttdata.curso.client.entity.ClientEntity;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

public List<ClientEntity> findByDni(String dni);
}
