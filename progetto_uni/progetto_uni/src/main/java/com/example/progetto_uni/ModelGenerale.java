package com.example.progetto_uni;

public class ModelGenerale {
    private ModelLivello uno;
    private ModelLivello due;
    private ModelLivello tre;

    public ModelGenerale() {
        uno = new ModelLivello();
        due =new ModelLivello();
        tre = new ModelLivello();
    }

    public ModelLivello getUno() {
        return uno;
    }

    public ModelLivello getDue() {
        return due;
    }

    public ModelLivello getTre() {
        return tre;
    }



}
