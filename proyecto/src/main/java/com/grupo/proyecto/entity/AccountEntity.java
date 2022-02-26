package com.grupo.proyecto.entity;

import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="accounts")

public class AccountEntity {
	private String numberAccount;
	private String descriptionAccount;
	private float commission;
	private String accountType;
	private Integer movements;
	private Integer limitMonthlyMovements;
	private float balance;
	private Integer clientId;
}
