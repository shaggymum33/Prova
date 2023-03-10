package com.example.progetto_uni;


import java.awt.Rectangle;

public class Enemy {

    public Rectangle collider;
    public  int posX;
    public int posY;
    private int direction=1;
    private double vY=1;
    private double vX=1;
    public double life;
    public boolean isAlive;
    public ModelLivello gameWorld;
    public  boolean cooldownOn=false;
    private int tCooldown=0;

    public Enemy( int posX, int posY,  ModelLivello gameWorld) {

        super();
        this.collider = new Rectangle(posX,posY, 50, 100);
        this.posX = posX;
        this.posY = posY;
        this.life=100;
        this.gameWorld=gameWorld;
        isAlive=true;
    }

    public void move() {
        // inventare pattern movimenti
        if (posY<=10 || posY>=400)
            direction*=-1;
        posY+=direction;
        aggiornaCollider();
    }



    public void fire(int playerX , int playerY) {
        if (!cooldownOn) {
            Bullet b = new Bullet(this.posX+10, this.posY+20, -2, 10);
            gameWorld.Ebullets.add(b);
            cooldownOn=true;
        }
    }


    private void aggiornaCollider() {
        collider.setLocation(posX, posY);
    }

   public void collisionDetection(Bullet bullet) {

        if (this.collider.intersects(bullet.collider) && bullet.isAlive) {
            life=life-bullet.damage;

            bullet.isAlive=false;

        }

        if (life<0)
            isAlive=false;
    }

    public void cooldown() {
        if (cooldownOn) {
            tCooldown++;

            if (tCooldown>500) {
                cooldownOn=false;
                tCooldown=0;
            }}}



}