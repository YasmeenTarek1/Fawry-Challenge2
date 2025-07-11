public abstract class Book {
    private String ISBN;
    private String title;
    private String author;
    private double price;
    private int yearOfPublication;

    protected ShippingStrategy shippingStrategy;
    protected EmailSendingStrategy sendingStrategy;

    public Book(String ISBN, String title, String author, double price, int yearOfPublication) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.price = price;
        this.yearOfPublication = yearOfPublication;

        // Default is no behavior
        this.shippingStrategy = new NoShipping();
        this.sendingStrategy = new NoEmailSending();
    }

    public abstract boolean isSellable();

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }
}
