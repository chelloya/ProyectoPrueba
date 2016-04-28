package Excepciones;


public class LogicaException extends Exception{
	

	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public LogicaException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	
	public String darMensaje()
	{
		return mensaje;
	}

	
	
	
	
	
}