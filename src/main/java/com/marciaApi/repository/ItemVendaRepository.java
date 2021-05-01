package com.marciaApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marciaApi.model.ItemVenda;
import com.marciaApi.model.Venda;

public interface ItemVendaRepository extends JpaRepository<ItemVenda, Long>{
	
	List<ItemVenda> findByVenda(Venda venda);

}
