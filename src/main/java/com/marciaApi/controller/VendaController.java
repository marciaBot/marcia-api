package com.marciaApi.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.marciaApi.dto.VendaClienteDto;
import com.marciaApi.model.Cliente;
import com.marciaApi.service.ClienteService;
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

import com.marciaApi.dto.ItemVendaListDto;
import com.marciaApi.dto.VendaDto;
import com.marciaApi.dto.VendaFinalDto;
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
	@Autowired
	ClienteService clienteService;

	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Venda venda) {
		try {
			vendaService.create(venda);
			return ResponseEntity.ok(VendaDto.converter(venda));
		} catch (Exception e) {
			throw new ApiRequestException("Erro no cadastro" + e.getCause());
		}
	}

	@GetMapping
	public ResponseEntity<?> listAllVenda() {
		List<Venda> vendas = vendaService.findAllVendas();
		Cliente cliente = clienteService.findById(vendas.get(0).getId());
		List<VendaClienteDto> vendaDto = vendas.stream().map(venda -> VendaClienteDto.converter(venda, cliente)).collect(Collectors.toList());
		return ResponseEntity.ok(vendaDto);
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
	
	@PutMapping("/{id}")
	ResponseEntity<?> editaVenda(@PathVariable(required = true) Long id ,@RequestBody Venda venda) {
		try {
			vendaService.edit(id, venda);
			return ResponseEntity.ok(VendaDto.converter(venda));
			
		} catch (Exception e) {
			throw new ApiNotFoundException("Id não encontrado");
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
		List<ItemVendaListDto> itemList = itensVenda.stream().map(item -> ItemVendaListDto.converter(item)).collect(Collectors.toList());
		return ResponseEntity.ok(VendaFinalDto.converter(itemList));
	}
	
}
