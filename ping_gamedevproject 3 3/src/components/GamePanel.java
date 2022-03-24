package components;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;


public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private static final long serialVersionUID = 5194319078091921553L;

    Timer t = new Timer(5, this); // The timer controls the redrawing in some way.

    Paddle playerPaddle = new Paddle(getWidth(), 50);
    Paddle compPaddle = new Paddle(0, 100);
    PingCom com = new PingCom(compPaddle);
    Scoreboard scoreboard = new Scoreboard();
    Ball pingBall = new Ball(100, 600);
    Shop shop = new Shop();
    SpeedUpgrade speedUpgrade = new SpeedUpgrade(1130, 670);
    JLabel errorMSGLabel;
    long errorLabelTimer;
    BufferedImage bgImg;

    //constructor, initializes keylistener and other things
    public GamePanel() {
        t.start();
        this.setBackground(Color.BLACK);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        bgImg = GetImage.retrieve("space_bg.jpg");

        scoreboard.paint(this);
        shop.paint(this);


        errorLabelTimer = System.currentTimeMillis();
        errorMSGLabel = new JLabel("");
        errorMSGLabel.setBounds(500, 500, 200, 200);
        this.add(errorMSGLabel);

        this.addMouseListener( new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (speedUpgrade.isTouching(e.getX(), e.getY())) {
                    if (shop.getMoney() >= 100) {
                        shop.subMoney(100);
                        playerPaddle.upgradeSpeed();
                    }
                    else {
                        errorMSG("Not enough money: 100$ required");
                    }
                }
            }
        });
    }

    //this is what to redraw in the animation
    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImg, 0, 0, this);
        this.add(errorMSGLabel);


        pingBall.paint(this, g);
        playerPaddle.paint(this, g);
        compPaddle.paint(this, g);
        scoreboard.paint(this);
        shop.paint(this);
        speedUpgrade.paint(this, g);
    }

    // describes the behavior of all objects at every redraw
    public void actionPerformed(ActionEvent e) {

        if (pingBall.getx() < -50) {
            pingBall = new Ball(800, 200);
        }

        if (pingBall.getx() > 1600) {
            shop.addMoney((int)((double)scoreboard.getScore()*scoreboard.getFactor()));
            scoreboard.resetScore();
            pingBall = new Ball(800, 200);
        }

        pingBall.updateBall();
        playerPaddle.update(getHeight());
        com.update(getHeight());


        if (playerPaddle.isTouching(pingBall.getx() + 20, pingBall.gety())) { //ball collision with player paddle
            pingBall.bounceVertical(playerPaddle.placeOnPaddle(pingBall.gety()));
            com.setTarget(pingBall.getx(), pingBall.gety(), pingBall.getdx(), pingBall.getdy());
        }

        if(compPaddle.isTouching(pingBall.getx() -20, pingBall.gety())) { //ball collision with comp paddle
            pingBall.bounceVertical(compPaddle.placeOnPaddle(pingBall.gety()));
        }

        else if (pingBall.gety() > getHeight() - 60 || pingBall.gety() < 20) { // when ball y hits an edge, reverse y velocity (commented out todel unless a problem popps up)
            pingBall.bounceHorizontal();
            com.setTarget(pingBall.getx(), pingBall.gety(), pingBall.getdx(), pingBall.getdy());
        }

        repaint();
        errorMSG("");
    }

    public void keyPressed(KeyEvent e){// handles key controls
        int code = e.getKeyCode();

        if( code == KeyEvent.VK_UP) {
            playerPaddle.pdlUp();
        }
        if (code == KeyEvent.VK_DOWN) {
            playerPaddle.pdlDown();
        }
        /*if (code == KeyEvent.VK_1) {
            if (shop.getMoney() >= 100 && buying == false) {
                shop.subMoney(100);
                playerPaddle.upgradeSpeed();
                buying = true;
            }
            else {
                errorMSG("Not enough money: 100$ required");
            }
        }*/
    }


	public void keyTyped(KeyEvent e) {

	}

    public void keyReleased(KeyEvent e) { //stops movement at key release
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_DOWN) {
            playerPaddle.pdlRelease();
        }
        /*if(code == KeyEvent.VK_W || code == KeyEvent.VK_S){
            compPaddle.pdlRelease();
        }*/
    }


    public void initPdls() {
        playerPaddle = new Paddle(getWidth()-30, 100);
        compPaddle = new Paddle(15, 100);
        for (int i = 1; i < 3; i++) {
            compPaddle.upgradeSpeed();
        }
        speedUpgrade = new SpeedUpgrade(0, getHeight()-50);
        com = new PingCom(compPaddle);
        com.setTarget(1, 1, 1, 1);
        //pingBall = new Ball(100, 600);
    }


    public void errorMSG(String text) {

        if (text != "") {
            errorMSGLabel.setForeground(Color.WHITE);
            errorMSGLabel.setText(text);
            errorLabelTimer = System.currentTimeMillis();
        }

        if (text == "" && errorMSGLabel != null) {
            if (System.currentTimeMillis() - errorLabelTimer > 2000) {
                errorMSGLabel.setForeground(Color.BLACK);
                errorMSGLabel.setText("");
            }
        }
    }
}