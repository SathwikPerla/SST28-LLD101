public class WhatsAppSender extends NotificationSender {

    public WhatsAppSender(AuditLog audit) {
        super(audit);
    }

    protected void deliver(Notification n) {
        System.out.println("WA -> to=" + n.phone + " body=" + safe(n.body));
    }

    protected String type() {
        return "wa";
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }
}