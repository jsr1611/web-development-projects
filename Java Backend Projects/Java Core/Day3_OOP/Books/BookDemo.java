package variables.Day3_OOP.Books;

public class BookDemo {
    public static void main(String[] args) {
        EBook eBook = new EBook("Abdulla Qodiriy", 250000.0d, 10000.0, "O'tgan kunlar", 508, "wwww.myBooks.com/qodiriy/1/download", 30);
        eBook.printTitle();

        PaperBook paperBook = new PaperBook("Abdulla Qodiriy", 250000.0d, 5000.0d, "Mehrobdan chayon", 500, 350, 5);
        System.out.println(paperBook.getPrice());
    }

}
