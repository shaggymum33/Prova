package com.example.progetto_uni;



import java.awt.Rectangle;

public class Platform {
    public Rectangle collider;
    public  int posX;
    public int posY;
    public Platform( int posX, int posY) {

        super();
        this.collider = new Rectangle(posX,posY,200, 100);
        this.posX = posX;
        this.posY = posY;
    }
}
