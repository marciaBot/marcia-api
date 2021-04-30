package com.marciaApi.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;
import com.marciaApi.repository.ClienteRepository;
import com.marciaApi.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	ItemVendaService itemVendaService;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Venda create(Venda venda) {
		venda.setCliente(clienteRepository.getOne(venda.getClienteId()));
		if(venda.getVendasList() != null && !venda.getVendasList().isEmpty()) {
			venda.setValorTotal(venda.getVendasList()
					.stream()
					.map(item -> item.getValor())
					.reduce(BigDecimal.ZERO, BigDecimal::add));
		}
		vendaRepository.save(venda);
		return venda;
	}
	
	public Venda findById(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if (venda == null) {
			throw new NullPointerException();
		}
		return venda;
	}
	
	public void delete(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if(venda == null) {
			throw new NullPointerException();
		}
		
		vendaRepository.deleteById(id);
	}
	
	public List<ItemVenda> listItemVenda(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if (venda == null) {
			throw new NullPointerException();
		}
		return venda.getVendasList();
	}
}
