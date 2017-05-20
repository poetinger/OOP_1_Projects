package cardGame;

import cardGame.game.Draw;

import cardGame.view.DrawPanel;

import cardGame.controller.ButtonBar;

import javax.swing.JFrame;

import java.awt.Dimension;

/**
 * Runs the game. Although technically a controller this class can be found
 * more easily if it's not in that package
 */
public class Main {
    public static void main(String[] args) {
        Draw draw = new Draw();
        JFrame frame = new JFrame("Card game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(new ButtonBar(draw));
        DrawPanel panel = new DrawPanel(draw);
        frame.getContentPane().add(panel);
        frame.setPreferredSize(new Dimension(800, 600));
        frame.pack();
        frame.setLocationRelativeTo (null); // Center on screen.
        frame.setVisible(true);
    }
}
