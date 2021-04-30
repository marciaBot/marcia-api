package com.marciaApi.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "VENDA")
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemVenda> vendasList;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinColumn(name = "CLIENTE_ID", referencedColumnName = "id")
	private Cliente cliente;

	@Transient
	private Long clienteId;
	
	@Column(name = "VALOR_TOTAL")
	@JsonIgnore
	@JsonProperty(value = "valorTotal", access = Access.READ_ONLY)
	private BigDecimal valorTotal;
	
	@Column(name = "CREATED_AT", updatable = false)
	@CreationTimestamp
	private LocalDateTime created_at;
	
	@Column(name = "UPDATED_AT")
	@UpdateTimestamp
	private LocalDateTime updated_at;

	public LocalDateTime getCreated_at() {
		return created_at;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}
	
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public List<ItemVenda> getVendasList() {
		return vendasList;
	}

	public void setVendasList(List<ItemVenda> vendasList) {
		this.vendasList = vendasList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
