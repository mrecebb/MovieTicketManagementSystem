package tickets;

import checks.Check;
import customers.Customer;
import enums.TicketStatus;
import exceptions.NoSeatsAvailableException;
import exceptions.NotFoundException;
import interfaces.CustomerRepository;
import interfaces.InputService;
import interfaces.MovieRepository;
import movie.Movie;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TicketInputService implements InputService {
    private final MovieRepository movieRepository;
    private final CustomerRepository customerRepository;
    private final Scanner scanner;

    public TicketInputService(MovieRepository mr, CustomerRepository cr, Scanner sc) {
        this.movieRepository = mr;
        this.customerRepository = cr;
        this.scanner = sc;
    }

    @Override
    public Ticket getInformation() throws IOException {
        System.out.println("Avilable Movies:");
        List<Movie> movies = movieRepository.findAll();
        List<Customer> customers = customerRepository.findAll();
        for (Movie movie : movies) {
            System.out.println(movie);
        }

        System.out.print("Enter Customer ID: ");
        long customerId = Integer.parseInt(scanner.nextLine());
        if (Check.CustomerExistsWithId(customers, customerId)) {
            throw new NotFoundException("Customer with ID " + customerId + " not found");
        }


        System.out.print("Enter Movie ID: ");
        long movieId = Integer.parseInt(scanner.nextLine());
        if (!Check.MovieExistsById(movies, movieId)) {
            throw new NotFoundException("Movie with ID " + movieId + " not found");
        }

        System.out.print("Enter Seat Number: ");
        int seatNumber = Integer.parseInt(scanner.nextLine());
        for (Movie movie : movies) {
            if (movie.getId() == movieId && movie.getAvailableSeats() == 0) {
                throw new NoSeatsAvailableException("No seats available");
            }
        }
        if (!Check.seatAvailable(movies, movieId, seatNumber))
            throw new NoSeatsAvailableException("Seat number " + seatNumber + " not available");

        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                movie.setAvailableSeats(movie.getAvailableSeats() - 1);
            }
        }

        double price = 0;
        for (Movie movie : movies) {
            if (movie.getId() == movieId) {
                price = movie.getPrice();
            }
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        String date = now.format(dtf);

        TicketStatus status = TicketStatus.PURCHASED;

        movieRepository.saveAll(movies);

        return new Ticket(customerId, movieId, seatNumber, price, date, status);
    }
}
