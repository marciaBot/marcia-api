package com.marciaApi.dto;

import java.math.BigDecimal;

import com.marciaApi.model.Cliente;
import com.marciaApi.model.Venda;

public class VendaClienteDto {

    private Long id;

    private Long clienteId;

    private String nomeCliente;

    private BigDecimal valorTotal;

    private String obs;

    private Boolean aprovado;


    public VendaClienteDto(Venda venda, Cliente cliente) {
        this.id = venda.getId();
        this.clienteId = venda.getClienteId() != null ? venda.getClienteId() : venda.getCliente().getId();
        this.valorTotal = venda.getValorTotal();
        this.obs = venda.getObs();
        this.aprovado = venda.getAprovado();
        this.nomeCliente =  cliente != null ? cliente.getNome() : null;
    }

    public static VendaClienteDto converter(Venda venda, Cliente cliente) {
        return new VendaClienteDto(venda, cliente);
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public String getObs() {
        return obs;
    }

    public Long getId() {
        return id;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {return nomeCliente;}

}
