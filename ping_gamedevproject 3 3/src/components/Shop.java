package components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Shop {

    private JLabel shopLabel;
    int money;

    public Shop() {
        money = 0;

        shopLabel = new JLabel("$0");
        shopLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        shopLabel.setForeground(Color.WHITE);
        // create a line border with the specified color and width
        Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
        shopLabel.setBorder(border);
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void subMoney(int amount) {
        money -= amount;
    }

    public int getMoney() {
        return money;
    }


    public void paint(JPanel panel) {
        shopLabel.setText("$" + money);
        panel.add(shopLabel);
    }
}
