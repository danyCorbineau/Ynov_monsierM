package p;

import java.util.ArrayList;
import java.util.List;

/*
 * J�r�my NUNES
 * Cette classe g�re les objets poss�d�s par le personnage.
 */

public class Inventaire {

// Cr�e une liste d'objets	
    private List<Objet> objets;
    
    
    public Inventaire() {
    objets = new ArrayList <Objet>();	
    }
    
    
/*
 * Ajoute un objet � l'inventaire du personnage.
 */
	public boolean ajouterObjet(Objet objet) {
		return objets.add(objet);
	}
	

/*
 * Supprime un objet de l'inventaire du personnage.
 */
	public boolean supprimerObjet(Objet objet) {
		return objets.remove(objet);
	}
	

/*
 * Affiche la description d'un objet poss�d� par le personnage � partir du fichier "Objets.csv".
 * M�thode "describe" comprise dans la classe "Objet".
 */
	public void afficherObjet() {
		int j=1;
		System.out.println("--- 0: Ne rien faire");
		for(Objet anItem : objets) {
			System.out.println("--- "+j+": "+anItem.getAction()); 
			j++;
		}
		
	}
	 
}
