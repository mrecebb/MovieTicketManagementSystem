import com.fasterxml.jackson.databind.ObjectMapper;
import service.CustomerInputService;
import repository.JsonCustomerRepository;
import enums.Genre;
import enums.NotificationChannel;
import ui.commands.Command;
import repository.JsonMovieRepository;
import service.MovieInputService;
import service.notifications.SendNotification;
import repository.JsonTicketRepository;
import service.TicketInputService;
import ui.ConsoleUserInterface;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static config.Constants.*;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Command> commands = new ArrayList<>(); // istifadecinin ede bileceyi emeliyyatlari saxlayacaq
        List<Genre> genres = new ArrayList<>(); // film janrlarini saxlayan list
        List<NotificationChannel> notificationChannels = new ArrayList<>(); // notificationlar

        File fileMovies = new File(FILE_MOVIE); // movies.json faylinin saxlanilacagi yer
        File fileTickets = new File(FILE_TICKET); // tickets.json faylinin saxlanilacagi yer
        File fileCustomer = new File(FILE_CUSTOMER); // customers.json faylinin saxlanilacagi yer

        ObjectMapper objectMapper = new ObjectMapper(); // object mapper

        Scanner scanner = new Scanner(System.in); // scanner

        JsonMovieRepository jsonMovieRepository = new JsonMovieRepository(fileMovies, objectMapper); // json faylina yazib oxumaq ucun
        JsonTicketRepository jsonTicketRepository = new JsonTicketRepository(fileTickets, objectMapper);
        JsonCustomerRepository jsonCustomerRepository = new JsonCustomerRepository(fileCustomer, objectMapper);

        MovieInputService movieInputService = new MovieInputService(scanner, genres); // add movie ucun giris
        TicketInputService ticketInputService = new TicketInputService(jsonMovieRepository, jsonCustomerRepository, scanner); // purchase ticket ucun giris
        CustomerInputService customerInputService = new CustomerInputService(jsonCustomerRepository, notificationChannels, scanner);

        SendNotification sendNotification = new SendNotification();

        ConsoleUserInterface ui = new ConsoleUserInterface(
                commands,
                movieInputService,
                ticketInputService,
                customerInputService,
                jsonMovieRepository,
                jsonTicketRepository,
                jsonCustomerRepository,
                scanner,
                sendNotification
        );
        ui.start();
    }
}
