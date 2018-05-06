package pl.bak.film;

import pl.bak.film.model.Movie;

import java.util.List;

public interface MovieRepository {

    Movie findById(Long id);

    Movie save(Movie movie);

    List<Movie> findAll();

    void deleteAll();
}
