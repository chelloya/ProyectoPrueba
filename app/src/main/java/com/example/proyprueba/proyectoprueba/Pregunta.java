package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

/**
 * Created by marcello.pisciottano on 24/4/2016.
 */

public abstract class Pregunta implements Serializable{

    private static final long serialVersionUID = 1L;
    private int numero;
    private String categoria;
    private int puntaje;
    private String texto;


    public Pregunta(int numero, String categoria, int puntaje, String texto) {
        super();

        this.numero = numero;
        this.categoria = categoria;
        this.puntaje = puntaje;
        this.texto = texto;
    }

    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public int getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
    public String getTexto() {
        return texto;
    }
    public void setTexto(String texto) {
        this.texto = texto;
    }


    public Datapregunta ADataPregunta(){

        if (this instanceof Trueorfalse)
        {
            Datatof salidaVO = new Datatof(getNumero(), getCategoria(), getPuntaje(), getTexto(), ((Trueorfalse) this).isRespCorrectaTF());
            return salidaVO;
        }
        else
        {
            Datamc salidaVO = new Datamc(getNumero(), getCategoria(), getPuntaje(), getTexto(), ((Multiplechoice) this).getResp1(),((Multiplechoice) this).getResp2(),((Multiplechoice) this).getResp3(),((Multiplechoice) this).getRespCorrectaMC());
            return salidaVO;
        }
    }

    public Datatof ADatatof()
    {
        Datatof salidaVO = new Datatof(getNumero(), getCategoria(), getPuntaje(), getTexto(), ((Trueorfalse) this).isRespCorrectaTF());
        return salidaVO;
    }

    public Datamc ADatamc(){
        Datamc salidaVO = new Datamc(getNumero(), getCategoria(), getPuntaje(), getTexto(), ((Multiplechoice) this).getResp1(),((Multiplechoice) this).getResp2(),((Multiplechoice) this).getResp3(),((Multiplechoice) this).getRespCorrectaMC());
        return salidaVO;
    }

    public boolean esDatatof(){

        boolean aux;

        if (this instanceof Trueorfalse)
        {
            aux = true;
        }
        else
        {
            aux = false;
        }

        return (aux);
    }
}
