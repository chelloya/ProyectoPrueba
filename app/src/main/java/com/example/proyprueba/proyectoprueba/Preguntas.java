package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Random;

public class Preguntas extends Diccionario<Integer,Pregunta>implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public Datapregunta buscarPreguntaRandom(){
		
		Random randomGenerator = new Random();
		int randomInt = (randomGenerator.nextInt(numeroElementos()) +1);
		Pregunta aVO = find(randomInt);

		if (aVO.esDatatof())
		{
			Datatof aux2 = aVO.ADatatof();
			return aux2;
		}
		else
		{
			Datamc aux2 = aVO.ADatamc();
			return aux2;
		}
		
		
	}
	
	public Colecciondatapregunta listarTodas(){
		
		Iterator<Pregunta> iterPreg = darIterador();
		Colecciondatapregunta salida = new Colecciondatapregunta();
		
		while (iterPreg.hasNext())
		{
			Pregunta aux = iterPreg.next();
			
			Datapregunta aux2 = aux.ADataPregunta();
			salida.insert(aux2);
		}
		
		return salida;
	}
	
	
	public Datapregunta listarPregunta(int id){
		
		return find(id).ADataPregunta();		
	}
}
