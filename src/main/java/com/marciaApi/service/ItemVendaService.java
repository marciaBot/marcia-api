package com.marciaApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.ItemVenda;
import com.marciaApi.repository.ItemVendaRepository;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository itemVendaRepository;
	
	public ItemVenda create(ItemVenda itemVenda) {
		itemVendaRepository.save(itemVenda);
		return itemVenda;
	}
	
	public ItemVenda findById(Long id) {
		ItemVenda item = itemVendaRepository.getOne(id);
		return item;
	}
	
	public void delete(Long id) throws Exception {
		ItemVenda item = itemVendaRepository.getOne(id);
		if (item == null) {
			throw new Exception();
		}
		itemVendaRepository.deleteById(id);;
	}
}
