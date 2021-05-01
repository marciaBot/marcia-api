package com.marciaApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marciaApi.dto.ItemVendaListDto;
import com.marciaApi.dto.VendaDto;
import com.marciaApi.exception.ApiNotFoundException;
import com.marciaApi.exception.ApiRequestException;
import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;
import com.marciaApi.service.VendaService;

@RestController
@RequestMapping("/venda")
public class VendaController {
	
	@Autowired
	VendaService vendaService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Venda venda) {
		try {
			vendaService.create(venda);
			return ResponseEntity.ok(VendaDto.converter(venda));
		} catch (Exception e) {
			throw new ApiRequestException("Erro no cadastro" + e.getCause());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listVenda(@PathVariable Long id) {
		try {
			Venda venda = vendaService.findById(id);
			return ResponseEntity.ok(VendaDto.converter(venda));
		} catch (Exception e) {
			throw new ApiNotFoundException("Venda não encontrada" + e.getCause());
		}
	} 
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		try {
			vendaService.delete(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ApiRequestException("Error", e.getCause());
		}
	}
	
	@GetMapping("/listar-itens-venda/{id}")
	public ResponseEntity<?> listarItemVenda(@PathVariable Long id){
		List<ItemVenda> itensVenda = vendaService.itensVenda(id);
		return ResponseEntity.ok(itensVenda.stream().map(item -> ItemVendaListDto.converter(item)));
	}
	
}
