package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;
import java.util.Iterator;

public class Respuestas extends Diccionario<Integer,Respuesta> implements Serializable {    /*     COMO RENOMBRAR UNA CLASE  */
	
	private static final long serialVersionUID = 1L;

	
	public Colecciondatarespuesta listarTodasResp(){
		
		Iterator<Respuesta> iterResp = darIterador();
		Colecciondatarespuesta salida = new Colecciondatarespuesta();
		
		while (iterResp.hasNext())
		{
			Respuesta aux = iterResp.next();
			
			DataRespuestaOut aux2 = aux.ADataRespuesta();
			salida.insert(aux2);
		}
		
		return salida;
	}
	
	
}
