package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class GameController {
    int numOfBalls = 0;
    Sprite[] sprites = new Sprite[10];

    GameController() {
        initApplication();
    }
    private void initApplication() {
        sprites[0] = new Background();
     }

    public void onDrawFrame(GameCanvas canvas, Graphics g, float deltaTime) {
        update(canvas, deltaTime);
        render(canvas, g);
    }

    private void update(GameCanvas canvas, float deltaTime) {
        for (int i = 0; i < numOfBalls; i++) {
            sprites[i].update(canvas, deltaTime);
        }
    }

    private void render(GameCanvas canvas, Graphics g) {
        for (int i = 0; i < numOfBalls; i++) {
            sprites[i].render(canvas, g);
        }
    }

    public void addSprite(Sprite s) {
        if (numOfBalls == sprites.length) {
            Sprite[] temp = new Sprite[sprites.length * 2];
            System.arraycopy(sprites,0,temp,0,sprites.length);
            sprites = temp;
        }
        numOfBalls++;
        sprites[numOfBalls] = s;
    }

    public void deleteSprite() {
        if (numOfBalls > 1) numOfBalls--;
    }
}
