package com.marciaApi.dto;

import com.marciaApi.model.Cliente;

public class ClienteDto {
	
	private String nome;
	private String cpf;
	private String numero;
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.numero = cliente.getNumero();
	}
	
	public static ClienteDto converter(Cliente cliente) {
		return new ClienteDto(cliente);
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	public String getNumero() {
		return numero;
	}

	
}
