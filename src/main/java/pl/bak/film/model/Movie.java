package pl.bak.film.model;

import javax.validation.constraints.NotEmpty;
import java.util.Objects;

public class Movie {

    private Long id;
    private String tittle;
    private String director;
    private int yearOfProduction;

    public Movie(@NotEmpty String tittle, String director, int yearOfProduction) {
        this.tittle = tittle;
        this.director = director;
        this.yearOfProduction = yearOfProduction;
    }

    public Movie() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return yearOfProduction == movie.yearOfProduction &&
                Objects.equals(id, movie.id) &&
                Objects.equals(tittle, movie.tittle) &&
                Objects.equals(director, movie.director);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tittle, director, yearOfProduction);
    }
}
