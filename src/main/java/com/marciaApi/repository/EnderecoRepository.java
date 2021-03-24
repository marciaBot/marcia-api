package com.marciaApi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciaApi.model.Cliente;
import com.marciaApi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
	
	List<Endereco> findByCliente(Optional<Cliente> cliente);

}
