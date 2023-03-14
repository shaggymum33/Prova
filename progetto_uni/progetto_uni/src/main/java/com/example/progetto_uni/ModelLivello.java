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
            for(int i=0; i<25; i++)
                bullets.add(new Bullet(0, 0, 0, 10, false));
            for(int i=0; i<25; i++)
                Ebullets.add(new Bullet(0, 0, 0, 10, false));



        }

    public void collisionDetection() {

        onPlatform = false;

        for (Platform p : platforms) {
            player.aggiornaCollider();
            if (p.collider.intersects(player.collider) && (player.collider.getMinY() >= p.posY + 18)) {
                player.aggiornaYmin(p.posY + 19);
                onPlatform = true;
            }
        }
        if (!onPlatform) {
            player.aggiornaYmin(10);
        }

    }

        public void moveBullets() {
            for (Bullet b : bullets)
               if(b.isAlive)
                b.move();
          for (Bullet b: Ebullets)
              if (b.isAlive)
                  b.move();






        }


  public void bulletCollisionDetenction() {
        for (Bullet b : bullets)
            enemy.collisionDetection(b);
        for (Bullet b : Ebullets)
            player.collisionDetection(b);
    }
 public void addBullet(int posX, int posY, int direction, int damage, boolean isAlive){
     for (int i =0; i<bullets.size(); i++){
         if(!bullets.get(i).isAlive) {
             bullets.get(i).posY=posY;
            bullets.get(i).posX=posX;
            bullets.get(i).isAlive=isAlive;
             bullets.get(i).direction=direction*2;
             bullets.get(i).damage=damage;
         return;
         }
     }
 }
    public void addEBullet(int posX, int posY, int direction, int damage, boolean isAlive){
        for (int i =0; i<Ebullets.size(); i++){
            if(!Ebullets.get(i).isAlive) {
                Ebullets.get(i).posY=posY;
                Ebullets.get(i).posX=posX;
                Ebullets.get(i).isAlive=isAlive;
                Ebullets.get(i).direction=direction*2;
                Ebullets.get(i).damage=damage;
                return;
            }
        }

}
}
