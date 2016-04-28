package com.example.proyprueba.proyectoprueba;


//import java.rmi.RemoteException;
//import java.rmi.server.UnicastRemoteObject;

import Excepciones.LogicaException;
import Excepciones.PersistenciaException;
//import Persistencia.Archivos;

public class Fachada /*extends UnicastRemoteObject*/ implements iFachada{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Preguntas pregs;
	private Jugadores viciosos;
	private static Fachada instancia;
	private MonitorJugadores monitorJug; 
	private MonitorPreguntas monitorPreg;
	
	//singleton
	public static synchronized Fachada getInstancia() /*throws RemoteException*/{
		if(instancia==null)
		{
			instancia=new Fachada();			
		}
		return instancia;		
	}
	
	private Fachada() /*throws RemoteException*/{
		this.pregs = new Preguntas();
		this.viciosos = new Jugadores();
		this.monitorJug = new MonitorJugadores();
		this.monitorPreg = new MonitorPreguntas();
		
	}
	
	
	public void setPreguntas(Preguntas preg)
	{
		this.pregs = preg;
	}
	
	public void setJugadores(Jugadores juga)
	{
		this.viciosos=juga;
	}
	
	
	public void  altaPregunta (Datapregunta dp) throws LogicaException{
		monitorPreg.comenzarEscritura();
		int valor = dp.getPuntaje();
		
		if (valor <= 0)
		{
			String msg = "Error el puntaje debe mayor a cero.";
			monitorPreg.finalizarEscritura();
			throw new LogicaException(msg);
		}
		else
		{	
			int numPreg = pregs.numeroElementos()+1;
			if (dp instanceof Datatof)
			{
				Trueorfalse tof = new Trueorfalse(numPreg, dp.getCategoria(), dp.getPuntaje(), dp.getTexto(), ((Datatof) dp).isRespCorrectaTF());
				pregs.insert(tof.getNumero(), tof);
			}
			else
			{
				Multiplechoice mc = new Multiplechoice(numPreg, dp.getCategoria(), dp.getPuntaje(), dp.getTexto(),((Datamc) dp).getResp1(),((Datamc) dp).getResp2(),((Datamc) dp).getResp3(), ((Datamc) dp).getRespCorrectaMC());
				
				if (mc.getRespCorrectaMC() < 1 || 3 < mc.getRespCorrectaMC())
				{
					String msg = "Error, la respuesta corecta debe ser 1, 2 o 3.";
					monitorPreg.finalizarEscritura();
					throw new LogicaException(msg);
				}
				else
				{
					
					pregs.insert(mc.getNumero(), mc);
				}
			}			
			/*, tipoError&   sin error*/
		}
		monitorPreg.finalizarEscritura();		
	};
	
	public Colecciondatapregunta listarPreguntas(){
		monitorPreg.comenzarLectura();
		Colecciondatapregunta a = pregs.listarTodas();
		monitorPreg.finalizarLectura();
		return a;
	}
	
	public Datapregunta listadoDetalladoDeUnaPregunta (Integer di) throws LogicaException{
		monitorPreg.comenzarLectura();
		if(pregs.member(di))
		{
			monitorPreg.finalizarLectura();
			return pregs.listarPregunta(di);
		}
		else
		{
			String msg = "No hay una pregunta con ese numero.";
			monitorPreg.finalizarLectura();
			throw new LogicaException(msg);			
		}
	};
	
	public void altaJugador(Dataconsjugador dcj) throws LogicaException{
		monitorJug.comenzarEscritura();
		if (viciosos.member(dcj.getNickname()))
		{
			String msg = "Error el jugador ya existe.";
			monitorJug.finalizarEscritura();
			throw new LogicaException(msg);
		}
		else
		{
			Jugador aIngresar = new Jugador(dcj.getNickname(), dcj.getPasword());
			viciosos.insert(aIngresar.getNickname(), aIngresar);
			monitorJug.finalizarEscritura();
			/*, tipoError&  sin error*/
		}
	};
	
