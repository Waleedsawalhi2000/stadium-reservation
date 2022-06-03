package org.stadium.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.stadium.controller.base.BaseController;
import org.stadium.repository.AvailableTimeRepository;
import org.stadium.repository.RequestRepository;
import org.stadium.service.AvailableTimeService;

import java.time.LocalDate;


@RestController
@RequestMapping("/api/test")
@RequiredArgsConstructor
public class TestAvailableHour extends BaseController {
    final AvailableTimeService service;

    @GetMapping
    public ResponseEntity<?> getAvailableTime(@RequestParam final Integer stadiumId,
                                              @RequestParam final Integer value,
                                              @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) final LocalDate date) {
        return doCall(() -> service.getAvailableTime(stadiumId,value, date));
    }
}
