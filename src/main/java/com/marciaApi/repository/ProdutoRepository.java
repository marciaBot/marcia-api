package com.marciaApi.repository;

import com.marciaApi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByCodigoBarra(String codigoBarra);
    
    Produto findByNome(String nome);
}
