package Cinema;

public class Movie {

    String title;
    double price;
    int duration;

    public Movie(String title, double price, int duration) {
        this.title = title;
        this.price = price;
        this.duration = duration;
    }

    public Movie(String title, double price) {
        this.title = title;
        this.price = price;
        this.duration = 120;
    }

    public String getTitle() {
        return title;
    }

    public void printInfo() {
        System.out.printf("%s | Thời lượng %d phút | Giá vé: %,.0f VNĐ \n", title, duration, price);
    }
}
