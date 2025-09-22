public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("1984", "George Orwell", "1234567890", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", "1234567890123", 1960);
        Book book3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "0987654321", 1925);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayAllBooks();

        System.out.println("Borrowing 1984: " + (library.borrowBook("1234567890") ? "Success" : "Failed"));

        System.out.println("Borrowing 1984 again: " + (library.borrowBook("1234567890") ? "Success" : "Failed"));

        System.out.println("Returning 1984: " + (library.returnBook("1234567890") ? "Success" : "Failed"));

        library.displayAvailableBooks();

        try {
            Book invalidBook = new Book("", "", "123", 1400);
        } catch (IllegalArgumentException e) {
            System.out.println("Validation test: " + e.getMessage());
        }
    }
}
