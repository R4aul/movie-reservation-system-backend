package com.movie_reservation_system.web.controller;

import com.movie_reservation_system.domain.dto.CreateShowTimeRequest;
import com.movie_reservation_system.domain.dto.ShowTime;
import com.movie_reservation_system.domain.service.ShowTimeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/showtimes")
@RequiredArgsConstructor
public class ShowTimeController {

    private final ShowTimeService showTimeService;

    @GetMapping("/all")
    public ResponseEntity<Page<ShowTime>> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int elements,
            @RequestParam(required = false) Integer roomId,
            @RequestParam(required = false) Long movieId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date
            ){
        return ResponseEntity.ok(this.showTimeService.all(page,elements,roomId,movieId, date));
    }

    @PostMapping("/create")
    private ResponseEntity<ShowTime> create(
            @RequestBody @Valid CreateShowTimeRequest request
            ){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.showTimeService.create(request));
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<ShowTime> get(@PathVariable long id){
        return ResponseEntity.ok(this.showTimeService.get(id));
    }



}
