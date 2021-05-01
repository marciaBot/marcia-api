package com.marciaApi.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;
import com.marciaApi.repository.ItemVendaRepository;
import com.marciaApi.repository.VendaRepository;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	@Autowired
	private VendaRepository vendaRepository;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private VendaService vendaService;
	
	public ItemVenda create(ItemVenda itemVenda) {
		Venda venda = vendaService.findById(itemVenda.getVendaId());
		itemVenda.setVenda(venda);
		itemVenda.setProduto(produtoService.buscarPorId(itemVenda.getProdutoId()));
		itemVenda.setValor(produtoService.buscarPorId(itemVenda.getProdutoId()).getPreco().multiply(new BigDecimal(itemVenda.getQuantidade())));
		itemVendaRepository.save(itemVenda);
		if(venda.getValorTotal() == null) {
			venda.setValorTotal(BigDecimal.ZERO);
		}
		venda.setValorTotal(venda.getValorTotal().add(itemVenda.getValor()));
		vendaRepository.save(venda);
		return itemVenda;
	}
	
	public ItemVenda findById(Long id) {
		ItemVenda item = itemVendaRepository.getOne(id);
		return item;
	}
	
	public void delete(Long id) {
		ItemVenda item = itemVendaRepository.getOne(id);
		if (item == null) {
			throw new NullPointerException();
		}
		itemVendaRepository.deleteById(id);;
	}
	
	public ItemVenda edit(Long id, ItemVenda itemVenda) {
		ItemVenda item = itemVendaRepository.getOne(id);
		if (item == null) {
			throw new NullPointerException();
		}
		
		itemVenda.setId(id);
		itemVendaRepository.save(itemVenda);
		
		return itemVenda;
	}
}
