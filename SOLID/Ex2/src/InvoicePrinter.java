public class InvoicePrinter {

    public void print(String content) {
        String printable = InvoiceFormatter.identityFormat(content);
        System.out.print(printable);
    }

    public void printSaved(String id, int lines) {
        System.out.println("Saved invoice: " + id + " (lines=" + lines + ")");
    }
}