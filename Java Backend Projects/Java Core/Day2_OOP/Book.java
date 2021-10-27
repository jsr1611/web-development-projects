/*
Author: Jumanazar Saidov
Date: 2021-10-27

 */

package variables.Day2_OOP;

import java.util.Arrays;

public class Book {
    private String title;
    private String[] authors;
    private long ISBN;

    public Book(String title, String[] authors, long ISBN) {
        this.title = title;
        this.authors = authors;
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String[] getAuthors() {
        return authors;
    }

    public long getISBN() {
        return ISBN;
    }
    public void printBookDetails(){
        System.out.println("Book title: " + title);
        System.out.println("Book author(s): " + String.join(", ", authors));

    }

    public static void main(String[] args) {
        Book book1 = new Book("The Adventures of Sherlock Holmes",
                new String[]{"Arthur Conan Doyle"},
                9781435162051L);
        book1.printBookDetails();

        Book book2 = new Book("Introduction to Algorithms",
                new String[]{"Thomas H. Cormen", "Charles E. Leiserson", "Ronald L. Rivest", "Clifford Stein"},
                9780262033848L);
        book2.printBookDetails();
    }

}
