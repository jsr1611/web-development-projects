package variables.Day3_OOP.Books;

public class PaperBook extends Book{
    private int weight;
    private int deliveryTime; // in days

    PaperBook(String author, double price, double discount, String title, int numPages, int weight, int deliveryTime) {
        super(author, price, discount, title, numPages);
        this.weight = weight;
        this.deliveryTime = deliveryTime;
    }

}
