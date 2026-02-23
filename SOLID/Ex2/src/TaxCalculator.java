public class TaxCalculator {
    public double taxPercent(String customerType) {
        return TaxRules.taxPercent(customerType);
    }
}