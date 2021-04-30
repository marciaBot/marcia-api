package com.marciaApi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marciaApi.dto.ItemVendaDto;
import com.marciaApi.exception.ApiNotFoundException;
import com.marciaApi.exception.ApiRequestException;
import com.marciaApi.model.ItemVenda;
import com.marciaApi.service.ItemVendaService;

@RestController
@RequestMapping("/item-venda")
public class ItemVendaController {
	
	@Autowired
	ItemVendaService itemVendaService;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaItemVenda(@PathVariable Long id) {
		try {
			ItemVenda itemVenda = itemVendaService.findById(id);
			return ResponseEntity.ok(ItemVendaDto.converter(itemVenda));
		} catch (NullPointerException e) {
			throw new ApiNotFoundException("Venda não encontrada" + e.getCause());
		}
	}
	
	@PostMapping
	public ResponseEntity<?> criaItemVenda(@Valid @RequestBody ItemVenda itemVenda) {
			itemVendaService.create(itemVenda);
			return ResponseEntity.ok(ItemVendaDto.converter(itemVenda));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteItemVenda(@PathVariable Long id) {
		try {
			itemVendaService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ApiRequestException("Error", e.getCause());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editarItemVenda(@PathVariable Long id, @RequestBody ItemVenda itemVenda) {
		try {
			itemVendaService.edit(id, itemVenda);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ApiRequestException("Error", e.getCause());
		}
	}
}
