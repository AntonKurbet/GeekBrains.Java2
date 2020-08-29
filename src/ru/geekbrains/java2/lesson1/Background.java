package ru.geekbrains.java2.lesson1;

import java.awt.*;

public class Background {
    private float cR;
    private float cG;
    private float cB;
    private float vR;
    private float vG;
    private float vB;

    Background() {
        vR = (float)(10f + (Math.random() * 20f));
        vG = (float)(10f + (Math.random() * 20f));
        vB = (float)(10f + (Math.random() * 20f));
    }

    public void update(GameCanvas canvas, float deltaTime) {
        cR += vR * deltaTime;
        cG += vG * deltaTime;
        cB += vB * deltaTime;
        if (cR > 255) {cR = 255; vR = -vR;}
        if (cG > 255) {cG = 255; vG = -vG;}
        if (cB > 255) {cB = 255; vB = -vB;}
        if (cR < 0) {cR = 0; vR = -vR;}
        if (cG < 0) {cG = 0; vG = -vG;}
        if (cB < 0) {cB = 0; vB = -vB;}

    }

    public void render(GameCanvas canvas, Graphics g) {
        canvas.setBackground(new Color ((int)cR,(int)cG,(int)cB));
    }


}
