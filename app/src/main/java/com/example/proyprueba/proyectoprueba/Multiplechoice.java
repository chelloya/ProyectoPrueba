package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

/**
 * Created by marcello.pisciottano on 24/4/2016.
 */
public class Multiplechoice extends Pregunta implements Serializable {

    private static final long serialVersionUID = 1L;

    private String resp1;
    private String resp2;
    private String resp3;
    private int respCorrectaMC;


    public Multiplechoice(int numero, String categoria, int puntaje,
                          String texto, String resp1, String resp2, String resp3,
                          int respCorrectaMC) {
        super(numero, categoria, puntaje, texto);
        this.resp1 = resp1;
        this.resp2 = resp2;
        this.resp3 = resp3;
        this.respCorrectaMC = respCorrectaMC;
    }


    public String getResp1() {
        return resp1;
    }


    public void setResp1(String resp1) {
        this.resp1 = resp1;
    }


    public String getResp2() {
        return resp2;
    }


    public void setResp2(String resp2) {
        this.resp2 = resp2;
    }


    public String getResp3() {
        return resp3;
    }


    public void setResp3(String resp3) {
        this.resp3 = resp3;
    }


    public int getRespCorrectaMC() {
        return respCorrectaMC;
    }


    public void setRespCorrectaMC(int respCorrectaMC) {
        this.respCorrectaMC = respCorrectaMC;
    }
}
