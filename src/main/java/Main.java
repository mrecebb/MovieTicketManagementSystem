import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Genre;
import interfaces.Command;
import movie.JsonMovieRepository;
import movie.MovieInputService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enums.Constant.FILE_MOVIE;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Command> commands = new ArrayList<>(); // istifadecinin ede bileceyi emeliyyatlari saxlayacaq
        List<Genre> genres = new ArrayList<>(); // film janrlarini saxlayan list
        Scanner scanner = new Scanner(System.in); // scanner
        MovieInputService movieInputService = new MovieInputService(scanner, genres); // add movie ucun giris
        File file = new File(FILE_MOVIE); // movies.json faylinin saxlanilacagi yer
        ObjectMapper objectMapper = new ObjectMapper(); // object mapper
        JsonMovieRepository jsonRepositoryMovie = new JsonMovieRepository(file, objectMapper); // json faylina yazib oxumaq ucun


        UserInterface ui = new UserInterface(commands, movieInputService, jsonRepositoryMovie, scanner);
        ui.start();
    }


    //! Bilet al sistemi elave edecem
}
