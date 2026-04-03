package com.movie_reservation_system.web.controller;

import com.movie_reservation_system.domain.dto.CreateMovieRequest;
import com.movie_reservation_system.domain.dto.Movie;
import com.movie_reservation_system.domain.dto.MovieShowTimes;
import com.movie_reservation_system.domain.dto.UpdateMovieRequest;
import com.movie_reservation_system.domain.service.MovieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    private final MovieService movieService;

    @GetMapping("/all")
    public ResponseEntity<Page<Movie>> all(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int elements
    ){
       return ResponseEntity.ok(this.movieService.getAll(page,elements));
    }

    @PostMapping("/save")
    public ResponseEntity<Movie> save(@RequestBody @Valid CreateMovieRequest request){
        System.out.println(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.movieService.create(request));
    }

    @GetMapping("/{id}/get")
    public ResponseEntity<Movie> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(this.movieService.getById(id));
    }

    @PutMapping("/{movieId}/update")
    public ResponseEntity<Movie> update(
            @RequestBody @Valid UpdateMovieRequest request, @PathVariable("movieId") int id
    ){
       return ResponseEntity.ok(this.movieService.update(request,id));
    }

    @DeleteMapping("/{movieId}/delete")
    public ResponseEntity<Boolean> delete(@PathVariable("movieId") int id){
       return ResponseEntity.ok(this.movieService.delete(id));
    }

    @GetMapping("/{movieId}/showtimes")
    public ResponseEntity<MovieShowTimes> showTimes(@PathVariable("movieId") long id){
        return ResponseEntity.ok(this.movieService.showTimes(id));
    }
}
