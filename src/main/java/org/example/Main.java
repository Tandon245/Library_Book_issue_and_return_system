package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Library library = new Library();

        Scanner scanner = new Scanner(System.in);


        while (true) {
            System.out.println("Library System Menu:");
            System.out.println("1. Add a Book");
            System.out.println("2. Add a User");
            System.out.println("3. Borrow a Book");
            System.out.println("4. Return a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter book ID: ");
                    int bookId = scanner.nextInt();
                    System.out.print("Enter book title: ");
                    scanner.nextLine(); // Consume newline
                    String bookTitle = scanner.nextLine();
                    library.addBook(bookId, bookTitle);
                    System.out.println("Book added.");
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter user name: ");
                    scanner.nextLine(); // Consume newline
                    String userName = scanner.nextLine();
                    library.addUser(userId, userName);
                    System.out.println("User added.");
                    break;
                case 3:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    library.borrowBook(userId, bookId);
                    break;
                case 4:
                    System.out.print("Enter user ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Enter book ID: ");
                    bookId = scanner.nextInt();
                    library.returnBook(userId, bookId);
                    break;
                case 5:
                    System.out.println("Exiting the Library System.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}