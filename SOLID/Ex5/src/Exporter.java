public abstract class Exporter {

    public final ExportResult export(ExportRequest req) {
        if (req == null)
            throw new IllegalArgumentException("request cannot be null");

        if (req.title == null)
            throw new IllegalArgumentException("title required");

        return doExport(req);
    }

    protected abstract ExportResult doExport(ExportRequest req);
}