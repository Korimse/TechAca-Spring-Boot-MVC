package first.project.api.user.controller;

import first.project.api.user.domain.User;
import first.project.api.user.repository.UserRepository;
import first.project.api.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable long id) {
        return userService.findById(id);
    }

    @GetMapping("/exists/{id}")
    public boolean existsById(@PathVariable long id) {
        return userService.existsById(id);
    }

    @GetMapping("/count")
    public long count() {
        return userService.count();
    }

    @DeleteMapping
    public void deleteById(long id) {
        userService.deleteById(id);
    }

    @PostMapping
    public void save(User user) {
        userService.save(user);
    }

    @PutMapping
    public void update(User user) {
        userService.save(user);
    }
}
