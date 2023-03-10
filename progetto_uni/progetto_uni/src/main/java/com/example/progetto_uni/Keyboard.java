package com.example.progetto_uni;

import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Keyboard { //vado ad impostare tutte le transizioni


    private Player player;


    //invertire ordine utilizzare salto e dash come opzione non le direzioni--> non funziona dovrei scrivere ogni caso
//PROVARE a uitilizzare il vettore e poi scrivere tutte le combo
//diminuire il lag destra sinistra
    /*
     * 0 sinistra
     * 1 destra
     * 2 salto
     * 3 dash
     * 4 spara
     *
     */

        public boolean[] keys;
        public int num;

        private Player localPlayer;

        public Keyboard(Player p) {

            localPlayer = p;
            keys = new boolean[5];
            for (int i = 0; i < 4; i++)
                keys[i] = false;
            num = 10;
        }


        public void keyTyped(KeyEvent e) {

        }


        public void keyPressed(KeyEvent e) {

            if (e.getCode() == KeyCode.SPACE)
                /*
                 * if (keys[0]&&keys[1] || (!keys[0]&&!keys[1])) localPlayer.jump(0); else if
                 * (keys[0]) { localPlayer.jump(-5); localPlayer.direction=-1;} else {
                 * localPlayer.jump(5); localPlayer.direction=1;}
                 */
                keys[2] = true;

            if (e.getCode() == KeyCode.A)

                /*
                 * localPlayer.moveRight(-1); localPlayer.direction=-1;
                 */
                keys[0] = true;

            if (e.getCode() == KeyCode.S) {
                // localPlayer.moveRight(1);

                keys[1] = true;
            }

            if (e.getCode() == KeyCode.P)

                /*
                 * if (keys[0]&&keys[1] || (!keys[0]&&!keys[1])) localPlayer.dash(0); else if
                 * (keys[0]) localPlayer.dash(-1); else localPlayer.dash(1); break;
                 */
                keys[3] = true;

            if (e.getCode() == KeyCode.ENTER)
                // localPlayer.fire();

                keys[4] = true;

        }


        public void keyReleased(KeyEvent e) {

            if (e.getCode() == KeyCode.SPACE)
                keys[2] = false;

            if (e.getCode() == KeyCode.A)
                keys[0] = false;

            if (e.getCode() == KeyCode.S)

                keys[1] = false;

            if (e.getCode() == KeyCode.P)
                keys[3] = false;

            if (e.getCode() == KeyCode.ENTER)
                keys[4] = false;

        }


    }




