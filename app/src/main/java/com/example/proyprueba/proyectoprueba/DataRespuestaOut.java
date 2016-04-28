package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class DataRespuestaOut implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private int tiempoSobrante;
	private int puntajeObtenido;
	private boolean contestoBien;
	private Pregunta preg;
	
	public DataRespuestaOut(int tiempoSobrante, int puntajeObtenido,
			boolean contestoBien, Pregunta preg) {
		super();
		this.tiempoSobrante = tiempoSobrante;
		this.puntajeObtenido = puntajeObtenido;
		this.contestoBien = contestoBien;
		this.preg = preg;
	}
	public int getTiempoSobrante() {
		return tiempoSobrante;
	}
	public int getPuntajeObtenido() {
		return puntajeObtenido;
	}
	public boolean isContestoBien() {
		return contestoBien;
	}
	public Pregunta getPreg() {
		return preg;
	}
	
public String toString(){
		
		Datapregunta auxDP = preg.ADataPregunta();
		String aux = "\n"+ auxDP.toString();
		aux = aux + "\nTiempo Sobrante: " + getTiempoSobrante();
		aux = aux + "\nPuntaje Obtenido: " + getPuntajeObtenido();
		if (isContestoBien())
		{
			aux = aux + "\nRespeusta: Correcta";
		}
		else
		{
			aux = aux + "\nRespeusta: Incorrecta";
		}
		
		
		return aux;
	}
	
}
