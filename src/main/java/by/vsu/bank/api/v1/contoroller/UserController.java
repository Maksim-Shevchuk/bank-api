package by.vsu.bank.api.v1.contoroller;

import by.vsu.bank.model.user.User;
import by.vsu.bank.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@RequestBody @Valid User user) {
        return userService.saveUser(user);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<User> findAll(@RequestParam(defaultValue = "0") @Positive int page,
                              @RequestParam(defaultValue = "20") @Positive int size) {
        return userService.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User findUserById(@PathVariable @Valid long id) {
        return userService.findUserById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUserById(@PathVariable @Valid long id) {
        userService.deleteUserById(id);
    }

}
