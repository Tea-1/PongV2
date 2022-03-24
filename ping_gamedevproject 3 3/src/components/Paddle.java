package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Paddle {
    private BufferedImage IMG = null;
    public final double X;
    public double y;
    public double dy;
    public double dyUP = -2.5;
    public double dyDOWN = 2.5;
    Shape pdl;


    public Paddle(double x, double y) {
        this.X = x;
        this.y = y;
        dy = 0;
        pdl = new Rectangle2D.Double(X, y, 50, 50);
        //IMG = GetImage.retrieve("Z:\\Java Projects\\ping_gamedevproject 2\\ping_gamedevproject\\images\\paddle.jpg");
        IMG = GetImage.retrieve("paddle.jpg"); //mac version

    }

    //TODO: draw an image file
    public void paint(Graphics2D g2) {
        pdl = new Rectangle2D.Double(X, y, 10, 100);
        g2.fill(pdl);
        //g2.drawImage();
    }

    public void paint(JPanel panel, Graphics g) {
        g.drawImage(IMG, (int)X, (int)y, panel);
    }

    public void update(int height){
        if(y < 0){
            y = 0;
        }
        else if(y > height-100){
            y = height - 100;
        }
        else{
            y += dy;
        }
    }

    public void upgradeSpeed() {
        dyUP -= 1;
        dyDOWN += 1;
    }

    public void pdlUp(){
        dy = dyUP;
    }
    public void pdlDown(){
        dy = dyDOWN;
    }
    public void pdlRelease(){
        dy = 0;
    }

    public boolean isTouching(double inx, double iny) {
        return ((inx > this.X) && (inx < this.X + 10)) && ((iny > this.y) && (iny < this.y + 100));
    }

    public int placeOnPaddle(double iny) {
        return (int)(this.y + 50 - iny);
    }

    public double getx() {
        return X;
    }

    public double gety() {
        return y;
    }

    //TODO: delete
    public double getdy() {
        return dy;
    }
}