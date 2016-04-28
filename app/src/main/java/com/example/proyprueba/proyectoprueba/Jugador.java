package com.example.proyprueba.proyectoprueba;

import java.io.Serializable;
import java.util.Iterator;


public class Jugador implements Serializable {
	
	private static final long serialVersionUID = 1L;
	


	private String nickname;
	private String pasword;
	private int puntaje;
	private boolean logueado;
	private Respuestas respuestas;
	
	public Jugador(String nick, String pass){
		nickname=nick;
		pasword=pass;
		puntaje=0;
		logueado=false;
		respuestas = new Respuestas();
	}
	
	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return pasword;
	}

	public void setPassword(String pasword) {
		this.pasword = pasword;
	}

	public int getPuntaje() {
		return puntaje;
	}

	public void setPuntaje(int puntaje) {
		this.puntaje = puntaje;
	}

	public boolean isLogueado() {
		return logueado;
	}

	public void setLogueado(boolean logueado) {
		this.logueado = logueado;
	}

	public Respuestas getRespuestas() {
		return respuestas;
	}

	public void setRespuestas(Respuestas respuestas) {
		this.respuestas = respuestas;
	}
	
	public boolean estaContestando(){
		
		boolean contestando = false;
		
		if (respuestas!=null)
		{
			Iterator<Respuesta> deres = respuestas.darIterador();
			
			while (deres.hasNext() && !contestando)
			{ 
				Respuesta re = deres.next();
				contestando = (boolean) (re.getTiempoSobrante()==-1);
			}
		}

		return contestando;
	}
	
	public int cualEstaContestando(){
		int contador=-1;
		boolean contestando = false;
		Respuesta re=null;
		
		if (respuestas!=null)
		{
			Iterator<Respuesta> deres = respuestas.darIterador();
			
			while (deres.hasNext() && !contestando)
			{ 
				re = deres.next();
				contestando = (boolean) (re.getTiempoSobrante()==-1);
			}
		}
		if (contestando)
		{
			contador= re.getPreg().getNumero();
		}
		return contador;
	}
	
	public Datajugador ADataJugador(){
		
		Datajugador aux = new Datajugador(getNickname(), getPassword(),getPuntaje());
		
		return aux;
	}
	
public Datajugadorhighscore ADataJugadorHighscore(){
		
		Datajugadorhighscore aux = new Datajugadorhighscore(getNickname(), getPuntaje());
		
		return aux;
	}
	
	public Colecciondatarespuesta listarRespuestas (){
		
		return respuestas.listarTodasResp();
	}
	
	public void finalizarRespuestas(){
		
		Iterator<Respuesta> deres = respuestas.darIterador();
		
		while (deres.hasNext())
		{ 
			Respuesta re = deres.next();
			if(re.getTiempoSobrante()==-1) 
			{
				re.setPuntajeObtenido(re.getPreg().getPuntaje()*(-5));
				re.setTiempoSobrante(0);
			}	
		}
	}
	
}
