package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Jugadoresypreguntas implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Jugadores ju;
	private Preguntas preg;
	
	
	public Jugadoresypreguntas(Jugadores ju, Preguntas preg) {
		super();
		this.ju = ju;
		this.preg = preg;
	}

	public Jugadores getJu() {
		return ju;
	}

	public void setJu(Jugadores ju) {
		this.ju = ju;
	}

	public Preguntas getPreg() {
		return preg;
	}

	public void setPreg(Preguntas preg) {
		this.preg = preg;
	}	
	
}
