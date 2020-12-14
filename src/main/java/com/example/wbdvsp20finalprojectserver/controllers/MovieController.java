package com.example.wbdvsp20finalprojectserver.controllers;

import com.example.wbdvsp20finalprojectserver.models.User;
import com.example.wbdvsp20finalprojectserver.services.MovieService;
import com.example.wbdvsp20finalprojectserver.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MovieController {

    @Autowired
    MovieService movieService;

//    @PutMapping("/api/movies/{id}")
//    public void updateMovie(
//            @PathVariable("id") int id,
//            @RequestBody Movie newMovie
//            ) {
//        return
//        MovieService dao = MovieService.getInstance();
//        dao.pupdateMovie(id, newMovie);
//    }

    @DeleteMapping("/api/movies/{id}")
    public int deleteMovie(@PathVariable("id") int id) {
        return movieService.deleteMovie(id);
    }
    @PostMapping("/api/movies")
    public Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }
    @GetMapping("/api/movies/{id}")
    public Movie findMovieById(@PathVariable("id") String id) {
        return movieService.findMovieById(id);
    }
    @GetMapping("/api/movies")
    public List<Movie> findAllMovies() {
        return movieService.findAllMovies();
    }

    @GetMapping("/api/users/{userId}/liked")
    public List<Movie> findAllLikedMovieForUser(
            @PathVariable("userId") int userId) {
        return movieService.findAllLikedMovieForUser(userId);
    }
}
