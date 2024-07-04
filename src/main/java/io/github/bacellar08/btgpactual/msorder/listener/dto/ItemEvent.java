package io.github.bacellar08.btgpactual.msorder.listener.dto;

import java.math.BigDecimal;

public record ItemEvent(String produto,
                        Long quantidade,
                        BigDecimal preco) {
}
