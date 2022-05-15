package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.stadium.controller.base.BaseController;
import org.stadium.dto.LocationDto;
import org.stadium.service.LocationService;

@RestController
@RequestMapping("/api/location")
@RequiredArgsConstructor
public class LocationController extends BaseController {
    private final LocationService service;

    @GetMapping
    public ResponseEntity<?> getLocations() {
        return doCall(service::findAll);
    }

    @PostMapping
    public ResponseEntity<?> creatLocation(@RequestBody final LocationDto locationDto) {
        return doCall(() -> service.create(locationDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateLocation(@PathVariable final Integer id,
                                            @RequestBody final LocationDto locationDto) {
        return doCall(() -> service.update(locationDto, id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getLocationById(@PathVariable final Integer id) {
        return doCall(() -> service.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLocation(@PathVariable final Integer id) {
        return doCall(() -> service.delete(id));
    }
}
