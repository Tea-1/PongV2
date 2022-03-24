package components;

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

public class Scoreboard extends JPanel {

    private long score;
    private long now;
    private JLabel scoreLabel;
    private double factor;
    private long lastNum;

    public Scoreboard() {
        score = 0L;
        factor = 1.0;
        lastNum = 0;
        now = System.nanoTime();

        scoreLabel = new JLabel("" + score);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        scoreLabel.setForeground(Color.WHITE);
    }

    private void updateScore() {
        score = (System.nanoTime() - now);

        scoreLabel.setText("" + score/1000000000 + "-" + factor + "x");

        if (score/1000000000 % 10 == 0 && score/1000000000 != lastNum/1000000000 && score/1000000000 != 0) {
            factor += 0.1;
            factor = (double) Math.round((factor / 100 * 100) * 10) / 10;
            lastNum = score;
        }
    }

    public void resetScore() {
        now = System.nanoTime();
        score = 0L;
        factor = 1.0;
        lastNum = 0;
        updateScore();
    }

    public int getScore() {
        long x = score/1000000000;
        return (int) x;
    }

    public void paint(JPanel panel) {
        updateScore();
        panel.add(scoreLabel);
    }

    public double getFactor() {
        return factor;
    }








    /*
    private JLabel comScoreLabel;
    private JLabel userScoreLabel;

    private int comScore;
    private int userScore;

    public Scoreboard() {
        comScore = 0;
        userScore = 0;

        comScoreLabel = new JLabel("0   ");
        comScoreLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        comScoreLabel.setForeground(Color.WHITE);

        Dimension size = comScoreLabel.getPreferredSize();
        comScoreLabel.setBounds(1280/2-150, 10, size.width, size.height);
        comScoreLabel.setForeground(Color.WHITE);

        userScoreLabel = new JLabel("0");
        userScoreLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        userScoreLabel.setForeground(Color.WHITE);
    }

    public void addUserScore() {
        userScore++;
        userScoreLabel.setText("" + userScore);
    }

    public void addComScore() {
        comScore++;
        comScoreLabel.setText(comScore + "   ");

    }

    public void paint (JPanel panel) {
        panel.add(comScoreLabel);
        panel.add(userScoreLabel);
    } */
}