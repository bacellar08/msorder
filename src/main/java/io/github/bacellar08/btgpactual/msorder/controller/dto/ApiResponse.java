package io.github.bacellar08.btgpactual.msorder.controller.dto;

import java.util.List;

public record ApiResponse<T>(List<T> data, PaginationResponse pagination) {
}
