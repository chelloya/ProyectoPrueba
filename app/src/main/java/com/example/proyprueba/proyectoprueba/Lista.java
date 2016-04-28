package com.example.proyprueba.proyectoprueba;
import java.io.Serializable;
import java.util.LinkedList;


public abstract class Lista <T> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private LinkedList <T> Ldppf;

	public Lista ()
	{ 
		Ldppf = new LinkedList <T>(); 
		}
	
	public boolean member (T objeto)
	{ 
		return Ldppf.contains(objeto); 
		}
	
	public void insert (T objeto)
	{ 
		Ldppf.add(objeto);
		}
	
	public void delete (T objeto)
	{
		Ldppf.remove(objeto);
		}
	
	public boolean esVacio ()
	{
		return Ldppf.isEmpty();
	}
	
	public T primero(){
		
		return Ldppf.getFirst();
	}
	
	public int largo(){
		
		return Ldppf.size();
	}
	
	public T objetoI(int i){
		return Ldppf.get(i);
	}
	

}


