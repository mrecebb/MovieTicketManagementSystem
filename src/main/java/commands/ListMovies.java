package commands;

import interfaces.Command;
import interfaces.MovieRepository;
import movie.Movie;

import java.io.IOException;
import java.util.List;

public class ListMovies implements Command {
    MovieRepository movieRepository;

    public ListMovies(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public String commandName() {
        return "List Movies";
    }

    @Override
    public void process() throws IOException {
        List<Movie> movies = movieRepository.findAll();

        if (movies.isEmpty()) {
            System.out.println("No movies found");
        } else {
            for (Movie movie : movies) {
                System.out.println(movie);
            }
        }
    }
}
