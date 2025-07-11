public class NoShipping implements ShippingStrategy {
    @Override
    public void ship(String title, String address) {
        System.out.println("No shipping available for " + title + " to " + address);
    }

    @Override
    public boolean isShippable() {
        return false;
    }
}
