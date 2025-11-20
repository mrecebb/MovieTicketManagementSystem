package ui.commands;

import repository.MovieRepository;
import domain.Movie;

import java.io.IOException;
import java.util.List;

public class ListMoviesCommand implements Command {
    MovieRepository movieRepository;

    public ListMoviesCommand(MovieRepository movieRepository) {
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
