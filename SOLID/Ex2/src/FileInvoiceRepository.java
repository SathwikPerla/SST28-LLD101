public class FileInvoiceRepository implements InvoiceRepository {
    private final FileStore store;

    public FileInvoiceRepository(FileStore store) {
        this.store = store;
    }

    public void save(String id, String content) {
        store.save(id, content);
    }

    public int countLines(String id) {
        return store.countLines(id);
    }
}