package com.btgtest.listener.dto;

import java.util.List;

public record PedidoDTO(Long codigoPedido,
                        Long codigoCliente,
                        List<ItemPedidoDTO> itens) {
}
