package com.btgtest.controller.dto;

import com.btgtest.entity.Pedido;

import java.math.BigDecimal;

public record PedidoResponse(
        Long pedidoId,
        Long clienteId,
        BigDecimal total) {

    public static PedidoResponse fromEntity(Pedido pedido) {
        return new PedidoResponse(pedido.getPedidoId(), pedido.getClienteId(), pedido.getTotalPedido());
    }
}
