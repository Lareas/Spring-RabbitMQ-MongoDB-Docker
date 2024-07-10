package com.btgtest.repository;

import com.btgtest.entity.Pedido;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PedidoRepository extends MongoRepository<Pedido, Long> {

    Page<Pedido> findAllByClienteId(Long clienteId, PageRequest pageRequest);
}
