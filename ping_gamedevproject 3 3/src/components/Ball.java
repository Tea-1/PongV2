package components;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class Ball {
    private  double x;
    private double dx;
    private double y;
    private double dy;
    private double xyIncrease;
    Shape bal;
    private BufferedImage IMG = null;

    public Ball(double x, double y){
        this.x = x;
        this.y = y;
        dy = 1.5;
        dx = 1.5;
        xyIncrease = 0.2;
        bal = new Ellipse2D.Double(x - 20, y - 20, 40, 40);

        //IMG = GetImage.retrieve("Z:\\Java Projects\\ping_gamedevproject 2\\ping_gamedevproject\\images\\ball_backup.jpg"); //windows version
        IMG = GetImage.retrieve("asteroid-icon.png"); //mac version

    }

    //TODO: Draw an image file.
    public void paint(Graphics2D g2){
        bal = new Ellipse2D.Double(x - 20, y - 20, 40, 40);
        g2.fill(bal);
    }

    public void paint(JPanel panel, Graphics g){
        g.drawImage(IMG, (int)x-20, (int)y-20, panel);
       // System.out.println("dx" + dx);
       // System.out.println("dy" + dy);
    }
    
    public void updateBall(){
        x += dx; //apply x velocity to x position
        y += dy; //apply y velocity to y position
    }

    public void bounceVertical(int bounceAngle){

        dx = -(dx + (Math.abs(bounceAngle * 0.005)));
        dy += (-bounceAngle * 0.05);

        speedUpBall();
    }

    public void bounceHorizontal(){
        dy = -dy;
        speedUpBall();
    }

    private void speedUpBall() {
        if (dy > 0) {
            dy += xyIncrease;
        }
        else {
            dy -= xyIncrease;
        }
        if (dx > 0) {
            dx += xyIncrease;
        }
        else {
            dx -= xyIncrease;
        }
    }

    public double getx(){
        return x;
    }

    public double gety(){
        return y;
    }

    public double getdy(){
        return dy;
    }

    public double getdx(){
        return dx;
    }
}