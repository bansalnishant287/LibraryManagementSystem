package system;

import books.Book;
import books.Author;
import inventory.LibraryInventory;
import lending.LendingService;
import patrons.Patron;
import patrons.PatronHistoryService;

import java.util.HashMap;
import java.util.Map;

public class LibrarySystem {
    private LibraryInventory inventory;
    private LendingService lendingService;
    private PatronHistoryService historyService;
    private Map<String, Patron> patrons;

    public LibrarySystem() {
        this.inventory = new LibraryInventory();
        this.lendingService = new LendingService(inventory);
        this.historyService = new PatronHistoryService();
        this.patrons = new HashMap<>();
    }

    // -------------------------
    // Patron Management
    // -------------------------
    public void registerPatron(String id, String name, String contact) {
        Patron patron = new Patron(id, name, contact);
        patrons.put(id, patron);
        System.out.println("Patron registered: " + patron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    // -------------------------
    // Book Management
    // -------------------------
    public void addBook(String title, String ISBN, int year, String authorName) {
        Author author = new Author(authorName);
        Book book = new Book(title, ISBN, year, author);
        inventory.addBook(book);
        System.out.println("Book added: " + book);
    }

    public void removeBook(String ISBN) {
        inventory.removeBook(ISBN);
        System.out.println("Book removed: " + ISBN);
    }

    public Book searchBookByTitle(String title) {
        return inventory.searchByTitle(title);
    }

    public Book searchBookByISBN(String ISBN) {
        return inventory.searchByISBN(ISBN);
    }

    public Book searchBookByAuthor(String author) {
        return inventory.searchByAuthor(author);
    }

    // -------------------------
    // Lending
    // -------------------------
    public boolean checkoutBook(String ISBN, String patronId) {
        Patron patron = getPatron(patronId);
        if (patron == null) {
            System.out.println("Invalid patron ID");
            return false;
        }

        boolean success = lendingService.checkoutBook(ISBN, patron);
        System.out.println(success ? "Book checked out." : "Checkout failed.");
        return success;
    }

    public boolean returnBook(String ISBN, String patronId) {
        Patron patron = getPatron(patronId);
        if (patron == null) {
            System.out.println("Invalid patron ID");
            return false;
        }

        boolean success = lendingService.returnBook(ISBN, patron);

        if (success) {
            System.out.println("Book returned.");

            if (reservationService.hasReservations(ISBN)) {
                Patron nextInLine = reservationService.getNextReservation(ISBN);
                if (nextInLine != null) {
                    notificationService.notifyPatron(nextInLine, "Book with ISBN " + ISBN + " is now available for you.");
                }
            }

            return true;
        }

        System.out.println("Return failed.");
        return false;
    }


    // -------------------------
    // History
    // -------------------------
    public void showBorrowHistory(String patronId) {
        Patron patron = getPatron(patronId);
        if (patron == null) {
            System.out.println("Invalid patron ID");
            return;
        }

        System.out.println("Borrow history for " + patron.getName() + ":");
        historyService.getHistory(patron).forEach(book ->
                System.out.println("- " + book.getTitle() + " by " + book.getAuthor().getName())
        );
    }
}
