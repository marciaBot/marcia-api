package com.marciaApi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciaApi.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	Cliente findByCpf(String cpf);
	
	Cliente findByNumero(String numero);
	
	Optional<Cliente> findById(Long id);
}
