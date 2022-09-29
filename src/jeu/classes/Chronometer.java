package jeu.classes;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Font;
import static jeu.classes.Fenaitre.frame;

//Lancer un chrono pendat un délai défini

public class Chronometer extends JFrame implements ActionListener {

    public static int seconds, minutes, hours;
    public Timer chronometer;
    private JButton runStop;
    private JLabel time;
    private JLabel timeOver;
    
    
    //Constructeur pour initialiser les attributs et les éléments de l'interface Chronometer
    public Chronometer() {
        this.setTitle("Chronometer");
        this.setBounds(0, 0, 300, 100);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setResizable(false);
        this.getContentPane().setLayout(new FlowLayout(FlowLayout.LEFT));
        runStop = new JButton("Stop");
        runStop.setBackground(new Color(13,144,178));
        runStop.addActionListener(this);

        seconds = 0;
        minutes = 0;
        hours = 0;

        time = new JLabel(hours + " : " + minutes + " : " + seconds + "  |  " + "0 : " + JeuDeLabyrinrhe.minuteOver + " : " + JeuDeLabyrinrhe.secondeOver);
        time.setFont(new Font("Serif", Font.BOLD, 19));
        this.add(runStop);
        this.add(time);
        chronometer = new Timer(1000, this);
        chronometer.start();
    }

    //Redéfinition de la méthode actionPerformed pour stoper le chronomter après un délai
    @Override
    public void actionPerformed(ActionEvent e) {

        if (minutes == 1 && seconds == 0 && JeuDeLabyrinrhe.minuteOver == 1 && JeuDeLabyrinrhe.secondeOver == 0) {
            JeuDeLabyrinrhe.minuteJeu = 1;
            chronometer.stop();

        }
        if (minutes == 1 && seconds == 30 && JeuDeLabyrinrhe.minuteOver == 1 && JeuDeLabyrinrhe.secondeOver == 30) {
            JeuDeLabyrinrhe.minuteJeu = 1;
            chronometer.stop();
        }
        if (seconds == 50 && minutes == 1 && JeuDeLabyrinrhe.minuteOver == 1 && JeuDeLabyrinrhe.secondeOver == 50) {
            JeuDeLabyrinrhe.minuteJeu = 1;
            chronometer.stop();
        }
        if (minutes == 3 && seconds == 0 && JeuDeLabyrinrhe.minuteOver == 3) {
            JeuDeLabyrinrhe.minuteJeu = 1;
            chronometer.stop();
        }
        if (e.getSource() instanceof Timer) {
            seconds++;
            if (seconds == 60) {
                minutes++;
                seconds = 0;
                if (minutes == 60) {
                    hours++;
                    minutes = 0;
                }

            }
            time.setText(hours + " : " + minutes + " : " + seconds + "  |  " + "0 : " + JeuDeLabyrinrhe.minuteOver + " : " + JeuDeLabyrinrhe.secondeOver);
            time.setFont(new Font("Serif", Font.BOLD, 19));
            return;
        } else if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("run")) {
                chronometer.start();
                button.setText("Stop");
            } else if (button.getText().equals("Stop")) {
                chronometer.stop();
                button.setText("run");

            } else if (button.getText().equals("restart")) {
                seconds = 0;
                minutes = 0;
                hours = 0;
                chronometer.stop();
                time.setText(hours + " : " + minutes + " : " + seconds);
            }
        }

    }
}
