package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.stadium.controller.base.BaseController;
import org.stadium.dto.UserDto;
import org.stadium.service.EmailService;
import org.stadium.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController extends BaseController {
    private final UserService userService;
    private final EmailService emailService;

    @GetMapping
    public ResponseEntity<?> getUsers() {
        return doCall(userService::getLoggedInUser);
    }

    @PutMapping()
    public ResponseEntity<?> updateLoggedInUser(@RequestBody final UserDto userDto) {
        return doCall(() -> userService.update(userDto, userService.getLoggedInUser().getId()));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody final UserDto user) {
        return doCall(() -> userService.create(user));
    }

}
