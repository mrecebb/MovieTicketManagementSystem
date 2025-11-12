package movie;

import com.fasterxml.jackson.annotation.JsonCreator;
import enums.Genre;

public class Movie {
    private long id;
    public static long idCounter = 0;
    private String title;
    private Genre genre;
    private int durationMinutes;
    private Double rating;
    private int availableSeats;
    private Double price;

    @JsonCreator
    public Movie() {}

    public Movie(String title, Genre genre, int durationMinutes, Double rating, Integer availableSeats, Double price) {
        this.id = nextId();
        this.title = title;
        this.genre = genre;
        this.durationMinutes = durationMinutes;
        this.rating = rating;
        this.availableSeats = availableSeats;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", durationMinutes=" + durationMinutes +
                ", rating=" + rating +
                ", availableSeats=" + availableSeats +
                ", price=" + price +
                '}';
    }

    @SuppressWarnings("unused")
    private static long nextId() {
        return ++idCounter;
    }

    @SuppressWarnings("unused")
    public long getId() {
        return id;
    }

    @SuppressWarnings("unused")
    public void setId(long id) {
        this.id = id;
    }

    @SuppressWarnings("unused")
    public String getTitle() {
        return title;
    }

    @SuppressWarnings("unused")
    public void setTitle(String title) {
        this.title = title;
    }

    @SuppressWarnings("unused")
    public Genre getGenre() {
        return genre;
    }

    @SuppressWarnings("unused")
    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @SuppressWarnings("unused")
    public int getDurationMinutes() {
        return durationMinutes;
    }

    @SuppressWarnings("unused")
    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    @SuppressWarnings("unused")
    public Double getRating() {
        return rating;
    }

    @SuppressWarnings("unused")
    public void setRating(Double rating) {
        this.rating = rating;
    }

    @SuppressWarnings("unused")
    public int getAvailableSeats() {
        return availableSeats;
    }

    @SuppressWarnings("unused")
    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    @SuppressWarnings("unused")
    public double getPrice() {
        return price;
    }

    @SuppressWarnings("unused")
    public void setPrice(Double price) {
        this.price = price;
    }
}
