package com.example.proyprueba.proyectoprueba;

//import java.rmi.Remote;
//import java.rmi.RemoteException;
// nada cambio
import Excepciones.LogicaException;
import Excepciones.PersistenciaException;

public interface iFachada /*extends Remote*/{
	
	public void setPreguntas(Preguntas preg)/*throws RemoteException*/;
	public void setJugadores(Jugadores juga) /*throws RemoteException*/;
	public void altaPregunta (Datapregunta dp)  throws /*RemoteException,*/LogicaException;
	public Colecciondatapregunta listarPreguntas() /*throws RemoteException*/;
	public Datapregunta listadoDetalladoDeUnaPregunta (Integer di)  throws /*RemoteException,*/LogicaException;
	public void altaJugador(Dataconsjugador dcj)  throws /*RemoteException,*/LogicaException;
	public Colecciondatajugador listarJugadores () /*throws RemoteException*/;
//	public void respaldoDeDatos()  /*throws RemoteException,PersistenciaException*/;
	public void login(Dataconsjugador dcj) throws /*RemoteException,*/LogicaException;
	public Datapregunta solicitarPregunta(Dataconsjugador dcj)  throws /*RemoteException,*/LogicaException;
	public void respondoPregunta(Datajugadorintrespuesta djir)  throws /*RemoteException,*/LogicaException;
	public void logout (Dataconsjugador dcj) throws /*RemoteException,*/LogicaException;
	public Colecciondatajugadorhighscore listarRanking () /*throws RemoteException*/;
	public Colecciondatarespuesta listarRespuestasJugador (String nick) throws /*RemoteException,*/LogicaException;
	public Integer respuestaAPregunta (int i) throws /*RemoteException,*/LogicaException;
	public void inicializarJugadores () /*throws RemoteException*/;
}
