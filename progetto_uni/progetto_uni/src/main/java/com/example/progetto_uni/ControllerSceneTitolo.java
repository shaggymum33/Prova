package com.example.progetto_uni;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.media.MediaView;

import java.io.IOException;



public class ControllerSceneTitolo{
    Scene sceneTitolo;

    private DoubleProperty cambioScena = new SimpleDoubleProperty(0);

    //per ora c'è solo quel metodo che viene impostato sul file FXML da scene builder

    @FXML
    public void newGameStart() throws IOException {


        MediaView temp2 = (MediaView) sceneTitolo.getRoot().getChildrenUnmodifiable().get(1); //modo per stoppare l'audio
        temp2.getMediaPlayer().stop();
        cambioScena.set(1);


    }
    public void start() throws IOException {
        Servizio servizio= new Servizio();
        sceneTitolo = servizio.creaScena("ScenaTitolo.fxml",
                "C:\\Users\\samue\\Downloads\\progetto_uni\\progetto_uni\\video1.mp4",
                "C:\\Users\\samue\\Downloads\\progetto_uni\\progetto_uni\\AudioTitolo.mp3", this, null);
    }


    public DoubleProperty cambioScenaProperty() {
        return cambioScena;
    }

    public Scene getSceneTitolo() {
        return sceneTitolo;
    }
}
