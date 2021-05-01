package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.ItemVenda;

public class ItemVendaListDto {
	private Long id;
	
	private String produto;
	
	private Long quantidade;
	
	private Long vendaId;
	
	private BigDecimal valor;
	
	public ItemVendaListDto(ItemVenda itemVenda) {
		this.vendaId = itemVenda.getVendaId() != null ? itemVenda.getVendaId() : itemVenda.getVenda().getId();
		this.id = itemVenda.getId();
		this.produto = itemVenda.getProduto().getNome();
		this.quantidade = itemVenda.getQuantidade();
		this.valor = itemVenda.getValor();
	}
	
	public static ItemVendaListDto converter(ItemVenda itemVenda) {
		return new ItemVendaListDto(itemVenda);
	}
	
	public Long getVendaId() {
		return vendaId;
	}

	public Long getId() {
		return id;
	}

	public String getProduto() {
		return produto;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public BigDecimal getValor() {
		return valor;
	}

	
	
}
