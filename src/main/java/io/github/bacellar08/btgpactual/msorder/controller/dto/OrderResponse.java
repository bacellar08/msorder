package io.github.bacellar08.btgpactual.msorder.controller.dto;

import io.github.bacellar08.btgpactual.msorder.domain.Order;

import java.math.BigDecimal;

public record OrderResponse(Long orderId,
                            Long customerId,
                            BigDecimal totalPrice) {

    public static OrderResponse fromEntity(Order entity) {
        return new OrderResponse(entity.getOrderId(), entity.getCustomerId(), entity.getTotal());
    }
}
