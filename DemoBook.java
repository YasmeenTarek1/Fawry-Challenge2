public class DemoBook extends Book {

    public DemoBook(String ISBN, String title, String author, int yearOfPublication) {
        super(ISBN, title, author, 0.0, yearOfPublication);
    }

    public boolean isSellable() {
        return false; // Demo books are not for sale
    }

    @Override
    public String toString() {
        return "- Showcase Book: " + getTitle() + " (" + getYearOfPublication() + ") | ISBN: " + getISBN() + " | Not for sale\n";
    }
}
