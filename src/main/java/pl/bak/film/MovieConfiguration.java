package pl.bak.film;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfiguration {

    @Bean
    MovieService movieService(MovieRepository movieRepository){
        return new MovieService(movieRepository);
    }


}
