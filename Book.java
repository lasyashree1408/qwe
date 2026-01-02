public class Book {
    private int bookId;
    private String title;
    private String author;
    private boolean issued;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public boolean isIssued() {
        return issued;
    }

    public void issue() {
        issued = true;
    }

    public void returned() {
        issued = false;
    }

    @Override
    public String toString() {
        return "Book ID: " + bookId +
               ", Title: " + title +
               ", Author: " + author +
               ", Status: " + (issued ? "Issued" : "Available");
    }
}