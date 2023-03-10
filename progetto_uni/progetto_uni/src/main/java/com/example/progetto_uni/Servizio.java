package com.example.progetto_uni;

import javafx.embed.swing.SwingNode;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Servizio {
    public Scene creaScena(String fileFxml, String video, String music, Object o, ModelLivello modelLivello) throws IOException {

        /*
        File file = new File(video);
        MediaView mediaViewVideo = new MediaView(new MediaPlayer(new Media(file.toURI().toString())));
        mediaViewVideo.setFitWidth(1280);
        mediaViewVideo.setFitHeight(800); //impostazione video
        mediaViewVideo.getMediaPlayer().setMute(true);
        mediaViewVideo.getMediaPlayer().setCycleCount(10);
        mediaViewVideo.getMediaPlayer().play();
        */
        MediaPlayer audio = new MediaPlayer(new Media(new File(music).toURI().toString()));
        MediaView mediaViewAudio = new MediaView(audio); //impostazione audio
        audio.setCycleCount(10);
        audio.play();


        FXMLLoader schermata = new FXMLLoader(getClass().getResource(fileFxml));
        schermata.setController(o); //creazione file FXML e settaggio controller
        Parent root = schermata.load();

        Group root2 = new Group(mediaViewAudio, root);




        SwingNode swingNode= new SwingNode();
        JPanel gameView= new GameView(modelLivello);
        swingNode.setContent( gameView);
        Group root3= new Group();
        root3.getChildren().add(swingNode);
        Scene scene = new Scene(root3,1280,800);
        return scene;
    }
}
