package com.nttdata.curso.client.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdata.curso.client.entity.MovementsEntity;
import com.nttdata.curso.client.service.MovementsService;

@RestController
@RequestMapping (value="/movements")
public class MovementsController {
	@Autowired
	MovementsService servicio;
	
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<MovementsEntity>> getListMovements() {
		List<MovementsEntity> lista = servicio.listMovements();
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lista);

		}
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<MovementsEntity> getProduct(@PathVariable Long id) {
		MovementsEntity p = servicio.getOne(id);
		if (p.getId() == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}

	@PostMapping(value="/save")
	
	public ResponseEntity<MovementsEntity>saveProduct(@RequestBody MovementsEntity movements) {
		try {
			MovementsEntity entidadBD = servicio.save(movements);
			if(entidadBD.getId()==null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new MovementsEntity());
			}else {
				return ResponseEntity.ok(entidadBD);
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new MovementsEntity());
		}
	
	}
	
	@PutMapping(value ="/update/{id}") 
	public ResponseEntity<MovementsEntity>
	updateProduct(@PathVariable Long id, @RequestBody MovementsEntity movements ){
		MovementsEntity p = servicio.update(id,movements);
		if(p.getId() == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new MovementsEntity());
		}
		else {
			return ResponseEntity.ok(p);
		}
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<MovementsEntity> updateProduct(@PathVariable Long id) {
		boolean res = servicio.delete(id);
		if(res) {
			return ResponseEntity.status(HttpStatus.OK).body(new MovementsEntity());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@GetMapping(value = "/get/{clientId}")
	public ResponseEntity<List<MovementsEntity>> getmovementsById(@PathVariable Long clientId) {
		List<MovementsEntity> m =  servicio.listarMovementsByClientId(clientId);
		if (m.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(m);
		}
	}
}
