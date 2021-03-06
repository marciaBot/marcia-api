package com.marciaApi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;
import com.marciaApi.repository.ClienteRepository;
import com.marciaApi.repository.ItemVendaRepository;
import com.marciaApi.repository.VendaRepository;

@Service
public class VendaService {

	@Autowired
	VendaRepository vendaRepository;
	
	@Autowired
	ItemVendaService itemVendaService;
	
	@Autowired
	ItemVendaRepository itemVendaRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Venda create(Venda venda) {
		venda.setCliente(clienteRepository.getOne(venda.getClienteId() != null ? venda.getClienteId() : venda.getCliente().getId() ));
		vendaRepository.save(venda);
		return venda;
	}

	public List<Venda>  findAllVendas() {
		List<Venda> vendas = vendaRepository.findAll();
		if (vendas.isEmpty()) {
			throw new NullPointerException();
		}
		return vendas;
	}
	
	public Venda findById(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if (venda == null) {
			throw new NullPointerException();
		}
		return venda;
	}
	
	public Venda edit(Long id, Venda venda){
		Venda vendaPresent = vendaRepository.findById(id).get();
		if (vendaPresent == null) {
			throw new NullPointerException();
		}
		if(venda.getAprovado() == null) {
			venda.setAprovado(false);
		}
		venda.setId(id);
		venda.setValorTotal(vendaPresent.getValorTotal());
		venda.setCliente(vendaPresent.getCliente());
		vendaRepository.save(venda);
		return venda;
	}
	
	public void delete(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if(venda == null) {
			throw new NullPointerException();
		}
		
		vendaRepository.deleteById(id);
	}
	
	public List<ItemVenda> itensVenda(Long id) {
		Venda venda = vendaRepository.getOne(id);
		if(venda == null) {
			throw new NullPointerException();
		}
		List<ItemVenda> itensVenda = itemVendaRepository.findByVenda(venda);
		return itensVenda;
	}
}
