package run;

import javax.swing.*;

import components.GamePanel;

import java.awt.*;

public class Main {

    //JLabel scoreText;

    public static void main(String[] args) {
        createWindow();
    }

    public static void createWindow() {
        JFrame window = new JFrame();
        window.setSize(1280, 720);
        window.getContentPane().setBackground(Color.BLACK);
        GamePanel a = new GamePanel();
        window.add(a);
        window.setVisible(true);
        window.setTitle("Ping");

        //MouseEvents.mouseClick = false;

        a.initPdls();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}