package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<Integer, Book> books = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private List<Book> checkedOutBooks = new ArrayList<>();
// add book
    public void addBook(int bookId, String title) {
        Book book = new Book(bookId, title);
        books.put(bookId, book);

    }

// add user
    public void addUser(int userId,String name){
        User user=new User(userId,name);
        users.put(userId,user);

    }

    // borrow book
    public void borrowBook(int userId,int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);
        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }
        if (!book.isAvailable()) {
            System.out.println("The book is already checked out.");
            return;
        }
        book.setAvailable(false);
        checkedOutBooks.add(book);
        System.out.println(user.getName() + " has borrowed '" + book.getTitle() + "'.");
    }
    public void returnBook(int userId, int bookId) {
        User user = users.get(userId);
        Book book = books.get(bookId);

        if (user == null || book == null) {
            System.out.println("Invalid user or book ID.");
            return;
        }

        if (!checkedOutBooks.contains(book)) {
            System.out.println("This book was not borrowed by " + user.getName() + ".");
            return;
        }

        book.setAvailable(true);
        checkedOutBooks.remove(book);
        System.out.println(user.getName() + " has returned '" + book.getTitle() + "'.");
    }




}
