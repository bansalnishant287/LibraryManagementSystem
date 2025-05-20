package patrons;

import books.Book;

import java.util.List;

public class PatronHistoryService {
    public List<Book> getHistory(Patron patron) {
        return patron.getBorrowHistory();
    }
}
