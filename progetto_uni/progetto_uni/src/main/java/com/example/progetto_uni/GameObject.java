package com.example.progetto_uni;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.shape.Rectangle;

public class GameObject {
    public ModelLivello gameWorld;

    //variabili di posizione
    private IntegerProperty posXProperty;
    private IntegerProperty posYProperty;
    private int posX;
    private int posY;
    //
    public Rectangle collider;
    public GameObject( ) {

        this.gameWorld= gameWorld;
        // double l = imagePlayer.getWidth() * 0.3;
        // double h = imagePlayer.getHeight() * 0.3;
        posX = 0;
        posY = 0;
        collider = new Rectangle(posX,posY,154,143);
        posXProperty = new SimpleIntegerProperty(posX);
        posYProperty = new SimpleIntegerProperty(posY);


    }

}
