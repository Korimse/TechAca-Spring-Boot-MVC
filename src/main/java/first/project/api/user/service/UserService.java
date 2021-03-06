package first.project.api.user.service;

import first.project.api.user.domain.User;
import first.project.api.user.domain.UserDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface UserService {

    List<User> findAll();
    Optional<User> findById(long id);
    boolean existsById(long id);
    long count();
    void deleteById(long id);
    void save(User user);
    String signup(User user);
    UserDto signin(User user);

}
