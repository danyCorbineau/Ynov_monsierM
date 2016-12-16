package p;
/*
 * Dany CORBINEAU; dany.corbineau@ynov.com
 * Classe DangerMeurtException: A utiliser pour générer une exeption si un danger n'a plus de PV
 */

public class DangerMeurtException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * constructeur de l'exception
	 * @param d le danger qui n'a plus de pv
	 */
	DangerMeurtException(Danger d)
	{
		super("Danger "+d.getName());
	}

}
