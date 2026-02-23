public class SmsSender extends NotificationSender {

    public SmsSender(AuditLog audit) {
        super(audit);
    }

    protected void deliver(Notification n) {
        System.out.println("SMS -> to=" + n.phone + " body=" + safe(n.body));
    }

    protected String type() {
        return "sms";
    }

    private String safe(String s) {
        return s == null ? "" : s;
    }
}