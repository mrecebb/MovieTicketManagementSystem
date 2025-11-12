package checks;

import movie.Movie;

import java.util.List;

public class Check {
    public static boolean checkRating(Double rating) {
        return rating <= 5 && rating >= 1;
    }

    public static boolean movieName(List<Movie> movies, Movie movie) {
        for (Movie m : movies) {
            if (m.getTitle().equalsIgnoreCase(movie.getTitle())) {
                return false;
            }
        }
        return true;
    }

}
