/*Patrons are notified when a reserved book becomes available.*/
package notifications;

import patrons.Patron;

public class NotificationService {
    public void notifyPatron(Patron patron, String message) {
        System.out.println("Notification sent to " + patron.getName() + ": " + message);
    }
}
