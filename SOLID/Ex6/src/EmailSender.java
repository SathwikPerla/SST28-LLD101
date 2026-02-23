public class EmailSender extends NotificationSender {

    public EmailSender(AuditLog audit) {
        super(audit);
    }

    protected void deliver(Notification n) {
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + safe(n.body));
    }

    protected String type() {
        return "email";
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }
}