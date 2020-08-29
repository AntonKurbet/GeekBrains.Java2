package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainCircles extends JFrame {
    private static final int POS_X = 400;
    private static final int POS_Y = 200;
    private static final int WINDOW_WIDTH = 800;
    private static final int WINDOW_HEIGHT = 600;

    private static GameController controller;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainCircles();
            }
        });
    }

    private MainCircles() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onClick(e);
            }
        });

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(POS_X, POS_Y, WINDOW_WIDTH, WINDOW_HEIGHT);
        controller = new GameController();
        GameCanvas canvas = new GameCanvas(controller);
        add(canvas, BorderLayout.CENTER);
        setTitle("Circles");
        setVisible(true);
    }

    private void onClick(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: controller.addSprite(new Ball(e.getX(),e.getY()));
                break;
            case MouseEvent.BUTTON3: controller.deleteSprite();
        }
    }
}
