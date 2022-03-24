package components;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class SpeedUpgrade {
    private double X;
    private double Y;
    private BufferedImage IMG;

    public SpeedUpgrade(double x, double y) {
        this.X = x;
        this.Y = y;
        System.out.println("X: " + x + "Y: " + y);
        //IMG = GetImage.retrieve("Z:\\Java Projects\\ping_gamedevproject 2\\ping_gamedevproject\\images\\speed_upgrade_icon.jpg");
        IMG = GetImage.retrieve("speed_upgrade_icon.jpg"); //mac version
    }

    public void paint(JPanel panel, Graphics g) {
        g.drawImage(IMG, (int)X, (int)Y, null);
    }

    public boolean isTouching(double inx, double iny) {
        return ((inx > this.X) && (inx < this.X + 150)) && ((iny > this.Y) && (iny < this.Y + 50));
    }
}
