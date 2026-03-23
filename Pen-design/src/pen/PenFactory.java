//pen factory
package pen;

public class PenFactory {

    public static Pen getPen(String type, String color, boolean hasCap) {

        switch (type.toLowerCase()) {
            case "ball":
                return new BallPen(color, hasCap);

            case "gel":
                return new GelPen(color, hasCap);

            case "fountain":
                return new FountainPen(color, hasCap);

            default:
                throw new IllegalArgumentException("Invalid pen type");
        }
    }
}