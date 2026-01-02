import java.io.Console;
import java.util.Scanner;

public class LibraryApplication {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Console console = System.console();

        Library library = new Library();
        Admin admin = new Admin("admin", 1234);

        // ---------- PRELOADED BOOKS ----------
        library.addBook(new Book(101, "Java Programming", "Herbert Schildt"));
        library.addBook(new Book(102, "Data Structures", "Seymour Lipschutz"));
        library.addBook(new Book(103, "Operating Systems", "Abraham Silberschatz"));
        library.addBook(new Book(104, "Database Management Systems", "Raghu Ramakrishnan"));

        // ---------- USERS ----------
        library.addUser(new User(1, "Lasya"));
        library.addUser(new User(2, "Harsha"));

        int choice;
        do {
            System.out.println("\n===== DIGITAL LIBRARY =====");
            System.out.println("1. Admin Login");
            System.out.println("2. User Access");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter admin username: ");
                    String uname = sc.next();
                    System.out.println("Note: Password will not be visible while typing.");

                    int pwd;
                    if (console != null) {
                        char[] p = console.readPassword("Enter password: ");
                        pwd = Integer.parseInt(new String(p));
                    } else {
                        System.out.print("Enter password: ");
                        pwd = sc.nextInt();
                    }

                    if (admin.authenticate(uname, pwd)) {
                        adminMenu(sc, library);
                    } else {
                        System.out.println("Invalid admin credentials.");
                    }
                    break;

                case 2:
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    User user = library.findUser(userId);

                    if (user != null) {
                        userMenu(sc, library);
                    } else {
                        System.out.println("Invalid User ID.");
                    }
                    break;

                case 3:
                    System.out.println("Exiting Library System.");
            }

        } while (choice != 3);

        sc.close();
    }

    // ---------- ADMIN MENU ----------
    private static void adminMenu(Scanner sc, Library library) {
        int ch;
        do {
            System.out.println("\n--- ADMIN MENU ---");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. View All Books");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Book ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    library.addBook(new Book(id, title, author));
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeBook(sc.nextInt());
                    break;

                case 3:
                    library.showAllBooks();
                    break;
            }
        } while (ch != 4);
    }

    // ---------- USER MENU ----------
    private static void userMenu(Scanner sc, Library library) {
        int ch;
        do {
            System.out.println("\n--- USER MENU ---");
            System.out.println("1. View Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Back");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    library.showAvailableBooks();
                    break;
                case 2:
                    System.out.print("Enter Book ID to issue: ");
                    library.issueBook(sc.nextInt());
                    break;
                case 3:
                    System.out.print("Enter Book ID to return: ");
                    library.returnBook(sc.nextInt());
                    break;
            }
        } while (ch != 4);
    }
}
