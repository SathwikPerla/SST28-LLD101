public class DiscountCalculator {
    public double discount(String customerType, double subtotal, int lines) {
        return DiscountRules.discountAmount(customerType, subtotal, lines);
    }
}