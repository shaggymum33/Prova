package com.example.progetto_uni;

import java.util.ArrayList;
import java.util.Timer;

public class ModelLivello
{
        Timer timer = new Timer();
        public ArrayList<Platform> platforms;
        public ArrayList<Bullet> bullets;
        public ArrayList<Bullet> Ebullets;

        public Enemy enemy;
        public Player player;
        private boolean onPlatform = false;

        boolean inCollider= false;



        public ModelLivello() {
            super();
            this.platforms = new ArrayList<>();
            this.bullets = new ArrayList<>();
            this.Ebullets=new ArrayList<>();
            platforms.add(new Platform(300, 150));
            platforms.add(new Platform(500, 150));
            platforms.add(new Platform(700, 250));
            platforms.add(new Platform(1100, 350));
            this.player = new Player(this);
            this.enemy = new Enemy(1000, 100, this);



        }

    public void collisionDetection() {// provare a rifare con eventi

        onPlatform = false;

        for (Platform p : platforms) {
            player.aggiornaCollider();
            if (p.collider.intersects(player.collider) && (player.collider.getMinY() >= p.posY + 18)) {
                // if (player.collider.getMinY() >= p.posY + 18)
                // questa condizione da parecchi problemi
                player.aggiornaYmin(p.posY + 19);
                onPlatform = true;
            }
        }
        if (!onPlatform) {
            // inCollider=false; // serve ancora
            player.aggiornaYmin(10);
        }

    }

        public void moveBullets() {
            /*for (Bullet b : bullets)
               if(b.isAlive)
                b.move();
            //else bullets.remove(b);*/
           for (int i =0; i<bullets.size(); i++){
                if(bullets.get(i).isAlive)
                   bullets.get(i).move();
               else bullets.remove(i);
           }
            for(Bullet b: Ebullets)
                if(b.isAlive)
                    b.move();
               // else Ebullets.remove(b);
        }


  public void bulletCollisionDetenction() {
        for (Bullet b : bullets)
            enemy.collisionDetection(b);
        for (Bullet b : Ebullets)
            player.collisionDetection(b);
    }
 public void addBullet(Bullet b){

 }

}