	public Colecciondatajugador listarJugadores (){
		monitorJug.comenzarLectura();
		Colecciondatajugador a = viciosos.listarTodos();
		monitorJug.finalizarLectura();
		return a;
	}
	/*
	public void respaldoDeDatos() throws PersistenciaException {                  ////////////////////////////// CONTROLAR ANTES DE GUARDAR SI LOS JUGADORES ESTAN JUGANDO O ESAS COSAS
		monitorJug.comenzarLectura();
		monitorPreg.comenzarLectura();
		Archivos guardar = new Archivos();
		Jugadoresypreguntas aux = new Jugadoresypreguntas(viciosos, pregs);		
		try 
		{
			guardar.respaldar("respaldo",aux);
		} catch (PersistenciaException e)
		{
			String msg = "Error al guardar";
			monitorJug.finalizarLectura();
			monitorPreg.finalizarLectura();
			throw new PersistenciaException(msg);
		}
		monitorJug.finalizarLectura();
		monitorPreg.finalizarLectura();
	}
	*/
	public void login(Dataconsjugador dcj)throws LogicaException{
		monitorJug.comenzarEscritura();
		if (!viciosos.member(dcj.getNickname()))
		{
			String msg = "Error, Usuario o codigo de acceso incorrectos.";
			monitorJug.finalizarEscritura();
			throw new LogicaException(msg);
		}
		else
		{
			Jugador aux = viciosos.find(dcj.getNickname());
			if (!dcj.getPasword().equals(aux.getPassword()))
			{
				String msg = "Error, Usuario o codigo de acceso incorrectos.";
				monitorJug.finalizarEscritura();
				throw new LogicaException(msg);
			}
			else
			{
				if(aux.isLogueado())
				{
					String msg = "Error el jugador ya esta logueado.";
					monitorJug.finalizarEscritura();
					throw new LogicaException(msg);
				}
				else
				{
					aux.setLogueado(true);
					/*, tipoError& sin error*/
				}
			}
		}
		monitorJug.finalizarEscritura();
	};
	
	public Datapregunta solicitarPregunta(Dataconsjugador dcj) throws LogicaException{
		monitorJug.comenzarEscritura();
		monitorPreg.comenzarLectura();
		
		if (!viciosos.member(dcj.getNickname()))
		{
			String msg = "Error, Usuario o codigo de acceso incorrectos.";
			monitorJug.finalizarEscritura();
			monitorPreg.finalizarLectura();
			throw new LogicaException(msg);
		}
		else
		{
			Jugador aux = viciosos.find(dcj.getNickname());
			if (!dcj.getPasword().equals(aux.getPassword()))
			{
				String msg = "Error, Usuario o codigo de acceso incorrectos.";
				monitorJug.finalizarEscritura();
				monitorPreg.finalizarLectura();
				throw new LogicaException(msg);
			}
			else
			{
				if(!aux.isLogueado())
				{
					String msg = "Error el jugador no esta logueado.";
					monitorJug.finalizarEscritura();
					monitorPreg.finalizarLectura();
					throw new LogicaException(msg);
				}
				else
				{
					if (aux.estaContestando())
					{
						String msg = "Error, el jugador ya esta contestando una pregunta.";
						monitorJug.finalizarEscritura();
						monitorPreg.finalizarLectura();
						throw new LogicaException(msg);
					}
					else
					{
						if (!quedanPreguntasPorResponder(aux.getNickname()))
						{
							String msg = "Error, Todas las pregutnas han sido contestadas, espere nuevas preguntas.";
							monitorJug.finalizarEscritura();
							monitorPreg.finalizarLectura();
							throw new LogicaException(msg);
						}
						else
						{
							Datapregunta dp = pregs.buscarPreguntaRandom();
							
							if (aux.getRespuestas().member(dp.getNumero()))
							{
								int numpreg = dp.getNumero();
								while ((aux.getRespuestas().member(dp.getNumero())) && (dp.getNumero()!=pregs.numeroElementos()))
								{
									numpreg = numpreg +1;
									
									Pregunta aVO = pregs.find(numpreg);
									
									if (aVO instanceof Trueorfalse)
									{
										Datatof salida = new Datatof(aVO.getNumero(), aVO.getCategoria(), aVO.getPuntaje(), aVO.getTexto(), ((Trueorfalse) aVO).isRespCorrectaTF());
										dp = salida;
									}
									else
									{
										Datamc salida = new Datamc(aVO.getNumero(), aVO.getCategoria(), aVO.getPuntaje(), aVO.getTexto(), ((Multiplechoice) aVO).getResp1(),((Multiplechoice) aVO).getResp2(),((Multiplechoice) aVO).getResp3(),((Multiplechoice) aVO).getRespCorrectaMC());
										dp = salida;
									}
											
									////////////////////////////////////////////////////////
								}
								
								
								if (aux.getRespuestas().member(dp.getNumero()))
								{
									numpreg = 0;
									
									do
									{
										////////////////////////////////////////////////////////
										numpreg = numpreg +1;
										
										Pregunta aVO = pregs.find(numpreg);
										
										if (aVO instanceof Trueorfalse)
										{
											Datatof salida = new Datatof(aVO.getNumero(), aVO.getCategoria(), aVO.getPuntaje(), aVO.getTexto(), ((Trueorfalse) aVO).isRespCorrectaTF());
											dp = salida;
										}
										else
										{
											Datamc salida = new Datamc(aVO.getNumero(), aVO.getCategoria(), aVO.getPuntaje(), aVO.getTexto(), ((Multiplechoice) aVO).getResp1(),((Multiplechoice) aVO).getResp2(),((Multiplechoice) aVO).getResp3(),((Multiplechoice) aVO).getRespCorrectaMC());
											dp = salida;
										}
												
										////////////////////////////////////////////////////////
									}
									while (aux.getRespuestas().member(dp.getNumero()));
									
								}
								
								inicializarPregunta(dcj,dp);
								monitorJug.finalizarEscritura();
								monitorPreg.finalizarLectura();
								return dp;
								/*, tipoError& sin error salida en dp*/ 
							}
							else
							{
								inicializarPregunta(dcj,dp);
								monitorJug.finalizarEscritura();
								monitorPreg.finalizarLectura();
								return dp;
								/*, tipoError& sin error salida en dp*/
							}
						}
					}
				}
			}
		}
	};
	
