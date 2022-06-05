package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stadium.controller.base.BaseController;
import org.stadium.service.UserService;


@RestController
@RequestMapping("/api/change-password")
@RequiredArgsConstructor
public class ChangePasswordController extends BaseController {
    private final UserService service;


    @PutMapping
    public ResponseEntity<?> changePassword(@RequestParam final String oldPassword,
                                            @RequestParam final String newPassword) {
        return doCall(() -> service.changePassword(oldPassword, newPassword));
    }
}
