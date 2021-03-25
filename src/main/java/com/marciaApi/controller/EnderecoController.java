package com.marciaApi.controller;

import java.util.List;

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

import com.marciaApi.dto.EnderecoDto;
import com.marciaApi.exception.ApiRequestException;
import com.marciaApi.model.Endereco;
import com.marciaApi.service.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	EnderecoService enderecoService;
	
	@PostMapping
	public ResponseEntity<?> criaEndereco(@Valid @RequestBody Endereco endereco){
		try {
			enderecoService.create(endereco);
			
			return ResponseEntity.ok(EnderecoDto.converter(endereco));
		} catch (Exception e) {
			throw new ApiRequestException("Campo nulo Inválido" , e.getCause());
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> listaEndereco(@PathVariable Long id){
		try {
			Endereco endereco = enderecoService.listaEndereco(id);
			return ResponseEntity.ok(EnderecoDto.converter(endereco));
		} catch (Exception e) {
			throw new ApiRequestException("Campo Inválido" , e.getCause());
		}
	}
	
	@GetMapping("/listaTodos/{clienteId}")
	public ResponseEntity<?> listaTodosEnderecos(@PathVariable Long clienteId){
		try {
			List<Endereco> enderecos = enderecoService.listaTodosEnderecos(clienteId);
			return ResponseEntity.ok(enderecos.stream().map(endereco -> EnderecoDto.converter(endereco)));
		} catch (Exception e) {
			throw new ApiRequestException("erro", e.getCause());
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletaEndereco(@PathVariable Long id){
		try {
			enderecoService.deletaEndereco(id);
			
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			throw new ApiRequestException("Error", e.getCause());
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editaEndereco(@PathVariable Long id, @RequestBody Endereco endereco){
		try {
			Endereco enderecoEdit = enderecoService.edit(id, endereco);
			return ResponseEntity.ok(EnderecoDto.converter(enderecoEdit));
		} catch (Exception e) {
			throw new ApiRequestException("Error", e.getCause());
		}
	}
}
