package patrons;

import books.Book;
import java.util.ArrayList;
import java.util.List;

public class Patron {
    private String id;
    private String name;
    private String contactInfo;
    private List<Book> borrowHistory;

    public Patron(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.borrowHistory = new ArrayList<>();
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getContactInfo() { return contactInfo; }
    public List<Book> getBorrowHistory() { return borrowHistory; }

    public void addToHistory(Book book) {
        borrowHistory.add(book);
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}
