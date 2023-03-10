package com.example.progetto_uni;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.Rectangle;

import java.util.Timer;

public class Player {

    /*
    variabili per l'image
     */

    private final Image first = new Image("Player.png");
    private final Image secondD = new Image("Player2D.png");

    private final Image secondS= new Image("Player2S.png");

    private final Image third = new Image("Player3.png");

    public ImageView img;


    /*
    COSTANTI
     */

    public static final int XBORDOMAX = 1191;



    //variabili di posizione
    public ModelLivello gameWorld;
    public boolean cooldownOn =false;
    public int tCooldown=0;
    private DoubleProperty posXProperty;
    private int posYMin = 10;
    private double gravity=1.5;
    private DoubleProperty posYProperty;
    private int posX;
    private int posY;
    private int direction;
    private double aY = 11;

    //variabili per il jump
    private double vY = 0;
    private double time = 0;
    public boolean UnderGravityOn=false;
    public boolean gravitaAttiva= false;

    private double vY0=10;

    public Rectangle collider;
    Timer timer = new Timer();
    private boolean isAlive=false;
    private int  life=3;

    public Player(ModelLivello gameWorld) {

        this.gameWorld= gameWorld;
        posX = 1;
        posY = posYMin;
        collider = new Rectangle(posX,posY,61,88);
        posXProperty = new SimpleDoubleProperty(posX);
        posYProperty = new SimpleDoubleProperty(posY);
        this.direction=1;
        img = new ImageView(first);

    }


    public void jump(double vX) {

        if (onGround() ) {
            gravitaAttiva=true;
            vY0=3.5;
        }

    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void moveRight(int v) {
        int newPos; // e anche quando salti poi puoi continuare a correre

        if (!gravitaAttiva && !onGround()) {
            gravitaAttiva=true;
            vY0=0;
        }
        newPos = posX + v ;
        inBounds(newPos);

    }


    public boolean onGround() {
        return (posY == posYMin);

    }



    public void dash(int d) {
        inBounds(posX += 300 * d);

    }

    public void inBounds(double x) {
        if (x < 0)
            posX = 0;
        else if (x >= XBORDOMAX)
            posX =XBORDOMAX;
        else
            posX = (int) x;

    }

    public void underGravity() {

        if (gravitaAttiva) {

            vY = vY0 - (gravity* time);
            int var= (int)  Math.round (posY+ time * vY);
            if ((var< posYMin)) {// dare nome alle variabili
                posY = posYMin;
                time = 0;
                gravitaAttiva=false;

            }
            else posY = (int)  Math.round (posY + 0.5 * (time * vY));

            time += 0.0104;

            }
        }




    public void fire () {

        Bullet b = new Bullet(posX+10, posY+20, this.direction*2, 10);
        gameWorld.bullets.add(b);


    }

    public void aggiornaCollider() {
        this.collider.setLocation(posX, posY);

    }

    public void cooldown() {
        if (cooldownOn) {
            tCooldown++;
            if (tCooldown>70) {
                cooldownOn=false;
                tCooldown=0;
            }}}

    public void aggiornaYmin(double i) {
        posYMin = (int) i;
    }


    public void collisionDetection(Bullet bullet) {
        if (this.collider.intersects(bullet.collider) && bullet.isAlive) {
            life=life-bullet.damage;
            bullet.isAlive=false;
            if (this.life<=0)
                isAlive=false;
            System.out.println("gioco finito");
        }
    }

    public int getPosX() {
        // TODO Auto-generated method stub
        return posX;
    }

    public int getPosY() {
        // TODO Auto-generated method stub
        return posY;
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