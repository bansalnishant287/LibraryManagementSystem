/*
Patrons can reserve books that are currently unavailable.
When the book is returned, the first user in the waitlist gets a notification.
*/

package reservation;

import books.Book;
import patrons.Patron;

import java.util.*;

public class ReservationService {
    private Map<String, Queue<Patron>> reservationMap; // ISBN → Queue of Patrons

    public ReservationService() {
        this.reservationMap = new HashMap<>();
    }

    public void reserveBook(String ISBN, Patron patron) {
        reservationMap.putIfAbsent(ISBN, new LinkedList<>());
        Queue<Patron> queue = reservationMap.get(ISBN);

        if (!queue.contains(patron)) {
            queue.add(patron);
            System.out.println("Book reserved. Patron added to waitlist.");
        } else {
            System.out.println("Patron already in waitlist.");
        }
    }

    public Patron getNextReservation(String ISBN) {
        Queue<Patron> queue = reservationMap.get(ISBN);
        if (queue != null && !queue.isEmpty()) {
            return queue.poll(); // Remove and return first in line
        }
        return null;
    }

    public boolean hasReservations(String ISBN) {
        Queue<Patron> queue = reservationMap.get(ISBN);
        return queue != null && !queue.isEmpty();
    }
}
