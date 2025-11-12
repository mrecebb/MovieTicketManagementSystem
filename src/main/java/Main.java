import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Genre;
import interfaces.Command;
import movie.JsonMovieRepository;
import movie.MovieInputService;
import tickets.JsonTicketRepository;
import tickets.TicketInputService;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static enums.Constant.FILE_MOVIE;
import static enums.Constant.FILE_TICKET;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Command> commands = new ArrayList<>(); // istifadecinin ede bileceyi emeliyyatlari saxlayacaq
        List<Genre> genres = new ArrayList<>(); // film janrlarini saxlayan list
        File fileMovies = new File(FILE_MOVIE); // movies.json faylinin saxlanilacagi yer
        File fileTickets = new File(FILE_TICKET); // tickets.json faylinin saxlanilacagi yer
        ObjectMapper objectMapper = new ObjectMapper(); // object mapper
        Scanner scanner = new Scanner(System.in); // scanner
        JsonMovieRepository jsonMovieRepository = new JsonMovieRepository(fileMovies, objectMapper); // json faylina yazib oxumaq ucun
        JsonTicketRepository jsonTicketRepository = new JsonTicketRepository(fileTickets, objectMapper);
        MovieInputService movieInputService = new MovieInputService(scanner, genres); // add movie ucun giris
        TicketInputService ticketInputService = new TicketInputService(jsonMovieRepository,scanner); // purchase ticket ucun giris

        UserInterface ui = new UserInterface(commands, movieInputService,ticketInputService, jsonMovieRepository, jsonTicketRepository, scanner);
        ui.start();
    }
}
