package com.btgtest.entity;

import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;

import java.math.BigDecimal;

public class ItemPedido {

    private String produto;
    private Integer quantidade;

    @Field(targetType = FieldType.DECIMAL128)
    private BigDecimal preco;

    public ItemPedido() {
    }

    public ItemPedido(String produto, Integer quantidade, BigDecimal precoUnitario) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.preco = precoUnitario;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return preco;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.preco = precoUnitario;
    }
}

