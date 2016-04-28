package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

/**
 * Created by marcello.pisciottano on 24/4/2016.
 */
public abstract class Datapregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    private int numero;
    private String categoria;
    private int puntaje;
    private String texto;


    public Datapregunta(int numero, String categoria, int puntaje,
                        String texto) {
        super();
        this.numero = numero;
        this.categoria = categoria;
        this.puntaje = puntaje;
        this.texto = texto;
    }


    public int getNumero() {
        return numero;
    }


    public String getCategoria() {
        return categoria;
    }


    public int getPuntaje() {
        return puntaje;
    }


    public String getTexto() {
        return texto;
    }
}
