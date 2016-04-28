package com.example.proyprueba.proyectoprueba;
import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeMap;


public abstract class Diccionario <K,T>implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private TreeMap <K,T> Arbol;
	
	public Diccionario ()
	{ 
		Arbol = new TreeMap <K,T>(); 
		}
	
	public boolean member (K clave)
	{ 
		return Arbol.containsKey(clave); 
		}
	
		
	
	public T find (K clave)
	{ 
		return Arbol.get(clave); 
		}
	public void insert (K clave, T objeto)
	{ 
		Arbol.put(clave,objeto); 
		}
	
	public void delete (K clave)
	{
		Arbol.remove(clave);
		}
	
	public boolean esVacio ()
	{
		return (Arbol.isEmpty());
	}
	
	public int numeroElementos(){
		
		return Arbol.size();
	}
	
	public Iterator<T> darIterador (){
		
		Iterator<T> iter = Arbol.values().iterator();
		return iter;
	}
	
	
}
