# 📚 Library Management System (Java)
https://github.com/bansalnishant287/LibraryManagementSystem
A console-based Library Management System written in Java to demonstrate key Object-Oriented Programming (OOP) concepts, SOLID principles, and the use of common design patterns like Factory and Observer.

## 🚀 Features

### ✅ Core Functionalities
- **Book Management:** Add, remove, update, and search books.
- **Patron Management:** Register patrons and manage borrowing history.
- **Lending Process:** Book checkout and return system.
- **Inventory Management:** Tracks available and borrowed books.

### 🔧 Optional Extensions
- **Multi-branch Support:** Manage multiple library branches.
- **Reservation System:** Reserve and notify patrons for checked-out books.
- **Recommendation System:** Suggest books based on borrowing history using Strategy Pattern.

---

## 🛠️ Technologies Used

- **Java 17+**
- **Java Collections API**
- **SLF4J Logging (via LoggerUtil)**

---

## 🧩 Design Patterns Used

| Pattern    | Purpose                                                                 |
|------------|-------------------------------------------------------------------------|
| **Factory**    | To encapsulate object creation of various services or entities.         |
| **Observer**   | For the reservation notification system.                              |
| **Strategy**   | (Optional) To switch between different recommendation strategies.     |

---

## 📐 Class Diagram

> _**![Class Diagram](images/lms_class_diagram.png)**

---

## 📁 Project Structure

src/
├── books/ # Book class and related logic
├── patrons/ # Patron class and details
├── inventory/ # Manages inventory of books
├── services/ # Core services (lending, system manager, etc.)
├── reservations/ # Reservation and waitlist features
├── notifications/ # Observer pattern: Notify when reserved books return
├── recommendations/ # Recommendation engine using strategies
├── utils/ # Logger utility and helpers
└── Main.java # Demo runner

---

## 📌 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/bansalnishant287/LibraryManagementSystem.git
   cd LibraryManagementSystem
