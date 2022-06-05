package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stadium.controller.base.BaseController;
import org.stadium.dto.RequestDto;
import org.stadium.service.RequestService;


@RestController
@RequestMapping("/api/request")
@RequiredArgsConstructor
public class RequestController extends BaseController {
    private final RequestService service;

    @GetMapping("/admin/{username}")
    public ResponseEntity<?> getRequestsByUsernameAndStatus(@PathVariable final String username,
                                                            @RequestParam final String status) {
        return doCall(() -> service.findAll(username, status));
    }

    @GetMapping
    public ResponseEntity<?> getRequests(@RequestParam final String username) {
        return doCall(() -> service.findAll(username));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRequestById(@PathVariable final Integer id) {
        return doCall(() -> service.findById(id));
    }

    @PostMapping
    public ResponseEntity<?> createRequest(@RequestBody final RequestDto dto) {
        return doCall(() -> service.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRequest(@PathVariable final Integer id,
                                           @RequestBody final RequestDto dto) {
        return doCall(() -> service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRequest(@PathVariable final Integer id) {
        return doCall(() -> service.delete(id));
    }
}
