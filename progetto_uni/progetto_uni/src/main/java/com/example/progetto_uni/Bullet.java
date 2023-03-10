package com.example.progetto_uni;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;

public class Bullet {
    public ImageView img;

    public final javafx.scene.image.Image imageBullet= new Image("DALL·E 2023-03-03 12.27.27 - 8 bit bullet like cuphead.png");

    public Rectangle collider;
    public  int posX;
    public int posY;
    public int direction;
    public int damage;
    public boolean isAlive=true;
    public boolean imageAdedd;

    public DoubleProperty posXProperty;
    public DoubleProperty posYProperty;
    public Bullet( int posX, int posY, int direction, int damage) {

        super();
        this.collider = new Rectangle(posX,posY, 20, 20);
        this.posX = posX;
        this.posY = posY;
        this.direction=direction;
        this.damage=damage;
        posXProperty = new SimpleDoubleProperty(posX);
        posYProperty = new SimpleDoubleProperty(posY);
        this.img= new ImageView(imageBullet);
        img.setX(posX);
        img.setY(posY);
        imageAdedd=false;
    }

    public void move(){
        posX+=direction;
        aggiornaCollider();
        aggiornaProperty();
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

    public DoubleProperty posXProperty() {
        return posXProperty;
    }

    public DoubleProperty posYProperty() {
        return posYProperty;
    }
    public void aggiornaProperty(){
        posXProperty.setValue(posX);
        posYProperty.set(posY);
    }
}