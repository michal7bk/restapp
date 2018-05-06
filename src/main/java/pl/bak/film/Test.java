package pl.bak.film;

import pl.bak.film.model.Movie;

public class Test {
    public static void main(String[] args) {
        InMemoryMovieRepository inMemoryMovieRepository = new InMemoryMovieRepository();
        Movie newMovie = new Movie("Potop", "Hoffman", 1974);

        inMemoryMovieRepository.save(newMovie);
        System.out.println(inMemoryMovieRepository.findById(newMovie.getId()));


    }
}
