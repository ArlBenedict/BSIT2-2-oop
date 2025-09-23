public class Librarian implements LibraryUser {
    private String name;
    private String employeeId;

    public Librarian(String name, String employeeId) {
        this.name = name;
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    @Override
    public String getUserType() {
        return "Librarian";
    }

    @Override
    public int getMaxBorrowLimit() {
        return 10;
    }

    @Override
    public void borrowMedia(Media media) {
        if (media.isAvailable()) {
            media.borrowItem();
            System.out.println(name + " (" + getUserType() + ") borrowed: " + media.getTitle());
        } else {
            System.out.println("Sorry, " + media.getTitle() + " is not available");
        }
    }

    @Override
    public void returnMedia(Media media) {
        media.returnItem();
    }
}
