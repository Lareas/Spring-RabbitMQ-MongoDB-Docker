package com.btgtest.controller;

import com.btgtest.controller.dto.ApiResponse;
import com.btgtest.controller.dto.PedidoResponse;
import com.btgtest.controller.dto.PaginationResponse;
import com.btgtest.service.PedidoService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class PedidoController {

    private final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @GetMapping("/clientes/{clienteId}/pedidos")
    public ResponseEntity<ApiResponse<PedidoResponse>> listOrders(@PathVariable("clienteId") Long clienteId,
                                                                  @RequestParam(name = "page", defaultValue = "0") Integer page,
                                                                  @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize){

        var pageResponse = pedidoService.findAllByClienteId(clienteId, PageRequest.of(page, pageSize));

        return ResponseEntity.ok(new ApiResponse<>(
                pageResponse.getContent(),
                PaginationResponse.fromPage(pageResponse)
        ));
    }
}
