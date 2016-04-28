package Excepciones;


public class PresentacionException extends Exception{

	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public PresentacionException (String mensaje){
		this.mensaje = mensaje;
		
	}
	
	public String darMensaje()
	{
		return mensaje;
		
	}

}
