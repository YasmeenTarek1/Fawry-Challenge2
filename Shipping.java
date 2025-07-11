public class Shipping implements ShippingStrategy {
    @Override
    public void ship(String title, String address) {
        System.out.println("Shipping not implemented for: " + title + " to " + address);
    }

    @Override
    public boolean isShippable() {
        return true;
    }
}
