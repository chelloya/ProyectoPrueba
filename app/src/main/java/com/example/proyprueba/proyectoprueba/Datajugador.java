package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Datajugador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nickname;
	private String pasword;
	private int puntaje;
	
	public Datajugador(String nickname, String pasword, int puntaje) {
		super();
		this.nickname = nickname;
		this.pasword = pasword;
		this.puntaje = puntaje;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPasword() {
		return pasword;
	}
	public int getPuntaje() {
		return puntaje;
	}

public String toString(){
		
		String aux = "Nombre: " + getNickname();
		aux = aux + "\nPassword: " + getPasword();
		aux = aux + "\nPuntaje: " + getPuntaje();		
		return aux;
	}
}
