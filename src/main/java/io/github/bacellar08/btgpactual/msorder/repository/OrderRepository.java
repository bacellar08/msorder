package io.github.bacellar08.btgpactual.msorder.repository;

import io.github.bacellar08.btgpactual.msorder.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface OrderRepository extends MongoRepository<Order, Long> {
}
