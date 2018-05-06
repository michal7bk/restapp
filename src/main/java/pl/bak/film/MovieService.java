package pl.bak.film;

import pl.bak.film.model.Movie;

import java.util.List;

class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public Movie findById(Long movieId){
        Movie movie= movieRepository.findById(movieId);
        if (movie == null){
            throw new IllegalArgumentException();
        }
        return movie;
    }

    public List<Movie> findAll() {
        return movieRepository.findAll();
    }
}
