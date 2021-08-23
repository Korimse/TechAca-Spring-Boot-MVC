package first.project.api.order.controller;

import first.project.api.order.domain.Order;
import first.project.api.order.repository.OrderRepository;
import first.project.api.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public List<Order> findAll() {
        return orderService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Order> findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable long id) {
        return orderService.existsById(id);
    }

    @GetMapping("/count")
    public long count() {
        return orderService.count();
    }

    @DeleteMapping
    public void deleteById(long id) {
        orderService.deleteById(id);
    }

    @PostMapping
    public void save(Order order) {
        orderService.save(order);
    }

    @PutMapping
    public void update(Order order) {
        orderService.save(order);
    }
}
