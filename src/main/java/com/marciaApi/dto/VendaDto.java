package com.marciaApi.dto;

import java.math.BigDecimal;
import java.util.List;


import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;

public class VendaDto {
	
	private Long id;
	
	private List<ItemVenda> vendasList;
	
	private Long clienteId;
	
	private BigDecimal valorTotal;
	
	

	public VendaDto(Venda venda) {
		this.id = venda.getId();
		this.vendasList = venda.getVendasList();
		this.clienteId = venda.getClienteId() != null ? venda.getClienteId() : venda.getCliente().getId();
		this.valorTotal = venda.getValorTotal();
	}
	
	public static VendaDto converter(Venda venda) {
		return new VendaDto(venda);
	}

	public Long getId() {
		return id;
	}

	public List<ItemVenda> getVendasList() {
		return vendasList;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	
	
}
