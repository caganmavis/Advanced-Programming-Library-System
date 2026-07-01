// LibraryManager.java
import java.util.ArrayList;
import java.util.List;

public class LibraryManager {
    private List<Book> books;

    public LibraryManager() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("System: '" + book.getTitle() + "' successfully added.");
    }

    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("System: No books found in the library.");
            return;
        }
        System.out.println("\n--- Library Catalog ---");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void borrowBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (!book.isBorrowed()) {
                    book.setBorrowed(true);
                    System.out.println("System: You have borrowed '" + book.getTitle() + "'.");
                } else {
                    System.out.println("Error: This book is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found.");
    }

    public void returnBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                if (book.isBorrowed()) {
                    book.setBorrowed(false);
                    System.out.println("System: '" + book.getTitle() + "' successfully returned.");
                } else {
                    System.out.println("System: This book is already in the library.");
                }
                return;
            }
        }
        System.out.println("Error: Book with ISBN " + isbn + " not found.");
    }
}