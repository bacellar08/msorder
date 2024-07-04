package io.github.bacellar08.btgpactual.msorder.listener.dto;

import java.util.List;

public record OrderCreatedEvent(Long codigoPedido,
                                Long codigoCliente,
                                List<ItemEvent> itens) {
}
