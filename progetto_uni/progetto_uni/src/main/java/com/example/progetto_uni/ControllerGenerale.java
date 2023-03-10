package com.example.progetto_uni;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.stage.Stage;

import java.io.IOException;



public class ControllerGenerale{
    private ControllerSceneTitolo controllerSceneTitolo;
    private ControllerScene1 controller1;
    private Stage stage;
    private ModelGenerale modelGenerale;
    private DoubleProperty cambioScena = new SimpleDoubleProperty(0); // la property che sarà collegata attraverso al bind a quelle di ogni classe
    private Servizio servizio;
    public ControllerGenerale(Stage stage) throws IOException {
        //creo il controllerGenerale passando lo stage e generando i vari controller
        this.stage = stage;
        servizio = new Servizio();
        modelGenerale = new ModelGenerale();
        controllerSceneTitolo = new ControllerSceneTitolo();
        controller1 = new ControllerScene1( modelGenerale.getUno());

    }

    public void start() throws IOException {
        cambioScena.addListener((observable, oldValue, newValue) -> {//il listener della property, quando cambio valore mi entra nello switch
            try {
                switch (newValue.intValue()) {
                    case 1:
                        startScena1();
                        break;
                }
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        startScena1();
       stage.show();
    }
    public void startTitolo() throws IOException {

        cambioScena.bind(controllerSceneTitolo.cambioScenaProperty());
        controllerSceneTitolo.start();
        stage.setScene(controllerSceneTitolo.getSceneTitolo());


    }
    public void startScena1() throws IOException {

        controller1.start();
        stage.setScene(controller1.getScene());
    }

    public void setModel(ModelGenerale modelGenerale) {
        this.modelGenerale = modelGenerale;
    }
}



    /*public void timerGravity(){ vecchio uso della gravity come ti dicevo
        gravity = new Timer();
        gravity.schedule(new TimerTask() {
            public void run() {
                if(!player.isOnGround() && !(playerTransizioni.getJumpStatus() == Animation.Status.RUNNING)){
                    playerTransizioni.playGravity();
                }

            }
        },0,1);
    }



    }*/
