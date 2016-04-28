package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;
import java.util.Iterator;


public class Jugadores extends Diccionario<String,Jugador> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	
public Colecciondatajugador listarTodos(){
		
		Iterator<Jugador> iterJug = darIterador();
		Colecciondatajugador salida = new Colecciondatajugador();
		
		while (iterJug.hasNext())
		{
			Jugador aux = iterJug.next();
			
			Datajugador aux2 = aux.ADataJugador();
			salida.insert(aux2);
		}
		
		return salida;
	}

public Colecciondatarespuesta listarRespuestasJugador (String nick){
	
	return find(nick).listarRespuestas();
}

public Colecciondatajugadorhighscore ranking(){
	
	Iterator<Jugador> iterJug = darIterador();
	Colecciondatajugadorhighscore salida = new Colecciondatajugadorhighscore();
	
	Datajugadorhighscore [] alistar = new Datajugadorhighscore[this.numeroElementos()];
	int i=0;
	
	while (iterJug.hasNext())
	{
		Jugador aux = iterJug.next();
		Datajugadorhighscore aux2 = aux.ADataJugadorHighscore();
		alistar[i] = aux2;
		i++;
	}
	
	Datajugadorhighscore aux1;
	
	for (int k =0; k< this.numeroElementos()-1;k++)
	{
		for(int j=k+1;j<this.numeroElementos();j++)
		{
			if(alistar[k].getPuntaje()< alistar[j].getPuntaje())
			{
				
				aux1=alistar[k];
				alistar[k]=alistar[j];
				alistar[j]=aux1;
			}
		}
	}
	
	for(int m=0; m<this.numeroElementos();m++)
	{
		salida.insert(alistar[m]);
	}
	
	return salida;
}

public void inicializar (){
	
	Iterator<Jugador> iterJug = darIterador();
	
	while (iterJug.hasNext())
	{
		Jugador jug = iterJug.next();
		jug.setLogueado(false);
		jug.finalizarRespuestas();		
	}
}


}
