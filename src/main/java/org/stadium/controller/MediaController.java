package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.stadium.controller.base.BaseController;
import org.stadium.service.MediaService;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController extends BaseController {
    private final MediaService service;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestParam final MultipartFile image,
                                      @RequestParam final String filename) {
        return doCall(() -> service.create(image, filename));
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> getImage(@PathVariable final String name) {
        return doCall(() -> service.getImage(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable final Integer id) {
        return doCall(() -> service.delete(id));
    }
}
