package com.ynov.p1;

/*
 * J�r�my NUNES
 * Cette classe est li�e � la m�thode de la classe "Personnage" : prendreDegats
 * Affiche en console la mort du personnage lorsque ses points de vie tombent � 0.
 */
public class mortPersonnageException extends Exception {
	
	public mortPersonnageException(){
		super("Vous �tes mort.");
	}

}
