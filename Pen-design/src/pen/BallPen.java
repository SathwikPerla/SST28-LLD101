package pen;
// concrete class

public class BallPen extends Pen {

    public BallPen(String color, boolean hasCap) {
        super(color, hasCap, 100);
    }

    @Override
    public String getType() {
        return "BallPen";
    }
}