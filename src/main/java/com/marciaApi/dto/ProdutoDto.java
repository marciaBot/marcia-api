package com.marciaApi.dto;

import com.marciaApi.model.Produto;

import java.math.BigDecimal;

public class ProdutoDto {
	private Long id;
	private String nome;
    private String codigoBarra;
    private BigDecimal preco;

    public ProdutoDto(Produto produto) {
    	this.id = produto.getId();
        this.nome = produto.getNome();
        this.codigoBarra = produto.getCodigoBarra();
        this.preco = produto.getPreco();
    }

    public static ProdutoDto converter(Produto produto) {return new ProdutoDto(produto);}

    public String getNome() {
        return nome;
    }
    
    public Long getId() {
		return id;
	}

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public BigDecimal getPreco() {
        return preco;
    }
}
