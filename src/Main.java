public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("OOP", "Razo", 100);
        Book book2 = new Book("Clean Code", "Robert C. Martin", 464);
        Book book3 = new Book("The Pragmatic Programmer", "Andrew Hunt & David Thomas", 352);

        book1.displayInfo();
        book2.displayInfo();
        book3.displayInfo();

        book1.borrowBook();
        book2.borrowBook();

        book1.displayInfo();
        book2.displayInfo();

        book1.returnBook();
        book1.displayInfo();
    }
}
