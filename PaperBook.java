public class PaperBook extends Book implements StockCheckable{
    private int stock;

    public PaperBook(String ISBN, String title, String author, double price, int yearOfPublication, int stock, ShippingStrategy shippingStrategy, EmailSendingStrategy sendingStrategy) {
        super(ISBN, title, author, price, yearOfPublication);
        this.stock = stock;
        this.shippingStrategy = shippingStrategy;
        this.sendingStrategy = sendingStrategy;
    }

    @Override
    public boolean isSellable() {
        return true;
    }

    public boolean isInStock() {
        return stock > 0;
    }

    @Override
    public String toString() {
        return "- PaperBook: " + getTitle() + " (" + getYearOfPublication() + ") | ISBN: " + getISBN() + " | Price: $" + getPrice() + " | Stock: " + stock + "\n";
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
