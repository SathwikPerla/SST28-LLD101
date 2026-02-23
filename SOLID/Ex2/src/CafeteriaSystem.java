import java.util.*;

public class CafeteriaSystem {

    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceRepository repo = new FileInvoiceRepository(new FileStore());
    private final InvoiceGenerator generator = new InvoiceGenerator();
    private final InvoicePrinter printer = new InvoicePrinter();

    private int invoiceSeq = 1000;

    public void addToMenu(MenuItem i) {
        menu.put(i.id, i);
    }

    public void checkout(String customerType, List<OrderLine> lines) {

        String invId = "INV-" + (++invoiceSeq);

        String invoice = generator.generate(invId, customerType, lines, menu);

        printer.print(invoice);

        repo.save(invId, invoice);

        printer.printSaved(invId, repo.countLines(invId));
    }
}