	public void respondoPregunta(Datajugadorintrespuesta djir) throws LogicaException{
		monitorJug.comenzarEscritura();
		monitorPreg.comenzarLectura();
		
		
		Datajugadorint dji = djir.getDji();
		DataRespuestaIn dri = djir.getDri();
		
		if (!viciosos.member(dji.getNickname()))
		{
			String msg = "Error, Usuario o codigo de acceso incorrectos.";
			monitorJug.finalizarEscritura();
			monitorPreg.finalizarLectura();
			throw new LogicaException(msg);
		}
		else
		{
			Jugador aux = viciosos.find(dji.getNickname());
			if (!dji.getPasword().equals(aux.getPassword()))
			{
				String msg = "Error, Usuario o codigo de acceso incorrectos.";
				monitorJug.finalizarEscritura();
				monitorPreg.finalizarLectura();
				throw new LogicaException(msg);
			}
			else
			{
				if(!aux.isLogueado())
				{
					String msg = "Error el jugador no esta logueado.";
					monitorJug.finalizarEscritura();
					monitorPreg.finalizarLectura();
					throw new LogicaException(msg);
				}
				else
				{
					if (!aux.estaContestando())
					{
						String msg = "Error, el jugador no esta contestando ninguna pregunta.";
						monitorJug.finalizarEscritura();
						monitorPreg.finalizarLectura();
						throw new LogicaException(msg);
					}
					else
					{
						if (dji.getNumPreg()!= viciosos.find(dji.getNickname()).cualEstaContestando()  /*dr.getPreg().getNumero()*/)
						{
							String msg = "Error, el jugador esta contestando otra pregunta.";
							monitorJug.finalizarEscritura();
							monitorPreg.finalizarLectura();
							throw new LogicaException(msg);
						}
						else
						{
							if(dri.getTiempoSobrante()<0 || 10 < dri.getTiempoSobrante())
							{
								String msg = "Error, el tiempo restante debe ser de 0 a 10.";
								monitorJug.finalizarEscritura();
								monitorPreg.finalizarLectura();
								throw new LogicaException(msg);
							}
							else
							{
								completarRespuesta(dji, dri);
								/*, tipoError& sin error*/
							}
							
						}
					}
				}
			}
		}
		monitorJug.finalizarEscritura();
		monitorPreg.finalizarLectura();
	};
	
