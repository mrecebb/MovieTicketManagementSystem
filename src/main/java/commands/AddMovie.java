package commands;

import checks.Check;
import exceptions.DuplicateMovieException;
import interfaces.Command;
import interfaces.MovieRepository;
import movie.Movie;
import movie.MovieInputService;

import java.io.IOException;
import java.util.List;

public class AddMovie implements Command {
    MovieInputService inputService;
    MovieRepository movieRepository;

    public AddMovie(MovieInputService inputService, MovieRepository movieRepository) {
        this.inputService = inputService;
        this.movieRepository = movieRepository;
    }

    @Override
    public String commandName() {
        return "Add Movie";
    }

    @Override
    public void process() throws IOException {
        Movie movie = inputService.getInformation();

        List<Movie> movies = movieRepository.findAll();
        Movie.idCounter = movies.size();

        if(Check.movieName(movies, movie)) {
            movies.add(movie);
            movieRepository.saveAll(movies);
        } else {
            throw new DuplicateMovieException("Movie already exists");
        }
    }
}
