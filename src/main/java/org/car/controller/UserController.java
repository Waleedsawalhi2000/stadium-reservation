package org.car.controller;

import lombok.RequiredArgsConstructor;
import org.car.controller.base.BaseController;
import org.car.entity.UserDto;
import org.car.service.UserService;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService service;

    @GetMapping
    public ResponseEntity<?> getUsers(@RequestParam final Integer page,
                                      @RequestParam final Integer size) {
        return doCall(() -> service.findAll(PageRequest.of(page, size)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable final Integer id) {
        return doCall(() -> service.findById(id));
    }

    @GetMapping("/email")
    public ResponseEntity<?> getUserByEmail(@RequestParam final String email) {
        return doCall(() -> service.findByEmail(email));
    }

    @GetMapping("/username")
    public ResponseEntity<?> getUserByUsername(@RequestParam final String username) {
        return doCall(() -> service.findByUsername(username));
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody final UserDto user) {
        return doCall(() -> service.create(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable final Integer id,
                                        @RequestBody final UserDto user) {
        return doCall(() -> service.update(user, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable final Integer id) {
        return doCall(() -> service.delete(id));
    }

}
