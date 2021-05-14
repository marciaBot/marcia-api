package com.marciaApi.controller;

import com.marciaApi.dto.ProdutoDto;
import com.marciaApi.exception.ApiNotFoundException;
import com.marciaApi.model.Produto;
import com.marciaApi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/codigo/{codigoBarra}")
    public ResponseEntity<?> buscaProdutoByCodigo(@PathVariable String codigoBarra){
        try {
            Produto produto = produtoService.buscarPorCodigo(codigoBarra);

            return ResponseEntity.ok().body(new ProdutoDto(produto));
        }catch (Exception e){
            throw new ApiNotFoundException("Código não encontrado", e.getCause());
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> buscaProdutoById(@PathVariable Long id){
        try {
            Produto produto = produtoService.buscarPorId(id);

            return ResponseEntity.ok().body(new ProdutoDto(produto));
        }catch (Exception e){
            throw new ApiNotFoundException("Id não encontrado", e.getCause());
        }
    }
    
    @GetMapping("/nome/{nome}")
    public ResponseEntity<?> buscaProdutoById(@PathVariable String nome){
        try {
            Produto produto = produtoService.buscarPorNome(nome);

            return ResponseEntity.ok().body(new ProdutoDto(produto));
        }catch (Exception e){
            throw new ApiNotFoundException("Produto não encontrado", e.getCause());
        }
    }

}
