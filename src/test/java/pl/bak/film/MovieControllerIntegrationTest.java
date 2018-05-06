package pl.bak.film;


import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import pl.bak.film.model.Movie;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
        classes = MovieApplication.class
)
@AutoConfigureWebMvc
public class MovieControllerIntegrationTest {

    @Autowired
    private TestRestTemplate template;

    @Autowired
    private MovieRepository repository;

    @After
    public void resetDb() {
        repository.deleteAll();
    }

    @Test
    public void shouldCreateNewMovie() {
        //given
        String director = "dir";
        Movie newMovie = new Movie("test m", director, 2018);
        //when
        ResponseEntity<Movie> responseEntity = template.postForEntity("/movies", newMovie, Movie.class);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
        Movie responseMovie = responseEntity.getBody();
        assertThat(responseMovie).isNotNull();
        assertThat(responseMovie.getId()).isNotNull();
        assertThat(responseMovie.getDirector()).isEqualTo(director);

    }

    @Test
    public void shouldFindMovies() {
        //given
        Movie testMovie1 = createTestMovie("test 1");
        Movie testMovie2 = createTestMovie("test 2");
        //when
        ResponseEntity<List<Movie>> moviesResponse =
                template.exchange("/movies",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Movie>>() {
                        });
        List<Movie> movies = moviesResponse.getBody();
        //then
        assertThat(movies).containsExactly(testMovie1, testMovie2);

    }

    @Test
    public void shouldFindMoviebyId() {
        //given
        Movie testMovie1 = createTestMovie("test 1");
        //when
        ResponseEntity<Movie> moviesResponse = template.getForEntity("/movies/" + testMovie1.getId(), Movie.class);
        Movie movie = moviesResponse.getBody();
        //then
        assertThat(movie).isEqualTo(testMovie1);
    }

    private Movie createTestMovie(String title) {
        Movie movie = new Movie(title, "dir", 2018);
        repository.save(movie);
        return movie;
    }

}