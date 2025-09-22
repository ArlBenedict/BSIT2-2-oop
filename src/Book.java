// Book.java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private boolean isAvailable;
    private int yearPublished;

    public Book(String title, String author, String isbn, int yearPublished) {
        setTitle(title);
        setAuthor(author);
        setIsbn(isbn);
        setYearPublished(yearPublished);
        setAvailable(true);
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public int getYearPublished() { return yearPublished; }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be null or empty.");
        }
        this.author = author;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || !(isbn.length() == 10 || isbn.length() == 13)) {
            throw new IllegalArgumentException("ISBN must be exactly 10 or 13 characters.");
        }
        this.isbn = isbn;
    }

    public void setYearPublished(int yearPublished) {
        if (yearPublished < 1450 || yearPublished > 2025) {
            throw new IllegalArgumentException("Year must be between 1450 and 2025.");
        }
        this.yearPublished = yearPublished;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public boolean borrowBook() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (!isAvailable) {
            isAvailable = true;
            return true;
        }
        return false;
    }

    public void displayBookInfo() {
        System.out.printf("Title: %s\nAuthor: %s\nISBN: %s\nYear: %d\nAvailable: %s\n",
                title, author, isbn, yearPublished, isAvailable ? "Yes" : "No");
    }
}
