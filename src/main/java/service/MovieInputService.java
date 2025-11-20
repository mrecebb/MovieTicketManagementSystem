package service;

import util.Check;
import domain.Movie;
import enums.Genre;
import exceptions.InvalidGenreException;

import java.util.List;
import java.util.Scanner;

public class MovieInputService implements InputService {
    private final Scanner in;
    List<Genre> genres;

    // constructor injection + janrlari al
    public MovieInputService(Scanner in, List<Genre> genres) {
        this.in = in;
        this.genres = genres;

        genres.add(Genre.ACTION);
        genres.add(Genre.COMEDY);
        genres.add(Genre.DRAMA);
        genres.add(Genre.HORROR);
        genres.add(Genre.ANIMATION);
    }

    // istifadecinden movie al ve geri Movie qaytar
    @Override
    public Movie getInformation() {
        System.out.print("Movie title: ");
        String title = in.nextLine();

        System.out.println("Enter Genre");
        genres.forEach(genre -> {
            System.out.print(genre + ", ");
        });

        Genre genre = null;

        System.out.println("Select:");
        try {
            genre = Genre.valueOf(in.nextLine().toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new InvalidGenreException(e.getMessage());
        }

        System.out.print("Duration Minutes: ");
        int duration = Integer.parseInt(in.nextLine());

        System.out.print("Rating (empty = null): ");
        String r = in.nextLine().trim();
        Double rating;
        if (r.isEmpty()) {
            rating = null;
        }else {
            while (!Check.checkRating(Double.parseDouble(r))) {
                System.out.print("Invalid Rating: ");
                r = in.nextLine().trim();
            }
            rating = Double.parseDouble(r);
        }

        System.out.print("Available Seats: ");
        Integer seats = Integer.parseInt(in.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(in.nextLine());

        return new Movie(title, genre, duration, rating, seats, price);
    }
}
