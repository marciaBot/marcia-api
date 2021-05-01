package com.marciaApi.service;

import com.marciaApi.model.Produto;
import com.marciaApi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto buscarPorCodigo (String codigoBarra) {
        Produto produto = produtoRepository.findByCodigoBarra(codigoBarra);
        return produto;
    }
    
    public Produto buscarPorId (Long id) {
    	Produto produto = produtoRepository.findById(id).get();
    	return produto;
    }
}
