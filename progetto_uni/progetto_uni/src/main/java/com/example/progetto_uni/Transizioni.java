package com.example.progetto_uni;

import javafx.animation.Animation;
import javafx.animation.TranslateTransition;

import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class Transizioni {
    private TranslateTransition jumpTransition ;
    private TranslateTransition gravityTransition ;
    private TranslateTransition linearTransition ;
    private TranslateTransition downTransition ;


    //creazione delle varie transizioni con metodi utili
    public Transizioni(ImageView temp, double timeJump, double timeGravity, double timeLinear, double timeDown) {

        jumpTransition = new TranslateTransition(Duration.seconds(timeJump));
        jumpTransition.setNode(temp);

        gravityTransition = new TranslateTransition(Duration.seconds(timeGravity));
        gravityTransition.setNode(temp);

        linearTransition = new TranslateTransition(Duration.seconds(timeLinear));
        linearTransition.setNode(temp);

        downTransition = new TranslateTransition(Duration.seconds(timeDown));
        downTransition.setNode(temp);

        setCycle();

    }

    public TranslateTransition getJumpTransition() {
        return jumpTransition;
    }

    public TranslateTransition getGravityTransition() {
        return gravityTransition;
    }

    public TranslateTransition getLinearTransition() {
        return linearTransition;
    }

    public TranslateTransition getDownTransition() {
        return downTransition;
    }
    private void setCycle(){
        gravityTransition.setCycleCount(1);
        jumpTransition.setCycleCount(1);
        linearTransition.setCycleCount(1);
        downTransition.setCycleCount(1);
    }

    public void playJump(){
        jumpTransition.play();
    }
    public void playGravity(){
        gravityTransition.play();
    }
    public void playLinear(){
        linearTransition.play();
    }
    public void playDown(){
        downTransition.play();
    }
    public Animation.Status getJumpStatus(){
        return jumpTransition.getStatus();
    }
    public Animation.Status getGravityStatus(){
        return gravityTransition.getStatus();
    }
    public Animation.Status getLinearStatus(){
        return linearTransition.getStatus();
    }
    public Animation.Status getDownStatus(){
        return downTransition.getStatus();
    }
    public void stopJump(){jumpTransition.stop();}
    public void stopravity(){gravityTransition.stop();}
    public void stopLinear(){linearTransition.stop();}
    public void stopDown(){downTransition.stop();}
    public boolean ciSonoTransizioni(){
        boolean a = (linearTransition.getStatus() == Animation.Status.RUNNING);
        boolean b = (jumpTransition.getStatus() == Animation.Status.RUNNING);
        boolean c = (gravityTransition.getStatus() == Animation.Status.RUNNING);
        boolean d = (downTransition.getStatus() == Animation.Status.RUNNING);
        return a||b||c||d;
    }
}
