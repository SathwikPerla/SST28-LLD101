import java.util.*;

public class InvoiceGenerator {

    private final TaxCalculator taxCalc = new TaxCalculator();
    private final DiscountCalculator discCalc = new DiscountCalculator();

    public String generate(
            String invId,
            String customerType,
            List<OrderLine> lines,
            Map<String, MenuItem> menu) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        double subtotal = 0.0;

        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            out.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }

        double taxPct = taxCalc.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);

        double discount = discCalc.discount(customerType, subtotal, lines.size());

        double total = subtotal + tax - discount;

        out.append(String.format("Subtotal: %.2f\n", subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        out.append(String.format("Discount: -%.2f\n", discount));
        out.append(String.format("TOTAL: %.2f\n", total));

        return out.toString();
    }
}