package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.ItemVenda;

public class ItemVendaListDto {
	private Long id;
	
	private String produto;
	
	private Long quantidade;
	
	private BigDecimal valor;
	
	private BigDecimal totalConta;

	public ItemVendaListDto(ItemVenda itemVenda) {
		this.id = itemVenda.getId();
		this.produto = itemVenda.getProduto().getNome();
		this.quantidade = itemVenda.getQuantidade();
		this.valor = itemVenda.getValor();
		this.totalConta = itemVenda.getVenda().getValorTotal();
	}
	
	public static ItemVendaListDto converter(ItemVenda itemVenda) {
		return new ItemVendaListDto(itemVenda);
	}

	public BigDecimal getTotalConta() {
		return totalConta;
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
