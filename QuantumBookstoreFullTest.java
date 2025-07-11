import java.util.ArrayList;

public class QuantumBookstoreFullTest {
    public static void main(String[] args) {
        ShippingStrategy physicalShipping = new Shipping();
        ShippingStrategy noShipping = new NoShipping();
        EmailSendingStrategy emailSending = new EmailSending();
        EmailSendingStrategy noEmailSending = new NoEmailSending();

        Inventory inventory = new Inventory();

        PaperBook paperBook1 = new PaperBook(
                "123-456", "Clean Code", "Robert Martin", 39.99, 2008,
                10, physicalShipping, noEmailSending
        );

        PaperBook paperBook2 = new PaperBook(
                "789-012", "Design Patterns", "GoF", 49.99, 1994,
                0, physicalShipping, noEmailSending  // Out of stock
        );

        EBook eBook = new EBook(
                "345-678", "Effective Java", "Joshua Bloch", 29.99, 2017,
                "PDF", noShipping, emailSending
        );

        DemoBook demoBook = new DemoBook(
                "901-234", "Java Basics", "Oracle", 2020
        );

        inventory.addBook(paperBook1, 10);
        inventory.addBook(paperBook2, 0);
        inventory.addBook(eBook, 100);
        inventory.addBook(demoBook, 5);

        inventory.displayInventory();

        // Test 1: Buy available paper book (should ship)
        System.out.println("\n=== Buying Clean Code (paper) ===");
        double amount = inventory.buyBook("123-456", 2, "customer1@example.com", "123 Main St");
        System.out.println("Paid: $" + amount);

        // Test 2: Buy out-of-stock paper book (shouldn't ship)
        System.out.println("\n=== Buying Design Patterns (out of stock) ===");
        try {
            amount = inventory.buyBook("789-012", 1, "customer2@example.com", "456 Oak Ave");
            System.out.println("Paid: $" + amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Test 3: Buy eBook (should email)
        System.out.println("\n=== Buying Effective Java (eBook) ===");
        amount = inventory.buyBook("345-678", 1, "customer3@example.com", "");
        System.out.println("Paid: $" + amount);

        // Test 4: Try to buy demo book
        System.out.println("\n=== Trying to buy Demo Book ===");
        amount = inventory.buyBook("901-234", 1, "customer4@example.com", "789 Pine Rd");
        System.out.println("Paid: $" + amount);

        // Test 5: Remove outdated books (older than 10 years)
        System.out.println("\n=== Removing books older than 10 years ===");
        ArrayList<String> removed = inventory.removeOutdatedBooks(10);
        System.out.println("Removed books: " + removed);
        System.out.println();

        inventory.displayInventory();
    }

}