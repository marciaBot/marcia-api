package com.marciaApi.model;


import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PRODUTO")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "NOME")
    private String nome;

    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;

    @Column(name = "PRECO")
    private BigDecimal preco;
    
    @OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	private List<ItemVenda> ItemVenda;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ItemVenda> getItemVenda() {
		return ItemVenda;
	}

	public void setItemVenda(List<ItemVenda> itemVenda) {
		ItemVenda = itemVenda;
	}
    
    
}
