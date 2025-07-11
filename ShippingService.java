public class ShippingService {
    public void ship(Book book, String address) {
        if(!book.shippingStrategy.isShippable()) {
            System.out.println("This book type cannot be shipped");
            return;
        }

        if(book instanceof StockCheckable sc && !sc.isInStock()) {
            System.out.println("Out of stock");
            return;
        }

        book.shippingStrategy.ship(book.getTitle(), address);
    }
}
