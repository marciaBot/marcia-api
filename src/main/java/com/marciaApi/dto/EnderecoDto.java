package com.marciaApi.dto;

import com.marciaApi.model.Endereco;

public class EnderecoDto {

	private Long enderecoId;
	private String rua;
	private String cep;
	private String numero;
	private String referencia;
	private String bairro;
	private String complemento;
	private String observacao;
	private Long clienteId;
	
	public EnderecoDto(Endereco endereco) {
		this.bairro = endereco.getBairro();
		this.cep = endereco.getCep();
		this.clienteId = endereco.getCliente().getId();
		this.complemento = endereco.getComplemento();
		this.enderecoId = endereco.getId();
		this.numero = endereco.getNumero();
		this.observacao = endereco.getObservacao();
		this.referencia = endereco.getReferencia();
		this.rua = endereco.getRua();
	}
	
	public static EnderecoDto converter(Endereco endereco) {
		return new EnderecoDto(endereco);
	}

	public Long getEnderecoId() {
		return enderecoId;
	}

	public String getRua() {
		return rua;
	}

	public String getCep() {
		return cep;
	}

	public String getNumero() {
		return numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getBairro() {
		return bairro;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getObservacao() {
		return observacao;
	}

	public Long getClienteId() {
		return clienteId;
	}
	
}
