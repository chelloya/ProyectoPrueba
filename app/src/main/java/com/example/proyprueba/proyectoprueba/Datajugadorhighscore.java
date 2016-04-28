package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;
import java.util.Comparator;

public class Datajugadorhighscore implements Comparator <Datajugadorhighscore>, Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nickname;
	private int puntaje;
	
	
	public Datajugadorhighscore(String nickname, int puntaje) {
		super();
		this.nickname = nickname;
		this.puntaje = puntaje;
	}
	public String getNickname() {
		return nickname;
	}
	public int getPuntaje() {
		return puntaje;
	}
	
	
	public int compare(Datajugadorhighscore o1,Datajugadorhighscore o2){
		
		return new Integer(o1.getPuntaje()).compareTo(o2.getPuntaje());
	};

	    
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Datajugadorhighscore other = (Datajugadorhighscore) obj;
		if (puntaje != other.puntaje)
			return false;
		return true;
	};
	
public String toString(){
		
		String aux = "Nombre: " + getNickname();
		aux = aux + "\nPuntaje: " + getPuntaje();		
		return aux;
	}
}
