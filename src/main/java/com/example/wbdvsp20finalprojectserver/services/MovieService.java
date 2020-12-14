package com.example.wbdvsp20finalprojectserver.services;

import com.example.wbdvsp20finalprojectserver.models.Movie;
import com.example.wbdvsp20finalprojectserver.models.User;
import com.example.wbdvsp20finalprojectserver.repositories.MovieRepository;
import com.example.wbdvsp20finalprojectserver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    UserRepository userRepository;

    public List<Movie> findAllMovies() {
        return movieRepository.findAllMovies();
    }

    public Movie findMovieById(String mid) {
        return movieRepository.findMovieById(mid);
    }


    public int deleteMovie(int mid) {
        movieRepository.deleteById(mid);
        return 1;
    }

    public int updateMovie(String mid, Movie newMovie) {
        Movie movie =  movieRepository.findMovieById(mid);
        movie.setTitle(newMovie.getTitle());
        movieRepository.save(movie);
        return 1;
    }

    public Movie createMovie(Movie newMovie) {
        return movieRepository.save(newMovie);
    }

    public List<Movie> findAllLikedMovieForUser(int userId) {
        return userRepository.findUserById(userId).getLikedMovies();
    }
}
