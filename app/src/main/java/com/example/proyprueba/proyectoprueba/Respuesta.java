package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Respuesta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int tiempoSobrante;
	private int puntajeObtenido;
	private boolean contestoBien;
	private Pregunta preg;
	
	
	public Respuesta(Pregunta preg) {
		super();
		this.tiempoSobrante = -1;
		this.puntajeObtenido = 0;
		this.contestoBien = false;
		this.preg = preg;
	}


	public int getTiempoSobrante() {
		return tiempoSobrante;
	}


	public void setTiempoSobrante(int tiempoSobrante) {
		this.tiempoSobrante = tiempoSobrante;
	}


	public int getPuntajeObtenido() {
		return puntajeObtenido;
	}


	public void setPuntajeObtenido(int puntajeObtenido) {
		this.puntajeObtenido = puntajeObtenido;
	}


	public boolean isContestoBien() {
		return contestoBien;
	}


	public void setContestoBien(boolean contestoBien) {
		this.contestoBien = contestoBien;
	}


	public Pregunta getPreg() {
		return preg;
	}


	public void setPreg(Pregunta preg) {
		this.preg = preg;
	}
	
	public DataRespuestaOut ADataRespuesta() {
		
		DataRespuestaOut aux = new DataRespuestaOut(getTiempoSobrante(), getPuntajeObtenido(), isContestoBien(), getPreg());
		return aux;
	}
	
}
