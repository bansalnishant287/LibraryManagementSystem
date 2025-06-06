package inventory;

import books.Book;

import java.util.HashMap;
import java.util.Map;

public class LibraryInventory {
    private Map<String, Book> books; 

    public LibraryInventory() {
        books = new HashMap<>();
    }

    public void addBook(Book book) {
        books.put(book.getISBN(), book);
    }

    public void removeBook(String ISBN) {
        books.remove(ISBN);
    }

    public Book searchByISBN(String ISBN) {
        return books.get(ISBN);
    }

    public Book searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElse(null);
    }

    public Book searchByAuthor(String authorName) {
        return books.values().stream()
                .filter(book -> book.getAuthor().getName().equalsIgnoreCase(authorName))
                .findFirst()
                .orElse(null);
    }

    public boolean isAvailable(String ISBN) {
        Book book = books.get(ISBN);
        return book != null && book.isAvailable();
    }

    public void updateBook(Book book) {
        books.put(book.getISBN(), book); // Overwrites if exists
    }
}
