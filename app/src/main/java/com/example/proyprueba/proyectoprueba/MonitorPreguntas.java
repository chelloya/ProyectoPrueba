package com.example.proyprueba.proyectoprueba;

public class MonitorPreguntas {

	private int CantUsuariosLeyendo;
	private boolean writing;

	public MonitorPreguntas()
	{
		CantUsuariosLeyendo=0;
		writing=false;
	}

	public synchronized void comenzarLectura()
	{
		while(writing)
		{
			//System.out.println("Recurso en uso  - Escribiendo");
			try
			{
				wait();
			}catch (Exception e)
			{}
		}
		CantUsuariosLeyendo++;
	}

	public synchronized void finalizarLectura()
	{
		CantUsuariosLeyendo--;
		if(CantUsuariosLeyendo==0)
			notify();
	}

	public synchronized void comenzarEscritura()
	{
		while(writing || CantUsuariosLeyendo >0)
		{
			try{
				wait();
			}
			catch (Exception e)
			{

			}
		}
		writing = true;
	}

	public synchronized void finalizarEscritura()
	{
		writing = false;
		notify();
	}



	
}
