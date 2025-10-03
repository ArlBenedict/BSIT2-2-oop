public class Main {
    public static void main(String[] args) {
        // Create manager
        LibraryManager manager = new LibraryManager();
        // Create Books (2)
        Book book1 = new Book("B001", "The Wuxia Way", "L. Author", "ISBN-001", 320, "Fantasy");
        Book book2 = new Book("B002", "Data Structures", "A. Coder", "ISBN-002", 450, "Education");
        // Create Magazines (2)
        Magazine mag1 = new Magazine("M001", "Science Monthly", "Various", 12, "December", true);
        Magazine mag2 = new Magazine("M002", "Fashion Weekly", "Various", 45, "June", false);
        // Create DVDs (2)
        DVD dvd1 = new DVD("D001", "Adventure Movie", "Dir. A", 120, "PG-13", "Adventure");
        DVD dvd2 = new DVD("D002", "Kids Show", "Dir. B", 80, "G", "Kids");
        // Add items to manager (polymorphism: stored as Borrowable)
        manager.addItem(book1);
        manager.addItem(book2);
        manager.addItem(mag1);
        manager.addItem(mag2);
        manager.addItem(dvd1);
        manager.addItem(dvd2);
        // Create users
        Student student = new Student("U001", "Alice", "alice@example.com", "S1001", "Computer Science");
        Faculty faculty = new Faculty("U002", "Dr. Bob", "bob@example.edu", "Math", "Professor");
        // Display all items
        manager.displayAllItems();
        System.out.println();
        // Borrow some items (demonstrate borrowable and user limits)
        // Student borrows a book and a DVD
        if (student.getBorrowedItemsCount() < student.getMaxBorrowLimit() && manager.borrowItem("B001", student.getName())) {
            student.addBorrowedItem(book1);
        }
        if (student.getBorrowedItemsCount() < student.getMaxBorrowLimit() && manager.borrowItem("D002", student.getName())) {
            student.addBorrowedItem(dvd2);
        }
        // Faculty borrows a magazine and a book
        if (faculty.getBorrowedItemsCount() < faculty.getMaxBorrowLimit() && manager.borrowItem("M001", faculty.getName())) {
            faculty.addBorrowedItem(mag1);
        }
        if (faculty.getBorrowedItemsCount() < faculty.getMaxBorrowLimit() && manager.borrowItem("B002", faculty.getName())) {
            faculty.addBorrowedItem(book2);
        }
        System.out.println();
        // Show available items after borrowing
        manager.displayAvailableItems();
        System.out.println();
        // Display user's borrowed items
        student.displayBorrowedItems();
        faculty.displayBorrowedItems();
        System.out.println();
        // Test return
        manager.returnItem("B001"); // student returns book1
        student.removeBorrowedItem(book1);
        System.out.println();
        manager.displayAllItems();
        System.out.println();
        // Test calculate late fees (polymorphism: different implementations used)
        int daysLate = 3;
        double totalFees = manager.calculateTotalLateFees(daysLate);
        System.out.printf("Total late fees for %d days late (all items): %.2f\n", daysLate, totalFees);
        System.out.println();
        // Show DVD override of default borrowing status
        System.out.println(dvd1.getBorrowingStatus()); // uses DVD's override
        System.out.println();
        // Test setter validation examples (encapsulation)
        try {
            book1.setGenre(""); // should throw
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught validation error when setting genre: " + ex.getMessage());
        }
        try {
            dvd1.setRating("X"); // invalid rating
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught validation error when setting rating: " + ex.getMessage());
        }
        try {
            mag2.setIssueNumber(-5);
        } catch (IllegalArgumentException ex) {
            System.out.println("Caught validation error when setting issue number: " + ex.getMessage());
        }
    }
}

