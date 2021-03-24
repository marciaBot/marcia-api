package com.marciaApi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
