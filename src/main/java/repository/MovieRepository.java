package repository;

import domain.Movie;

import java.io.IOException;
import java.util.List;

public interface MovieRepository {
    List<Movie> findAll() throws IOException;

    void saveAll(List<Movie> movies) throws IOException;
}
