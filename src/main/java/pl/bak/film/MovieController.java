package pl.bak.film;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.bak.film.model.Movie;

import java.util.List;


@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @GetMapping("/{id}")
    public Movie getOneMovie(@PathVariable("id") long movieId) {
        return movieService.findById(movieId);

    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.findAll();
    }


}
