import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class ConcentricCircles extends JFrame {

    public static final String TITLE = "Circle in Square";
    public static final int WIDTH = 620, HEIGHT = 340;
    public static final int OUTER_DIAMETER = 255;
    public static final int LEFT_CENTER_X = 150;
    public static final int RIGHT_CENTER_X = 450;
    public static final int CENTER_Y = 175;

    public void paint(Graphics canvas) {

        drawLinearConcentricCircles(canvas, LEFT_CENTER_X, CENTER_Y, OUTER_DIAMETER);
        drawExponentialConcentricCircles(canvas, RIGHT_CENTER_X, CENTER_Y, OUTER_DIAMETER);

    }

    public void drawLinearConcentricCircles(Graphics canvas, int centerX, int centerY, int diameter) {
        // Base case, diameter < 20
        if (diameter < 20) {
            return;
        }
        // Set color
        canvas.setColor(new Color(diameter, diameter, diameter));
        // Draw circle
        canvas.fillOval(centerX - diameter / 2, centerY - diameter / 2, diameter, diameter);
        // Call recursively
        drawLinearConcentricCircles(canvas, centerX, centerY, diameter - 20);
    }

    public void drawExponentialConcentricCircles(Graphics canvas, int centerX, int centerY, int diameter) {
        // Base case, diameter < 20
        if (diameter < 20) {
            return;
        }
        // Set color
        canvas.setColor(new Color(diameter, diameter, diameter));
        // Draw circle
        canvas.fillOval(centerX - diameter / 2, centerY - diameter / 2, diameter, diameter);
        // Call recursively
        drawExponentialConcentricCircles(canvas, centerX, centerY, diameter * 9 / 10);
    }

    public static void main (String args[]) {
        JFrame face = new ConcentricCircles();
        face.setSize(WIDTH, HEIGHT);
        face.setTitle(TITLE);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        face.setLocationRelativeTo(null);
        face.setVisible(true);
    }


}
