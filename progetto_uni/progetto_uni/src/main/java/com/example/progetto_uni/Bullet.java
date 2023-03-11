package com.example.progetto_uni;

import java.awt.*;

public class Bullet {

    public Rectangle collider;
    public  int posX;
    public int posY;
    public int direction;
    public int damage;
    public boolean isAlive;

    public Bullet( int posX, int posY, int direction, int damage, boolean isAlive) {

        super();
        this.collider = new Rectangle(posX,posY, 20, 20);
        this.posX = posX;
        this.posY = posY;
        this.direction=direction;
        this.damage=damage;
        this.isAlive=isAlive;

    }

    public void move(){
        posX+=direction;
        aggiornaCollider();
        imOut();
    }

    private void aggiornaCollider() {
        collider.setLocation(posX, posY);
    }

    /*
  * controllo se sono dentro i bordi, se sono fuori isAlive diventa falso
   */
    private void imOut() {
        if(posX<0 || posX>1280 || posY<0 || posY>800)
            isAlive=false;
    }


}