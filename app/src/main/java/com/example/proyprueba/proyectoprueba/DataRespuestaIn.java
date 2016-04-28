package com.example.proyprueba.proyectoprueba;
import java.io.Serializable;

public class DataRespuestaIn implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private int tiempoSobrante;
	private boolean contestoBien;
	
	public DataRespuestaIn(int tiempoSobrante,
			boolean contestoBien) {
		super();
		this.tiempoSobrante = tiempoSobrante;
		this.contestoBien = contestoBien;
	}
	public int getTiempoSobrante() {
		return tiempoSobrante;
	}
	public boolean isContestoBien() {
		return contestoBien;
	}
	
public String toString(){
		
		String aux = "Tiempo Sobrante: " + getTiempoSobrante();
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