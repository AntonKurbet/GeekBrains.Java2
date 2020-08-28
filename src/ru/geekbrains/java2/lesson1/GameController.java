package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class GameController {
    int numOfBalls = 10;
    static final int MAX_BALLS = 100;
    Sprite[] sprites = new Sprite[MAX_BALLS];
    Background back = new Background();

    GameController() {
        initApplication();
    }
    private void initApplication() {
        for (int i = 0; i < numOfBalls; i++) {
            sprites[i] = new Ball();
        }
    }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        back.update(canvas, deltaTime);
        for (int i = 0; i < numOfBalls; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        back.render(canvas, g);
        for (int i = 0; i < numOfBalls; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public void addBall() {
        if (numOfBalls < MAX_BALLS) {
            sprites[numOfBalls] = new Ball();
            numOfBalls++;
        }
    }

    public void deleteBall() {
        if (numOfBalls > 0) {
            sprites[numOfBalls] = null;
            numOfBalls--;
        }
    }
}
