package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stadium.controller.base.BaseController;
import org.stadium.dto.StadiumDto;
import org.stadium.service.StadiumService;


@RestController
@RequestMapping("/api/stadium")
@RequiredArgsConstructor
public class StadiumController extends BaseController {
    private final StadiumService service;

    @GetMapping("/admin/{username}")
    public ResponseEntity<?> getStadiumsByAdmin(@PathVariable final String username) {
        return doCall(() -> service.findAll(username));
    }

    @GetMapping
    public ResponseEntity<?> getStadiums(@RequestParam(required = false) final String searchKey,
                                         @RequestParam(required = false) final Integer minPrice,
                                         @RequestParam(required = false) final Integer maxPrice,
                                         @RequestParam(required = false) final String name) {
        return doCall(() -> service.findAll(searchKey, minPrice, maxPrice, name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getStadiumById(@PathVariable final Integer id) {
        return doCall(() -> service.findById(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createStadium(@RequestBody final StadiumDto dto) {
        return doCall(() -> service.create(dto));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateStadium(@PathVariable final Integer id,
                                           @RequestBody final StadiumDto dto) {
        return doCall(() -> service.update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStadium(@PathVariable final Integer id) {
        return doCall(() -> service.delete(id));
    }
}