	public void logout (Dataconsjugador dcj)throws LogicaException{
	
		monitorJug.comenzarEscritura();
			
		if (!viciosos.member(dcj.getNickname()))
		{
			String msg = "Error, Usuario o codigo de acceso incorrectos."; 
			monitorJug.finalizarEscritura();
			throw new LogicaException(msg);
		}
		else
		{
			Jugador aux = viciosos.find(dcj.getNickname());
			if (!dcj.getPasword().equals(aux.getPassword()))
			{
				String msg = "Error, Usuario o codigo de acceso incorrectos."; 
				monitorJug.finalizarEscritura();
				throw new LogicaException(msg);
			}
			else
			{
				if(!aux.isLogueado())
				{
					String msg = "Error el jugador no esta logueado."; 
					monitorJug.finalizarEscritura();
					throw new LogicaException(msg);
				}
				else
				{
					if (aux.estaContestando())
					{
						String msg = "Error, el jugador esta contestando una pregunta."; 
						monitorJug.finalizarEscritura();
						throw new LogicaException(msg);
					}
					else
					{
						aux.setLogueado(false);
					}
				}
			}
		}
		monitorJug.finalizarEscritura();
	};
	
	public Colecciondatajugadorhighscore listarRanking (){
		monitorJug.comenzarLectura();
		Colecciondatajugadorhighscore aux = viciosos.ranking();
		monitorJug.finalizarLectura();
		return aux;
	}
	
	public Colecciondatarespuesta listarRespuestasJugador (String nick)throws LogicaException{
		
		
		monitorJug.comenzarLectura();
		monitorPreg.comenzarLectura();
		if (!viciosos.member(nick))
		{
			String msg = "Error el jugador no existe.";
			monitorJug.finalizarLectura();
			monitorPreg.finalizarLectura();
			throw new LogicaException(msg);
		}
		else
		{
			monitorJug.finalizarLectura();
			monitorPreg.finalizarLectura();
			return viciosos.listarRespuestasJugador(nick);
			/* sin error*/
		}
	}
	
	private boolean quedanPreguntasPorResponder(String nick){
		
		boolean quedan = false;
		if (!pregs.esVacio())
		{
			boolean hayRespuestas;
			Jugador aux = viciosos.find(nick);
			Respuestas aux2 = new Respuestas(); 
			aux2 = aux.getRespuestas();
			hayRespuestas = aux2.esVacio();
			
			if (hayRespuestas)
			{
				quedan = true;
			}
			else
			{
				quedan = (boolean)(pregs.numeroElementos()!=viciosos.find(nick).getRespuestas().numeroElementos());
			}
		}
		
		
		return quedan;
	}
	
	private void inicializarPregunta (Dataconsjugador dcj, Datapregunta dp){ 
		
		Respuesta resp = new Respuesta(pregs.find(dp.getNumero()));
		viciosos.find(dcj.getNickname()).getRespuestas().insert(dp.getNumero(),resp);
	}
	
	private void completarRespuesta (Datajugadorint dji, DataRespuestaIn dri){
		
		
		Jugador aux =viciosos.find(dji.getNickname()); 
		Respuesta auxResp = aux.getRespuestas().find(dji.getNumPreg());
		auxResp.setContestoBien(dri.isContestoBien());
		auxResp.setTiempoSobrante(dri.getTiempoSobrante());
		
		int puntos = calcularPuntaje (dji,dri); // calcular puntaje obtenido
		auxResp.setPuntajeObtenido(puntos);
		
		// sumar el puntaje resultante
		aux.setPuntaje( aux.getPuntaje() + puntos);
		
	}
	
	private int calcularPuntaje (Datajugadorint dji, DataRespuestaIn dri){
		int puntosObtenidos = 0;
		int numPreg = dji.getNumPreg();
		int puntajePreg = pregs.find(numPreg).getPuntaje();
		if (dri.getTiempoSobrante()==0)
		{
			puntosObtenidos = (puntajePreg * (-5));
		}
		else
		{
			if (dri.isContestoBien())
			{
				puntosObtenidos = (puntajePreg * dri.getTiempoSobrante());
			}
			else
			{
				puntosObtenidos = (puntajePreg * (-10));
			}
		}
		return puntosObtenidos;
	}
	
	public void inicializarJugadores () /*throws RemoteException*/{
		
		viciosos.inicializar();
		
	}
	
	public Integer respuestaAPregunta (int i) throws LogicaException{
		
		if (pregs.member(i))
		{
			Pregunta aux = pregs.find(i);
			
			if (aux instanceof Trueorfalse)
			{
				if(((Trueorfalse)aux).isRespCorrectaTF())
				{
					return 4;
				}
				else
				{
					return 5;
				}
			}
			else
			{
				return ((Multiplechoice)aux).getRespCorrectaMC();
			}
		}
		else
		{
			String msg = "Error, no existe pregunta con ese numero.";
			throw new LogicaException(msg);
		}
		
	}
	
}