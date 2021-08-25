package first.project.api.item.service;

import first.project.api.item.domain.Item;
import first.project.api.user.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface ItemService {
    List<Item> findAll();
    Optional<Item> findById(long id);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    void save(Item item);
    void deleteAll();
}
