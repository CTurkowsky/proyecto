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

import com.nttdata.curso.client.entity.ClientEntity;
import com.nttdata.curso.client.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {
@Autowired
ClientService servicio;





	@GetMapping(value = "/list")
	public ResponseEntity<List<ClientEntity>> getListProducts() {
		List<ClientEntity> lista = servicio.listClients();
		if (lista.isEmpty()) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(lista);

		}
	}
	
	
	@PostMapping(value="/save")
	
	public ResponseEntity<ClientEntity>saveClient(@RequestBody ClientEntity client) {
		try {
			ClientEntity entidadBD = servicio.save(client);
			if(entidadBD.getId()==null) {
				return ResponseEntity.status(HttpStatus.CONFLICT).body(new ClientEntity());
			}else {
				return ResponseEntity.ok(entidadBD);
			}  
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientEntity());
		}
	
	}
	
	@PutMapping(value ="/update/{id}") 
	public ResponseEntity<ClientEntity>
	updateProduct(@PathVariable Long id, @RequestBody ClientEntity client){
		ClientEntity p = servicio.update(id,client);
		if(p.getId() == null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(new ClientEntity());
		}
		else {
			return ResponseEntity.ok(p);
		}
	}
	
	
	@GetMapping(value = "/get/{dni}")
	public ResponseEntity<ClientEntity> getProduct(@PathVariable String dni) {
		ClientEntity p = servicio.getOne(dni);
		if (p.getId() == null) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.ok(p);
		}
	}
	
	

	
	@DeleteMapping(value="/delete/{dni}")
	public ResponseEntity<ClientEntity> updateProduct(@PathVariable String dni) {
		boolean res = servicio.delete(dni);
		if(res) {
			return ResponseEntity.status(HttpStatus.OK).body(new ClientEntity());
		}else {
			return ResponseEntity.notFound().build();
		}
		
	}
}
