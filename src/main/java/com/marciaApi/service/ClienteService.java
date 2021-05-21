package com.marciaApi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marciaApi.model.Cliente;
import com.marciaApi.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public Cliente create(Cliente cliente) {
		clienteRepository.save(cliente);
		return cliente;
	}
	
	public Cliente edit(Long id, Cliente cliente) throws Exception {
		Optional<Cliente> clienteBase = clienteRepository.findById(id);
		if(!clienteBase.isPresent()) {
			throw new Exception();
		}
		cliente.setId(id);
		clienteRepository.save(cliente);
		return cliente;
	}
	
	public Cliente findByCpf (String cpf) {
		Cliente cliente = clienteRepository.findByCpf(cpf);
		return cliente;
	}

	public Cliente findById(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.get();
	}

	public Cliente findByNumero (String numero) {
		Cliente cliente = clienteRepository.findByNumero(numero);
		return cliente;
	}
	
	public void delete (Long id) throws Exception{
		Optional<Cliente> cliente = clienteRepository.findById(id);
		if(cliente.get() == null) {
			throw new Exception();
		}
		clienteRepository.delete(cliente.get());
	}

}
