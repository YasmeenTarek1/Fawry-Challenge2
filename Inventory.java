import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;

public class Inventory {
    HashMap<String, InventoryItem> books; // <ISBN, <Book, quantity>>

    public Inventory() {
        books = new HashMap<>();
    }

    public void addBook(Book book, int quantity) {
        books.put(book.getISBN(), new InventoryItem(book, quantity));
    }

    public void removeBook(String ISBN) {
        if (books.containsKey(ISBN)) {
            books.remove(ISBN);
        } else {
            System.out.println("Book not found.");
        }
    }

    public ArrayList<String> removeOutdatedBooks(int numOfYears) {
        ArrayList<String> toRemove = new ArrayList<>();

        for (String b : books.keySet()) {
            if (Year.now().getValue() - books.get(b).getBook().getYearOfPublication() > numOfYears) {
                toRemove.add(b);
            }
        }

        for (String isbn : toRemove) {
            books.remove(isbn);
        }

        return toRemove;
    }

    public double buyBook(String ISBN, int quantity, String email, String address) {
        if(!books.get(ISBN).getBook().isSellable()) {
            System.out.println("This book is not for sale.");
            return 0.0;
        }

        try {
            books.get(ISBN).decreaseQuantity(quantity);
            double paidAmount = books.get(ISBN).getBook().getPrice() * quantity;

            Book book = books.get(ISBN).getBook();

            // Send book to ShippingService with the address provided (ShippingService will handle all shipping logic including if the book is not shippable)
            ShippingService shippingService = new ShippingService();
            shippingService.ship(book, address);

            // Send to MailService with the email provided (MailService will handle all shipping logic including if the book is not shippable)
            MailService mailService = new MailService();
            mailService.sendByEmail(book, email);

            return paidAmount;
        } catch (IllegalArgumentException e) {
            System.out.println("Not enough stock available for this book.");
            return 0.0;
        }
    }

    public void displayInventory() {
        System.out.println("=== Inventory ===");
        for (String isbn : books.keySet()) {
            InventoryItem item = books.get(isbn);
            System.out.println(item.getBook().toString() + "Quantity: " + item.getQuantity());
        }
    }
}
