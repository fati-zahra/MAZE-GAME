package jeu.classes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.plaf.*;
import javax.swing.plaf.metal.*;

//Aficher l'incrémentation du conteur pendant 5 seconds
public class Test {

    private static int c = 0;

    public static class TestPane extends JPanel {

        private JLabel label;
        private Timer timer;
        private int count = 0;

        public TestPane() {
            label = new JLabel("...");
            setLayout(new GridBagLayout());
            label.setForeground(Color.cyan);
            add(label);
            timer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    count++;
                    if (count <= 5) {
                        label.setFont(new Font(Integer.toString(count), Font.ITALIC, 300));
                        label.setText(Integer.toString(count));

                    } else {
                        ((Timer) (e.getSource())).stop();
                        label.setFont(new Font("GOOOOO !!", Font.ITALIC, 100));
                        label.setText("GOOOOO !!");

                    }
                }
            });
            timer.setInitialDelay(0);
            timer.start();
        }

    }
}
