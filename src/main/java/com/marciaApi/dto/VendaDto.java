package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.Venda;

public class VendaDto {
	
	private Long id;
	
	private Long clienteId;
	
	private BigDecimal valorTotal;
	
	private String obs;
	
	private Boolean aprovado;
	

	public VendaDto(Venda venda) {
		this.id = venda.getId();
		this.clienteId = venda.getClienteId() != null ? venda.getClienteId() : venda.getCliente().getId();
		this.valorTotal = venda.getValorTotal();
		this.obs = venda.getObs();
		this.aprovado = venda.getAprovado();
	}
	
	public static VendaDto converter(Venda venda) {
		return new VendaDto(venda);
	}
	
	public Boolean getAprovado() {
		return aprovado;
	}

	public String getObs() {
		return obs;
	}

	public Long getId() {
		return id;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	
}
