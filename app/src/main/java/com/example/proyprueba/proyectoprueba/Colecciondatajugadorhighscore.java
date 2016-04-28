package com.example.proyprueba.proyectoprueba;


import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;


public class Colecciondatajugadorhighscore extends Lista <Datajugadorhighscore>implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	public LinkedList<Datajugadorhighscore> ordenar(){
		
	    LinkedList<Datajugadorhighscore> list = new LinkedList<Datajugadorhighscore>();

		
		Collections.sort(list , new Comparator<Datajugadorhighscore>() {
			@Override
			public int compare(Datajugadorhighscore o1, Datajugadorhighscore o2) {
				// TODO Auto-generated method stub
				return this.compare(o1, o2);
			}
	     });
		
		return list;
	}

}
