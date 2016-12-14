package com.ynov.p1;

/*
 * Jérémy NUNES
 * Cette classe est liée à la méthode de la classe "Personnage" : prendreDegats
 * Affiche en console la mort du personnage lorsque ses points de vie tombent à 0.
 */
public class mortPersonnageException extends Exception {
	
	public mortPersonnageException(){
		super("Vous êtes mort.");
	}

}
