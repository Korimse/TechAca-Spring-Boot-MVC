package first.project.api.order.service;

import first.project.api.item.domain.Item;
import first.project.api.order.domain.Order;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface OrderService {
    List<Order> findAll();
    Optional<Order> findById(long id);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    void save(Order order);
}
