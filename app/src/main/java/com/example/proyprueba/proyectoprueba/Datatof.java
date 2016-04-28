package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

/**
 * Created by marcello.pisciottano on 24/4/2016.
 */
public class Datatof extends Datapregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean respCorrectaTF;

    public Datatof(int numero, String categoria, int puntaje,
                   String texto, boolean respCorrectaTF) {
        super(numero, categoria, puntaje, texto);
        this.respCorrectaTF = respCorrectaTF;
    }

    public boolean isRespCorrectaTF() {
        return respCorrectaTF;
    }

    public String toString(){

        String aux = "Numero de pregunta: " + getNumero();
        aux = aux + "\nCategoria: " + getCategoria();
        aux = aux + "\nPuntaje: " + getPuntaje();
        aux = aux + "\nTexto: " +getTexto();
        if (isRespCorrectaTF())
        {
            aux = aux + "\nRespeusta Corecta: VERDADERO";
        }
        else
        {
            aux = aux + "\nRespeusta Corecta: FALSO";
        }

        return aux;
    }
}
