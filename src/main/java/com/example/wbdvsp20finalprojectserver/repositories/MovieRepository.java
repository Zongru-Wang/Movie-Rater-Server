package com.example.wbdvsp20finalprojectserver.repositories;

import com.example.wbdvsp20finalprojectserver.models.Movie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository
        extends CrudRepository<Movie, Integer> {

    @Query("SELECT movie FROM Movie movie")
    public List<Movie> findAllMovies();

    @Query("SELECT movie FROM Movie movie WHERE movie.imdbId=:mid")
    public Movie findMovieById(
            @Param("mid") String mid);


}
