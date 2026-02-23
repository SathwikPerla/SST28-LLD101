import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {

    protected ExportResult doExport(ExportRequest req) {
        String fakePdf = "PDF(" + req.title + "):" + safe(req.body);
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }
}