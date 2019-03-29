/* ConcentricCircles.java
 * Author:  William Craycroft
 * Module:  7
 * Project: Homework 7, Project 1
 * Problem Statement: This program uses a recursive method to draw two sets of concentric circles using JFrame.
 *
 * Algorithm / Plan:
 *      1. Instantiate JFrame.
 *      2. Draw one sets of concentric circles recursively with fixed pixel offset
 *          If diameter < 20, stop drawing circles
 *          Else,
 *              Set color to shade of grey based on diameter (diam, diam, diam)
 *              Draw oval using current diameter
 *              Call method recursively with parameter of diameter - offset
 *      3. Repeat step 1, but reducing diameter by 10% each recursion rather than fixed pixels.
 */

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

public class ConcentricCircles extends JFrame {

    public static final String TITLE = "Concentric Circles";
    public static final int WIDTH = 620, HEIGHT = 340;
    public static final int OUTER_DIAMETER = 255;
    public static final int LEFT_CENTER_X = 150;
    public static final int RIGHT_CENTER_X = 450;
    public static final int CENTER_Y = 175;
    public static final int OFFSET_PIXELS = 20;
    public static final double OFFSET_RATIO = 0.1;

    public void paint(Graphics canvas) {

        // Draw left circles with a static 20 pixel offset between circles
        drawConcentricCircles(canvas, LEFT_CENTER_X, CENTER_Y, OUTER_DIAMETER, OFFSET_PIXELS, 0.0);
        // Draw right circles with a 10% pixel offset ratio between circles
        drawConcentricCircles(canvas, RIGHT_CENTER_X, CENTER_Y, OUTER_DIAMETER, 0, OFFSET_RATIO);

    }

    public void drawConcentricCircles(Graphics canvas, int centerX, int centerY, int diameter,
                                            int pixelOffset, double ratioOffset) {
        // Base case, diameter < 20
        if (diameter < 20) {
            return;
        }
        // Set color
        canvas.setColor(new Color(diameter, diameter, diameter));
        // Draw circle
        canvas.fillOval(centerX - diameter / 2, centerY - diameter / 2, diameter, diameter);
        // Call recursively
        drawConcentricCircles(canvas, centerX, centerY, (int) Math.round((diameter - pixelOffset) * (1 - ratioOffset)),
                pixelOffset, ratioOffset);
    }

    // Draws JFrame window
    public static void main (String args[]) {
        JFrame face = new ConcentricCircles();
        face.setSize(WIDTH, HEIGHT);
        face.setTitle(TITLE);
        face.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        face.setLocationRelativeTo(null);
        face.setVisible(true);
    }


}
