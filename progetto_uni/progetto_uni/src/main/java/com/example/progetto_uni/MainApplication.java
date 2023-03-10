package com.example.progetto_uni;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class MainApplication extends Application {

    public void start(Stage stage) throws Exception {
        stage.setTitle("Cuphead");
        stage.getIcons().add(new Image("Logo.png"));
        stage.setResizable(false);
        stage.setMinWidth(1280);
        stage.setMinHeight(800);


        ControllerGenerale controllerGenerale = new ControllerGenerale(stage);

        ModelGenerale modelGenerale = new ModelGenerale();
        controllerGenerale.setModel(modelGenerale);

        controllerGenerale.start();

    }


    public static void main(String[] args)  {
      launch();
    }
}