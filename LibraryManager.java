import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    
    private ArrayList<String> books;
    private Scanner scanner;

    
    public LibraryManager() {
        books = new ArrayList<>();
        books.add("Java Programming");
        books.add("Web Development");
        books.add("Database Design");
        scanner = new Scanner(System.in);
    }

    
    public void showBooks() {
        try {
            if (books == null) {
                throw new IllegalStateException("Book list is not initialized.");
            }
            if (books.isEmpty()) {
                System.out.println("Library is empty. No books available.");
            } else {
                System.out.println("Books in the library:");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + ". " + books.get(i));
                }
            }
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("showBooks() operation completed.\n");
        }
    }

    
    public void addBook() {
        String title = null;
        try {
            System.out.print("Enter a book title to add: ");
            title = scanner.nextLine();

            if (title == null || title.trim().isEmpty()) {
                throw new IllegalArgumentException("Book title cannot be empty or null.");
            }
            if (title.trim().length() < 3) {
                throw new IllegalArgumentException("Book title must be at least 3 characters.");
            }
            books.add(title.trim());
            System.out.println("Book '" + title.trim() + "' added successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("addBook() operation completed.");
            showBooks();
        }
    }

    
    public void removeBook() {
        try {
            if (books.isEmpty()) {
                System.out.println("Library is empty. No books to remove.");
                return;
            }
            System.out.print("Enter the index of the book to remove (1 to " + books.size() + "): ");
            String input = scanner.nextLine();
            int index;
            try {
                index = Integer.parseInt(input) - 1;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid number format for index.");
            }
            if (index < 0) {
                throw new IllegalArgumentException("Index cannot be negative.");
            }
            if (index >= books.size()) {
                throw new ArrayIndexOutOfBoundsException("Index out of range.");
            }
            String removedBook = books.remove(index);
            System.out.println("Book '" + removedBook + "' removed successfully.");
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("removeBook() operation completed.");
            showBooks();
        }
    }

    public static void main(String[] args) {
        LibraryManager manager = new LibraryManager();

        manager.showBooks();

        manager.addBook();

        manager.removeBook();

        manager.scanner.close();
    }
}
