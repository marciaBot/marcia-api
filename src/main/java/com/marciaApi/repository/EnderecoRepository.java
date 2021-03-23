package com.marciaApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciaApi.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
