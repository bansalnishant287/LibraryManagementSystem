package lending;

import books.Book;
import inventory.LibraryInventory;
import patrons.Patron;

public class LendingService {
    private LibraryInventory inventory;

    public LendingService(LibraryInventory inventory) {
        this.inventory = inventory;
    }

    public boolean checkoutBook(String ISBN, Patron patron) {
        Book book = inventory.searchByISBN(ISBN);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            patron.addToHistory(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(String ISBN, Patron patron) {
        Book book = inventory.searchByISBN(ISBN);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }
}
