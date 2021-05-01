package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.Venda;

public class VendaDto {
	
	private Long id;
	
	private Long clienteId;
	
	private BigDecimal valorTotal;
	
	

	public VendaDto(Venda venda) {
		this.id = venda.getId();
		this.clienteId = venda.getClienteId() != null ? venda.getClienteId() : venda.getCliente().getId();
		this.valorTotal = venda.getValorTotal();
	}
	
	public static VendaDto converter(Venda venda) {
		return new VendaDto(venda);
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
