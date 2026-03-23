import pen.*;

public class Main {

    public static void main(String[] args) {

        Pen pen = PenFactory.getPen("gel", "blue", true);

        try {
            pen.start();
            pen.write("Hello Scaler");
            pen.close();
            pen.refill();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}