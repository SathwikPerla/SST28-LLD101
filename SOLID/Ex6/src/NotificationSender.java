public abstract class NotificationSender {

    protected final AuditLog audit;

    protected NotificationSender(AuditLog audit) {
        this.audit = audit;
    }

    public final void send(Notification n) {
        if (n == null)
            throw new IllegalArgumentException("notification required");

        deliver(n);
        audit.add(type() + " sent");
    }

    protected abstract void deliver(Notification n);

    protected abstract String type();
}