package p;

/*
 * Jérémy NUNES
 * Cette classe est liée à la méthode de la classe "Personnage" : prendreDegats
 * Affiche en console la mort du personnage lorsque ses points de vie tombent à 0.
 */
public class MortPersonnageException extends Exception {
	
	public MortPersonnageException(){
		super("Vous êtes mort.");
	}

}
