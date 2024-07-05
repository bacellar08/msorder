package io.github.bacellar08.btgpactual.msorder.service;

import io.github.bacellar08.btgpactual.msorder.controller.dto.OrderResponse;
import io.github.bacellar08.btgpactual.msorder.domain.Item;
import io.github.bacellar08.btgpactual.msorder.domain.Order;
import io.github.bacellar08.btgpactual.msorder.listener.dto.OrderCreatedEvent;
import io.github.bacellar08.btgpactual.msorder.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void save(OrderCreatedEvent event) {

        var entity = new Order();

        entity.setOrderId(event.codigoPedido());
        entity.setCustomerId(event.codigoCliente());
        entity.setItems(getOrderItems(event));
        entity.setTotal(getTotal(event));
        orderRepository.save(entity);

    }

    public Page<OrderResponse> findAllByCustomerId(Long customerId, PageRequest pageRequest) {
        var orders = orderRepository.findAllByCustomerId(customerId, pageRequest);

        return orders.map(OrderResponse::fromEntity);
    }

    private static BigDecimal getTotal(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(item -> item.preco().multiply(BigDecimal.valueOf(item.quantidade())))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }

    private static List<Item> getOrderItems(OrderCreatedEvent event) {
        return event.itens().stream()
                .map(item -> new Item(item.produto(), item.quantidade(), item.preco()))
                .toList();
    }
}
