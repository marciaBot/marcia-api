package com.marciaApi.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marciaApi.model.Cliente;

public class ClienteDto {
	
	private String nome;
	private String cpf;
	private String numero;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;
	
	public ClienteDto(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.numero = cliente.getNumero();
		this.dataNascimento = cliente.getDataNascimento();
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

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	

	
}
