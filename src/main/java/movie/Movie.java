package movie;

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

    private static long nextId() {
        return ++idCounter;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
