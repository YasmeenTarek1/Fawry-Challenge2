public class EBook extends Book {
    private String fileType;

    public EBook(String ISBN, String title, String author, double price, int yearOfPublication, String fileType, ShippingStrategy shippingStrategy, EmailSendingStrategy sendingStrategy) {
        super(ISBN, title, author, price, yearOfPublication);
        this.fileType = fileType;
        this.shippingStrategy = shippingStrategy;
        this.sendingStrategy = sendingStrategy;
    }

    @Override
    public boolean isSellable() {
        return true;
    }

    @Override
    public String toString() {
        return "- EBook: " + getTitle() + " (" + getYearOfPublication() + ") | ISBN: " + getISBN() + " | Price: $" + getPrice() + " | Format: " + fileType + "\n";
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }
}
