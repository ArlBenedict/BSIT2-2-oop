public class Book extends Media {
    private String author;

    public Book(String title, String itemId, String author) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getMediaType() {
        return "Book";
    }

    @Override
    public void displayInfo() {
        System.out.println("Book: \"" + title + "\" by " + author + " (ID: " + itemId + ")");
    }
}
