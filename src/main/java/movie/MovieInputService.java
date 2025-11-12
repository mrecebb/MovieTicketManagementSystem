package movie;

import checks.Check;
import enums.Genre;
import exceptions.InvalidChoice;
import interfaces.InputService;

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

        for (int i = 0; i < genres.size(); i++) {
            System.out.println((i + 1) + ". " + genres.get(i));
        }
        System.out.print("Enter Genre (1-" + genres.size() + "): ");
        int choice = Integer.parseInt(in.nextLine());
        if (choice < 1 || choice > genres.size()) {
            throw new InvalidChoice("Invalid choice");
        }
        Genre genre = genres.get(choice - 1);

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
        int seats = Integer.parseInt(in.nextLine());

        System.out.print("Price: ");
        double price = Double.parseDouble(in.nextLine());

        return new Movie(title, genre, duration, rating, seats, price);
    }
}
