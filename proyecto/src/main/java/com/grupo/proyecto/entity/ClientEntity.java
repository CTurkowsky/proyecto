package com.grupo.proyecto.entity;

import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="clients")
public class ClientEntity {
	@Id
	private String firstname;
	private String lastname;
	private String dni;
	private String clientType;
}
