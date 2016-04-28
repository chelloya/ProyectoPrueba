package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Datos implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private Preguntas pregs;
	private Jugadores viciosos;
	
	public Datos(Preguntas pregs, Jugadores viciosos) {
		super();
		this.pregs = pregs;
		this.viciosos = viciosos;
	}
	
	public Preguntas getPregs() {
		return pregs;
	}
	public void setPregs(Preguntas pregs) {
		this.pregs = pregs;
	}
	public Jugadores getViciosos() {
		return viciosos;
	}
	public void setViciosos(Jugadores viciosos) {
		this.viciosos = viciosos;
	}
	
}
