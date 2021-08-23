package first.project.api.item.controller;

import first.project.api.item.domain.Item;
import first.project.api.item.repository.ItemRepository;
import first.project.api.item.service.ItemService;
import first.project.api.item.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public List<Item> findAll() {
        return itemService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable long id) {
        return itemService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable long id) {
        return itemService.existsById(id);
    }

    @GetMapping("/count")
    public long count() {
        return itemService.count();
    }

    @DeleteMapping
    public void deleteById(long id) {
        itemService.deleteById(id);
    }

    @PostMapping
    public void save(Item item) {
        itemService.save(item);
    }

    @PutMapping
    public void update(Item item) {
        itemService.save(item);
    }
}
