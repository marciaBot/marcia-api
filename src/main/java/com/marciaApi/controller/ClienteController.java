package com.marciaApi.controller;

import java.util.Optional;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marciaApi.dto.ClienteDto;
import com.marciaApi.model.Cliente;
import com.marciaApi.repository.ClienteRepository;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@PostMapping
	public ResponseEntity<ClienteDto> criaCliente(@Valid @RequestBody Cliente cliente) {
		try {
			clienteRepository.save(cliente);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}
	
	@PutMapping("/{id}")
	ResponseEntity<ClienteDto> editaCliente(@PathVariable(required = true) Long id ,@Valid @RequestBody Cliente cliente) {
		try {
			Optional<Cliente> clienteBase = clienteRepository.findById(id);
			if(!clienteBase.isPresent()) {
				throw new Exception();
			}
			cliente.setId(id);
			clienteRepository.save(cliente);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}
	}

	@GetMapping("/{cpf}")
	public ResponseEntity<ClienteDto> listaCliente(@PathVariable(required = true) String cpf) {
		try {
			Cliente cliente = clienteRepository.findByCpf(cpf);
			return ResponseEntity.ok(ClienteDto.converter(cliente));
			
		} catch (NullPointerException e) {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<ClienteDto> deletaCliente(@PathVariable(required = true) Long id) {
		try {
			Optional<Cliente> cliente = clienteRepository.findById(id);
			if(!cliente.isPresent()) {
				throw new Exception();
			}
			clienteRepository.deleteById(id);
			return ResponseEntity.ok().build();
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
}
