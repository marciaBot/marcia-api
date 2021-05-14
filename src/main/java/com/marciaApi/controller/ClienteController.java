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

import com.marciaApi.dto.ClienteDto;
import com.marciaApi.exception.ApiNotFoundException;
import com.marciaApi.exception.ApiRequestException;
import com.marciaApi.model.Cliente;
import com.marciaApi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@PostMapping
	public ResponseEntity<?> criaCliente(@Valid @RequestBody Cliente cliente) {
		try {
			clienteService.create(cliente);
			
			return ResponseEntity.ok(ClienteDto.converter(cliente));

		}
		catch (Exception e) {
			if(e.getCause().toString().contains("ConstraintViolationException")) {
				throw new ApiRequestException("Cpf já cadastrado" , e.getCause());
			} else {
				throw new ApiRequestException("Campo nulo Inválido" , e.getCause());
			}
		}
	}
	
	@PutMapping("/{id}")
	ResponseEntity<?> editaCliente(@PathVariable(required = true) Long id ,@Valid @RequestBody Cliente cliente) {
		try {
			clienteService.edit(id, cliente);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (Exception e) {
			if(e.getCause() != null && e.getCause().toString().contains("ConstraintViolationException")) {
				throw new ApiRequestException("Cpf já cadastrado" , e.getCause());
			}
			else {
			throw new ApiNotFoundException("Id não encontrado");
			}
		}
	}

	@GetMapping("/cpf/{cpf}")
	public ResponseEntity<?> listaCliente(@PathVariable(required = true) String cpf) {
		try {
			Cliente cliente = clienteService.findByCpf(cpf);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (NullPointerException e) {
			throw new ApiNotFoundException("CPF não encontrado");
		}
	}
	
	@GetMapping("/numero/{numero}")
	public ResponseEntity<?> listaClienteByNumero(@PathVariable(required = true) String numero) {
		try {
			Cliente cliente = clienteService.findByNumero(numero);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (NullPointerException e) {
			throw new ApiNotFoundException("Número não encontrado");
		}
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<?> deletaCliente(@PathVariable(required = true) Long id) {
		try {
			clienteService.delete(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			throw new ApiNotFoundException("Id não encontrado");
		}
	}
}
