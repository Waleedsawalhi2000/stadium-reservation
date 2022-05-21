package org.stadium.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stadium.controller.base.BaseController;
import org.stadium.dto.EmailDto;
import org.stadium.service.EmailService;

@RestController
@RequestMapping("/api/email")
@RequiredArgsConstructor
public class EmailController extends BaseController {
    private final EmailService service;

    @PostMapping("/change-password")
    public ResponseEntity<?> sendPasswordVerificationCode(@RequestParam final String email) {
        return doCall(() -> service.sendPasswordToEmail(email));
    }

    @PostMapping("/verify")
    public ResponseEntity<?> sendEmailVerificationCode(@RequestParam final String email) {
        return doCall(() -> service.sendEmailVerificationCode(email));
    }
}
