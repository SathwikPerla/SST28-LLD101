//Abstract class
package pen;

public abstract class Pen {

    protected String color;
    protected boolean isOpen;
    protected boolean hasCap;
    protected int inkLevel;
    protected int capacity;

    public Pen(String color, boolean hasCap, int capacity) {
        this.color = color;
        this.hasCap = hasCap;
        this.capacity = capacity;
        this.inkLevel = capacity;
        this.isOpen = false;
    }

    public void start() {
        if (isOpen) {
            System.out.println("Pen already open");
        } else {
            isOpen = true;
            System.out.println("Pen started");
        }
    }

    public void write(String text) throws PenClosedException, InkEmptyException {
        if (!isOpen) {
            throw new PenClosedException("Pen is closed");
        }

        if (inkLevel <= 0) {
            throw new InkEmptyException("No ink left");
        }

        int required = text.length();

        if (required > inkLevel) {
            text = text.substring(0, inkLevel);
        }

        System.out.println(getType() + " writing: " + text);
        inkLevel -= text.length();
    }

    public void close() {
        isOpen = false;
        System.out.println("Pen closed");
    }

    public void refill() {
        inkLevel = capacity;
        System.out.println("Refilled");
    }

    public abstract String getType();
}