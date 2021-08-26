package first.project.api.user.controller;

import first.project.api.user.domain.User;
import first.project.api.user.domain.UserDto;
import first.project.api.user.repository.UserRepository;
import first.project.api.user.service.UserService;
import first.project.api.user.service.UserServiceImpl;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Api(tags = "users")
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceImpl userService;
    private final ModelMapper modelMapper;

    @PostMapping("/signup")
    @ApiOperation(value = "${UserController.signup}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code = 403, message = "승인 거절"),
            @ApiResponse(code = 422, message = "중복된 username")
    })
    public ResponseEntity<String> signup(@ApiParam("Signup User") @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(modelMapper.map(userDto, User.class)));
    }

    @PostMapping("/signin")
    @ApiOperation(value = "${UserController.signin}")
    @ApiResponses(value={
            @ApiResponse(code=400, message = "something wrong"),
            @ApiResponse(code = 422, message = "유효하지 않은 아이디 / 비밀번호")
    })
    public ResponseEntity<UserDto> signin(@ApiParam("Signin User") @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signin(modelMapper.map(userDto, User.class)));
    }

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
