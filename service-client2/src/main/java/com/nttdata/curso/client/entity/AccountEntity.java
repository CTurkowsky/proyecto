package com.nttdata.curso.client.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class AccountEntity {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dni;
	private String numberAccount;
	private String descriptionAccount;
	private float commission;
	private String accountType;
	private Integer movements;
	private Integer limitMonthlyMovements;
	private float balance;
	private Integer clientId;
}
