package com.btgtest.listener.dto;

import java.math.BigDecimal;

public record ItemPedidoDTO(
        String produto,
        Integer quantidade,
        BigDecimal preco) {
}
