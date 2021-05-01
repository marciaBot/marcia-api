package com.marciaApi.dto;

import java.math.BigDecimal;
import java.util.List;


public class VendaFinalDto {
	private Long id;
	private List<ItemVendaListDto> itemList;
	private BigDecimal total;
	
	public VendaFinalDto(List<ItemVendaListDto> lista) {
		this.itemList = lista;
		this.id = lista.get(0).getVendaId();
		this.total = lista.stream().map(item -> item.getValor()).reduce(BigDecimal.ZERO, (a, b)->a.add(b));
	}
	
	public static VendaFinalDto converter(List<ItemVendaListDto> lista) {
		return new VendaFinalDto(lista);
	}

	public Long getId() {
		return id;
	}

	public List<ItemVendaListDto> getItemList() {
		return itemList;
	}

	public BigDecimal getTotal() {
		return total;
	}
	
	
	
	
}
