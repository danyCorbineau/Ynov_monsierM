package p;

/*
 * J�r�my NUNES
 * Cette classe est li�e � la m�thode de la classe "Personnage" : prendreDegats
 * Affiche en console la mort du personnage lorsque ses points de vie tombent � 0.
 */
public class MortPersonnageException extends Exception {
	
	public MortPersonnageException(){
		super("Vous �tes mort.");
	}

}
