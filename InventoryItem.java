public class InventoryItem {
    private Book book;
    private int quantity;

    public InventoryItem(Book book, int quantity) {
        this.book = book;
        this.quantity = quantity;
    }

    public void decreaseQuantity(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
        } else {
            throw new IllegalArgumentException("Not enough stock for: " + this.book.getTitle());
        }
    }

    public void increaseQuantity(int amount) {
        quantity += amount;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
