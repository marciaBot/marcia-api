package com.marciaApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.Cliente;
import com.marciaApi.model.Endereco;
import com.marciaApi.repository.ClienteRepository;
import com.marciaApi.repository.EnderecoRepository;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Endereco create(Endereco endereco) {
		if(endereco.getClienteId() == null) {
			throw new NullPointerException();
		}
		Cliente cliente = clienteRepository.getOne(endereco.getClienteId());
		if(cliente == null) {
			throw new NullPointerException();
		}
		endereco.setCliente(cliente);
		enderecoRepository.save(endereco);
		return endereco;
	}
	
	public Endereco edit(Long id, Endereco endereco) {
		Optional<Endereco> enderecoEdit = enderecoRepository.findById(id);
		if(!enderecoEdit.isPresent()) {
			throw new NullPointerException();
		}
		endereco.setId(id);
		enderecoRepository.save(endereco);
		return endereco;
		
	}
	
	public List<Endereco> listaTodosEnderecos(Long clienteId) {
		Optional<Cliente> cliente = clienteRepository.findById(clienteId);
		if(!cliente.isPresent()) {
			throw new NullPointerException();
		}
		
		List<Endereco> enderecos = enderecoRepository.findByCliente(cliente);
		
		return enderecos;
		
	} 

}
