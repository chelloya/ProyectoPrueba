package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

/**
 * Created by marcello.pisciottano on 24/4/2016.
 */
public class Trueorfalse extends Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean respCorrectaTF;

    public Trueorfalse(int numero, String categoria, int puntaje, String texto,
                       boolean respCorrectaTF) {
        super(numero, categoria, puntaje, texto);
        this.respCorrectaTF = respCorrectaTF;
    }

    public boolean isRespCorrectaTF() {
        return respCorrectaTF;
    }

    public void setRespCorrectaTF(boolean respCorrectaTF) {
        this.respCorrectaTF = respCorrectaTF;
    }

}
