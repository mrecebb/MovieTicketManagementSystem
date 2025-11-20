package ui.commands;

import util.Check;
import exceptions.DuplicateMovieException;
import repository.MovieRepository;
import domain.Movie;
import service.MovieInputService;

import java.io.IOException;
import java.util.List;

public class AddMovieCommand implements Command {
    MovieInputService inputService;
    MovieRepository movieRepository;

    public AddMovieCommand(MovieInputService inputService, MovieRepository movieRepository) {
        this.inputService = inputService;
        this.movieRepository = movieRepository;
    }

    @Override
    public String commandName() {
        return "Add Movie";
    }

    @Override
    public void process() throws IOException {
        List<Movie> movies = movieRepository.findAll();
        Movie.idCounter = movies.size();

        Movie movie = inputService.getInformation();

        if(Check.movieNameDefined(movies, movie)) {
            movies.add(movie);
            movieRepository.saveAll(movies);
        } else {
            throw new DuplicateMovieException("Movie already exists");
        }
    }
}
