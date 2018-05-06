package pl.bak.film;

import org.springframework.stereotype.Repository;
import pl.bak.film.model.Movie;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;


@Repository
public class InMemoryMovieRepository implements MovieRepository {

    private AtomicLong nextId = new AtomicLong(0);
    private Map<Long, Movie> movieById = new ConcurrentHashMap<>();

    @Override
    public Movie findById(Long movieId) {
        return movieById.get(movieId);
    }

    @Override
    public Movie save(Movie movie) {
        if (movie.getId()== null) {
            final Long newId = nextId.incrementAndGet();
            movie.setId(newId);
        }
        movieById.put(movie.getId(), movie);
        return movie;
    }

    @Override
    public List<Movie> findAll() {
        return new ArrayList<>(movieById.values());
    }

    @Override
    public void deleteAll() {
        movieById.clear();
    }
}
