public interface ShippingStrategy{
    void ship(String title, String address);
    boolean isShippable();
}
