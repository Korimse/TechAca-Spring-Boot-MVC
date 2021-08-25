package first.project.api.item.controller;

import first.project.api.item.domain.Item;
import first.project.api.item.repository.ItemRepository;
import first.project.api.item.service.ItemService;
import first.project.api.item.service.ItemServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Api
@RestController
@RequestMapping("/items")
@CrossOrigin(origins = "*", allowCredentials = "false")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public ResponseEntity<List<Item>> findAll() {
        return ResponseEntity.ok(itemService.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable long id) {
        return ResponseEntity.ok(itemService.findById(id));
    }

    @GetMapping("/exists/{id}")
    public ResponseEntity<Boolean> existsById(@PathVariable long id) {
        return ResponseEntity.ok(itemService.existsById(id));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> count() {
        return new ResponseEntity(itemService.count(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        itemService.deleteById(id);
    }

    @PostMapping
    public void save(@RequestBody Item item) {
        itemService.save(item);
    }

    @PutMapping
    public void update(@RequestBody Item item) {
        itemService.save(item);
    }

    @DeleteMapping
    @ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"),
            @ApiResponse(code = 403, message = "Access Denied"),
            @ApiResponse(code = 422, message = "Item is alredy in use") })
    public void deleteAll() {
        itemService.deleteAll();
    }
}
