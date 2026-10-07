package Cinema;

public class Cinema {

    public String nameCinema;
    Movie[] movies;

    public Cinema(String nameCinema, Movie[] movies) {
        this.nameCinema = nameCinema;
        this.movies = movies;
    }

    public void displayInfo() {
        for (Movie movie : movies) {
            movie.printInfo();
        }
    }
}
