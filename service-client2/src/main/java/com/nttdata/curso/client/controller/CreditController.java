package com.nttdata.curso.client.controller;

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
import java.util.List;

import com.nttdata.curso.client.entity.CreditEntity;
import com.nttdata.curso.client.service.CreditService;

@RestController
@RequestMapping(value = "/credit")
public class CreditController {

	@Autowired
	CreditService servicio;
	
	
	@GetMapping(value = "/list")
	public ResponseEntity<List<CreditEntity>> getListProducts() {
		List<CreditEntity> lista = servicio.listCredits();
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lista);

		}
	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<CreditEntity> getProduct(@PathVariable Long id) {
		CreditEntity p = servicio.getOne(id);
		if (p.getId() == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}

	@PostMapping(value="/save")
	
	public ResponseEntity<CreditEntity>saveProduct(@RequestBody CreditEntity movements) {
		try {
			CreditEntity entidadBD = servicio.save(movements);
			if(entidadBD.getId()==null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditEntity());
			}else {
				return ResponseEntity.ok(entidadBD);
			}
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new CreditEntity());
		}
	
	}
	
	@PutMapping(value ="/update/{id}") 
	public ResponseEntity<CreditEntity>
	updateProduct(@PathVariable Long id, @RequestBody CreditEntity credit ){
		CreditEntity p = servicio.update(id,credit);
		if(p.getId() == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new CreditEntity());
		}
		else {
			return ResponseEntity.ok(p);
		}
	}
	
	
	@DeleteMapping(value="/delete/{id}")
	public ResponseEntity<CreditEntity> updateProduct(@PathVariable Long id) {
		boolean res = servicio.delete(id);
		if(res) {
			return ResponseEntity.status(HttpStatus.OK).body(new CreditEntity());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
