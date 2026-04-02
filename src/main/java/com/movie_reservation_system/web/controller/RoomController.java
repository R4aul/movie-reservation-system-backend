package com.movie_reservation_system.web.controller;

import com.movie_reservation_system.domain.dto.Room;
import com.movie_reservation_system.domain.dto.RoomWithSeatDTO;
import com.movie_reservation_system.domain.service.RoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rooms")
@AllArgsConstructor
public class RoomController {

    private final RoomService roomService;

    @GetMapping("/all")
    public ResponseEntity<List<Room>> all(){
        return ResponseEntity.ok(roomService.all());
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Room> get(@PathVariable int id){
        return ResponseEntity.ok(roomService.getById(id));
    }

    @GetMapping("/{id}/seats")
    public ResponseEntity<RoomWithSeatDTO> getWithSeats(@PathVariable int id){
        return ResponseEntity.ok(roomService.getRoomWithSeats(id));
    }

}
