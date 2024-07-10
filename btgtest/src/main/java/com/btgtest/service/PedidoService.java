package com.btgtest.service;

import com.btgtest.controller.dto.PedidoResponse;
import com.btgtest.entity.Pedido;
import com.btgtest.entity.ItemPedido;
import com.btgtest.listener.dto.PedidoDTO;
import com.btgtest.repository.PedidoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    public void save(PedidoDTO pedidoDTO) {

        var pedido = new Pedido();

        pedido.setPedidoId(pedidoDTO.codigoPedido());
        pedido.setClienteId(pedidoDTO.codigoCliente());
        pedido.setItens(getItensPedido(pedidoDTO));
        pedido.setTotalPedido(getTotalPedido(pedidoDTO));

        pedidoRepository.save(pedido);

    }

    public Page<PedidoResponse> findAllByClienteId(Long clienteId, PageRequest pageRequest) {
        var pedidos = pedidoRepository.findAllByClienteId(clienteId, pageRequest);

        return pedidos.map(PedidoResponse::fromEntity);
    }

    private BigDecimal getTotalPedido(PedidoDTO event) {
        return event.itens()
                .stream()
                .map(i -> i.preco().multiply(BigDecimal.valueOf(i.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<ItemPedido> getItensPedido(PedidoDTO event) {
        return event.itens().stream()
                .map(i -> new ItemPedido(i.produto(), i.quantidade(), i.preco()))
                .toList();
    }
}
