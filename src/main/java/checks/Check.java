package checks;

import customers.Customer;
import movie.Movie;

import java.util.List;

public class Check {
    public static boolean checkRating(Double rating) {
        return rating <= 5 && rating >= 1;
    }

    public static boolean movieNameDefined(List<Movie> movies, Movie movie) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(movie.getTitle())) {
                return false;
            }
        }
        return true;
    }

    public static boolean MovieExistsById(List<Movie> movies, long movieId) {
        for (Movie m : movies) {
            if (m.getId() == movieId) {
                return true;
            }
        }
        return false;
    }

    public static boolean CustomerExistsWithId(List<Customer> customers, long customerId) {
        for (Customer c : customers) {
            if (c.getId() == customerId) {
                return false;
            }
        }
        return true;
    }

    public static boolean seatAvailable(List<Movie> movies, long movieId, int seat) {
        for (Movie m : movies) {
            if (m.getId() == movieId) {
                if (seat < 1 || seat > m.getAvailableSeats()) {
                    return false;
                }
            }
        }
        return true;
    }
}
