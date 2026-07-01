// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();
        Scanner scanner = new Scanner(System.in);
        
        manager.addBook(new Book("111", "The Great Gatsby", "F. Scott Fitzgerald"));
        manager.addBook(new Book("222", "184", "George Orwell"));
        manager.addBook(new AcademicBook("333", "Introduction to Algorithms", "Thomas H. Cormen", "Computer Science"));

        boolean running = true;

        while (running) {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. List All Books");
            System.out.println("2. Add New Book");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.listBooks();
                    break;
                case "2":
                    System.out.print("Enter ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Author: ");
                    String author = scanner.nextLine();
                    
                    System.out.print("Is this an academic book? (Y/N): ");
                    String response = scanner.nextLine();
                    
                    if (response.equalsIgnoreCase("Y")) {
                        System.out.print("Enter Subject: ");
                        String subject = scanner.nextLine();
                        manager.addBook(new AcademicBook(isbn, title, author, subject));
                    } else {
                        manager.addBook(new Book(isbn, title, author));
                    }
                    break;
                case "3":
                    System.out.print("Enter ISBN to borrow: ");
                    String borrowIsbn = scanner.nextLine();
                    manager.borrowBook(borrowIsbn);
                    break;
                case "4":
                    System.out.print("Enter ISBN to return: ");
                    String returnIsbn = scanner.nextLine();
                    manager.returnBook(returnIsbn);
                    break;
                case "5":
                    System.out.println("System: Exiting application.");
                    running = false;
                    break;
                default:
                    System.out.println("Error: Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }
}
