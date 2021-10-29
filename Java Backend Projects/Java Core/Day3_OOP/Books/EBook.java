package variables.Day3_OOP.Books;

public class EBook extends Book{
    private String downloadPage;
    private int fileSize;
    EBook(String author, double price, double discount, String title, int numPages, String downloadPage, int fileSize) {
        super(author, price, discount, title, numPages);
        this.downloadPage = downloadPage;
        this.fileSize = fileSize;
    }


    public void printTitle(){
        System.out.println(this.title);
    }
}
