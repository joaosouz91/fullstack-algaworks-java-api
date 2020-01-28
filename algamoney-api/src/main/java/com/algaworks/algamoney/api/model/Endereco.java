package com.algaworks.algamoney.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Endereco {
	
	@NotNull
	String logradouro;
	
	@NotNull
	String numero;
	
	String complemento;
	
	@NotNull
	String bairro;
	
	@NotNull
	String cep;
	
	@NotNull
	String cidade;
	
	@NotNull
	String estado;
	
}
