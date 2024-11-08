package co.pragra.learning.productmanagerdemo.controller;

import co.pragra.learning.productmanagerdemo.entity.User;
import co.pragra.learning.productmanagerdemo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/api/user")
    public User createUser(@RequestBody User user){
      return this.userService.createUser(user);
    }

    @GetMapping("/api/user")
    public List<User> getAllUsers(@RequestParam(value = "firstName", required =false) Optional<String> firstName,
                                  @RequestParam(value = "lastName", required =false) Optional<String> lastName){
        return this.userService.findAllByFilters(firstName, lastName);
    }

    @GetMapping("/api/user/{id}")
    public Optional<User> findById(@PathVariable("id") Long id){
        return this.userService.findById(id);
    }
}
