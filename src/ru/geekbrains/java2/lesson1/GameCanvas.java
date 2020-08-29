package ru.geekbrains.java2.lesson1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameCanvas extends JPanel {

    private long lastFrameTime;
    private GameController controller;

    GameCanvas(GameController controller) {
        this.controller = controller;
        lastFrameTime = System.nanoTime();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                onClick(e);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        long currentTime = System.nanoTime();
        float deltaTime = (currentTime - lastFrameTime) * 0.000000001f;
        controller.onDrawFrame(this, g, deltaTime);
        lastFrameTime = currentTime;
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    public int getLeft() { return 0; }
    public int getRight() { return getWidth() - 1; }
    public int getTop() { return 0; }
    public int getBottom() { return getHeight() - 1; }

    private void onClick(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1: controller.addBall();
                break;
            case MouseEvent.BUTTON3: controller.deleteBall();
        }
    }

}
