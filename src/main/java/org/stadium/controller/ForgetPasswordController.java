package org.stadium.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stadium.controller.base.BaseController;
import org.stadium.service.EmailService;

@RestController
@RequestMapping("/api/forget-password/{code}")
@RequiredArgsConstructor
public class ForgetPasswordController extends BaseController {
    private final EmailService service;

    @PutMapping()
    public ResponseEntity<?> changePassword(@PathVariable final Integer code,
                                            @RequestParam final String password,
                                            @RequestParam final String email) {
        return doCall(() -> service.changePassword(code, password, email));
    }

    @GetMapping
    public ResponseEntity<?> isCodeExist(@PathVariable final Integer code) {
        return doCall(() -> service.isCodeExist(code));
    }
}
