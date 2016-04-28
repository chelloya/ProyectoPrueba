package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;

public class Datajugadorintrespuesta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Datajugadorint dji; 
	private DataRespuestaIn dri;
	public Datajugadorintrespuesta(Datajugadorint dji, DataRespuestaIn dri) {
		super();
		this.dji = dji;
		this.dri = dri;
	}
	public Datajugadorint getDji() {
		return dji;
	}
	public DataRespuestaIn getDri() {
		return dri;
	}
	
	
}
