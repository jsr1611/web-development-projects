package variables.Day3_OOP.Books;

public class Book {
    protected String author;
    protected double price;
    protected double discount;
    protected String title;
    protected int numPages;
    Book(String author, double price, double discount, String title, int numPages){
        this.author = author;
        this.price = price;
        this.discount = discount;
        this.title = title;
        this.numPages = numPages;
    }

    public double getPrice(){
        return price;
    }

    public double getTaxFee(){
        return getPrice() * .3;
    }

}
