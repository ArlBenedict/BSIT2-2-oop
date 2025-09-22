// Library.java
public class Library {
    private Book[] books;
    private int bookCount;

    public Library() {
        books = new Book[10];
        bookCount = 0;
    }

    public boolean addBook(Book book) {
        if (bookCount >= books.length) return false;
        books[bookCount++] = book;
        return true;
    }

    public boolean removeBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[bookCount - 1];
                books[bookCount - 1] = null;
                bookCount--;
                return true;
            }
        }
        return false;
    }

    public Book findBook(String isbn) {
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    public boolean borrowBook(String isbn) {
        Book book = findBook(isbn);
        return book != null && book.borrowBook();
    }

    public boolean returnBook(String isbn) {
        Book book = findBook(isbn);
        return book != null && book.returnBook();
    }

    public void displayAvailableBooks() {
        System.out.println("Available Books:");
        for (int i = 0; i < bookCount; i++) {
            if (books[i].isAvailable()) {
                books[i].displayBookInfo();
                System.out.println();
            }
        }
    }

    public void displayAllBooks() {
        System.out.println("All Books:");
        for (int i = 0; i < bookCount; i++) {
            books[i].displayBookInfo();
            System.out.println();
        }
    }

    public int getBookCount() {
        return bookCount;
    }
}
