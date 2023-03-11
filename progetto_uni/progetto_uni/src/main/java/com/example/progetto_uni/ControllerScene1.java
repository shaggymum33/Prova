package com.example.progetto_uni;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;


public class ControllerScene1 implements Initializable {
    //dove c'è scritto @FXML vuol dire che fa riferimento all'istanza della scena del file FXML
   //@FXML
    private ImageView img;

    private AnchorPane pane;
   /* @FXML
    private Polygon one ;
    @FXML
    private Polygon second;
    @FXML
    private Polygon terzo;*/
    private Scene scene;
    private DoubleProperty cambioScena = new SimpleDoubleProperty(1);
    private boolean condizioneImmagine = true; //boolean che serve per l'animazione, se sto facendo uno spostamento diventa false
    private final Image first = new Image("Player.png");
    private final Image secondD = new Image("Player2D.png");

    private final Image secondS= new Image("Player2S.png");

    private final Image third = new Image("Player3.png");
    private final Image imageBullet= new Image("DALL·E 2023-03-03 12.27.27 - 8 bit bullet like cuphead.png");
    public Keyboard keyboard;
    private ModelLivello modelLivello1;
    //Group virtualRoot = new Group();



    Timer mainTimer;

    TimerTask task = new TimerTask() {
        public void run() {
            directionCommands();
            modelLivello1.player.underGravity();
            modelLivello1.collisionDetection();
            modelLivello1.moveBullets();
            modelLivello1.player.cooldown();
            modelLivello1.enemy.move();
            //modelLivello1.enemy.fire(modelLivello1.player.getPosX(), modelLivello1.player.getPosY());
            modelLivello1.enemy.cooldown();
            modelLivello1.bulletCollisionDetenction();






        }
    };





    public ControllerScene1(ModelLivello model){
        this.modelLivello1=model;
        this.keyboard= new Keyboard(modelLivello1.player);
        mainTimer= new Timer();

    }


   /* public void timerAnimations(){//il timer thread per l'animazione
        Timer animazionePlayer = new Timer();
        animazionePlayer.schedule(new TimerTask() {
            public void run() {
                if(condizioneImmagine){
                    if (img.getImage().equals(first))
                        img.setImage(third);
                    else
                        img.setImage(first);
                }
               // Platform p = new Platform(40, 200);
               // ImageView img2 =new ImageView(third);
               // img2.setY(200);
               // img2.setX(200);
               /* scene.setRoot();
                for (Bullet b : modelLivello1.bullets) {
                    if (!b.imageAdedd){
                        scene.getRoot().getChildrenUnmodifiable().add(b.img);
                        b.imageAdedd=true;}

                   // b.img.translateXProperty().bind(b.posXProperty());
                    //b.img.translateYProperty().bind(b.posYProperty());
                    System.out.println("stampa bullet");

                }
            }
        },   1000,275);
    }*/


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        mainTimer.schedule(task, 0, 4);
       // timerAnimations();



    } //il metodo initialize si usa se fai l'implements di Initializable, parte solo la prima volta che viene caricata la scena ed è utile per settare alcuni thread


    public void start() throws IOException {
        Servizio servizio = new Servizio();
        scene = servizio.creaScena("Scene1.fxml","C:\\Users\\samue\\OneDrive\\Documents\\Prova\\progetto_uni\\progetto_uni\\video1.mp4","C:\\Users\\samue\\OneDrive\\Documents\\Prova\\progetto_uni\\progetto_uni\\Audio1.mp3",this, modelLivello1);

        scene.setOnKeyPressed(keyboard::keyPressed);
        scene.setOnKeyReleased(keyboard::keyReleased);

    }












    public void invertiCondizioneImmagine() {
        if(condizioneImmagine == false)
            condizioneImmagine = true;
        else
            condizioneImmagine = false;
    }//quando si fa per esempio una transizione si disattiva la condizione immagine


    public void setModelLivello1(ModelLivello modelLivello1) {
        this.modelLivello1 = modelLivello1;
    }


    public DoubleProperty cambioScenaProperty() {
        return cambioScena;
    }

    // start region gestione comandi
    public void directionCommands() {



        if( keyboard.keys[1] && !keyboard.keys[0]){
            commands(1);
            modelLivello1.player.setDirection(1);
        }

         if (keyboard.keys[0] && !keyboard.keys[1]) {
            commands(-1);
            modelLivello1.player.setDirection(-1);

        }
        if ((!keyboard.keys[0] && !keyboard.keys[1]) || (keyboard.keys[0] && keyboard.keys[1]))
            commands(0);

    }

    public void commands(int direction) {

        if (!(direction==0))
            modelLivello1.player.moveRight(direction);

        if (keyboard.keys[2])
            modelLivello1.player.jump(direction);

        if (keyboard.keys[3])
            modelLivello1.player.dash(direction);

        if (keyboard.keys[4]) {
            if (!modelLivello1.player.cooldownOn)
                modelLivello1.player.fire();
            modelLivello1.player.cooldownOn=true;
        }

    }



    public Scene getScene() {
        return scene;
    }
}

