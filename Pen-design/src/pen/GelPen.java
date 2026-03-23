//concrete 
package pen;

public class GelPen extends Pen {

    public GelPen(String color, boolean hasCap) {
        super(color, hasCap, 80);
    }

    @Override
    public String getType() {
        return "GelPen";
    }
}