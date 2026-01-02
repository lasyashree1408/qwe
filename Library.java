import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    // ---------- USER ----------
    public void addUser(User user) {
        users.add(user);
    }

    public User findUser(int userId) {
        for (User u : users) {
            if (u.getUserId() == userId) {
                return u;
            }
        }
        return null;
    }

    // ---------- BOOK ----------
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    public void removeBook(int bookId) {
        books.removeIf(b -> b.getBookId() == bookId);
        System.out.println("Book removed successfully.");
    }

    // ADMIN VIEW → shows all books
    public void showAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        for (Book b : books) {
            System.out.println(b);
        }
    }

    // USER VIEW → shows only available books
    public void showAvailableBooks() {
        boolean found = false;
        for (Book b : books) {
            if (!b.isIssued()) {
                System.out.println(b);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available books at the moment.");
        }
    }

    public Book findBook(int bookId) {
        for (Book b : books) {
            if (b.getBookId() == bookId) {
                return b;
            }
        }
        return null;
    }

    public void issueBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && !book.isIssued()) {
            book.issue();
            System.out.println("Book issued successfully.");
        } else {
            System.out.println("Book not available.");
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);
        if (book != null && book.isIssued()) {
            book.returned();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Invalid return.");
        }
    }
}
