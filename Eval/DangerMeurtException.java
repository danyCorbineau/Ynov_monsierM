package p;
/*
 * Dany CORBINEAU; dany.corbineau@ynov.com
 * Classe DangerMeurtException: A utiliser pour g�n�rer une exeption si un danger n'a plus de PV
 */

public class DangerMeurtException extends Exception{
	
	/**
	 * constructeur de l'exception
	 * @param d le danger qui n'a plus de pv
	 */
	DangerMeurtException(Danger d)
	{
		super("Danger "+d.getName());
	}

}
