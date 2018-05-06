package pl.bak.film;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import pl.bak.film.model.Movie;

import static org.mockito.ArgumentMatchers.eq;

import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.assertj.core.api.Assertions.assertThat;


public class MovieServiceTest {

    private MovieService movieService;


    @Mock
    private MovieRepository movieRepository;

    @Before
    public void setUp(){
        initMocks(this);
        this.movieService = new MovieService(movieRepository);
    }


    @Test
    public void shouldAddMovie(){
        //given
        Movie newMovie = new Movie("Potop", "Hoffman", 1974);
        given(movieRepository.save(eq(newMovie))).willReturn(newMovie);
        //when
        Movie resultMovie = movieService.addMovie(newMovie);
        //then
        assertThat(resultMovie).isEqualTo(newMovie);
    }

    @Test
    public void shouldFindMovieById(){
        //given
        long id = 24L;
        Movie newMovie = new Movie("Potop", "Hoffman", 1974);
        newMovie.setId(id);
        given(movieRepository.findById(eq(id))).willReturn(newMovie);
        //when
        Movie resultMovie = movieService.findById(id);
        //then
        assertThat(resultMovie).isEqualTo(newMovie);
    }
































}