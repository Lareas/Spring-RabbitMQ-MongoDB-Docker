package com.btgtest.listener;

import com.btgtest.listener.dto.PedidoDTO;
import com.btgtest.service.PedidoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import static com.btgtest.configuration.AppConstants.BTG_PEDIDOS_QUEUE;

@Component
public class PedidoListener {

    private final PedidoService pedidoService;

    public PedidoListener(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @RabbitListener(queues = BTG_PEDIDOS_QUEUE)
    public void listen(Message<PedidoDTO> message){
        System.out.println("Message consumed: " + message);

        pedidoService.save(message.getPayload());
    }
}
