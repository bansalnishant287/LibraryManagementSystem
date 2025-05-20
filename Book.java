package books;

public class Book {
    private String title;
    private String ISBN;
    private int publicationYear;
    private boolean isAvailable;
    private Author author;

    public Book(String title, String ISBN, int publicationYear, Author author) {
        this.title = title;
        this.ISBN = ISBN;
        this.publicationYear = publicationYear;
        this.author = author;
        this.isAvailable = true; // default
    }

    // Getters and Setters
    public String getTitle() { return title; }
    public String getISBN() { return ISBN; }
    public int getPublicationYear() { return publicationYear; }
    public boolean isAvailable() { return isAvailable; }
    public Author getAuthor() { return author; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return title + " by " + author.getName() + " (ISBN: " + ISBN + ")";
    }
}
