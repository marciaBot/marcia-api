package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.ItemVenda;

public class ItemVendaDto {

	private Long id;
	
	private Long produtoId;
	
	private Long quantidade;
	
	private BigDecimal valor;
	
	private Long vendaId;

	public ItemVendaDto(ItemVenda itemVenda) {
		this.id = itemVenda.getId();
		this.produtoId = itemVenda.getProdutoId() != null ? itemVenda.getProdutoId() : itemVenda.getProduto().getId();
		this.quantidade = itemVenda.getQuantidade();
		this.valor = itemVenda.getValor();
		this.vendaId = itemVenda.getVendaId() != null ? itemVenda.getVendaId() : itemVenda.getVenda().getId();
	}

	public static ItemVendaDto converter(ItemVenda itemVenda) {
		return new ItemVendaDto(itemVenda);
	}
	
	public Long getId() {
		return id;
	}

	public Long getProdutoId() {
		return produtoId;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public Long getVendaId() {
		return vendaId;
	}
	
	
}
