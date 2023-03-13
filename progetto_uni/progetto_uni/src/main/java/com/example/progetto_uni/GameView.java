package com.example.progetto_uni;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class GameView extends JPanel {

    /**
     * Create the panel.
     */

    Player player;
     ModelLivello  gameWorld;

    public GameView( ModelLivello gameWorld) {
        this.gameWorld=gameWorld;
        this.player=gameWorld.player;

        
        this.setPreferredSize(new Dimension(1280, 800))  ;
        if( this.requestFocusInWindow())
            System.out.println("Focus ottenuto");


        Timer t = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
               repaint();


            }
        };
        t.schedule(task, 10, 30);
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.black);
        int y =getHeight();
        g2.translate(0, y);
        g2.scale(1, -1);
        //sfondo
        g2.fillRect(0, 0, getWidth() , y );

        //collider piattaforme
        g2.setColor(Color.green);
        for(Platform p : gameWorld.platforms )
            g2.fillRect(p.posX, p.posY, 200 ,100);

        //piattaforme
        g2.setColor(Color.white);
        for(Platform p : gameWorld.platforms )
            g2.fillRect(p.posX, p.posY, 200 ,20);

        //bullets
        g2.setColor(Color.orange);
        for(Bullet b : gameWorld.bullets ) {
            if(b.isAlive)
                g2.fillRect(b.posX, b.posY, 10 ,10);}
        //EnemyBullets
        for(Bullet b : gameWorld.Ebullets ) {
            if(b.isAlive)
                g2.fillRect(b.posX, b.posY, 10 ,10);}

        //Enemy
        g2.setColor(Color.red);
        if(gameWorld.enemy.isAlive)
            g2.fillRect(gameWorld.enemy.posX, gameWorld.enemy.posY, 50, 100);
        g2.setColor(Color.blue);
        g2.drawRect( gameWorld.enemy.collider.x, gameWorld.enemy.collider.y, gameWorld.enemy.collider.width, gameWorld.enemy.collider.height  );

        //colliderPlayer
        g2.setColor(Color.red);
        g2.fillRect(player.getPosX(), player.getPosY(), (int) player.collider.getWidth(), (int)player.collider.getHeight());



        //player
        /*g2.scale(0.3, -0.3);
        int aggiustamento=(player.getImage().getHeight(null));
        g2.drawImage(player.getImage(),player.getPosX()*3, -(player.getPosY()*3+aggiustamento), null);  */
    }


}

