package p;

import java.util.ArrayList;
import java.util.List;

/*
 * Jérémy NUNES
 * Cette classe gère les objets possédés par le personnage.
 */

public class Inventaire {

// Crée une liste d'objets	
    private List<Objet> objets;
    
    
    public Inventaire() {
    objets = new ArrayList <Objet>();	
    }
    
    
// Ajoute un objet à l'inventaire du personnage.
	public boolean ajouterObjet(Objet objet) {
		return objets.add(objet);
	}
	

// Supprime un objet de l'inventaire du personnage.
	public boolean supprimerObjet(Objet objet) {
		return objets.remove(objet);
	}
	

/*
 * Affiche la description d'un objet possédé par le personnage à partir du fichier "Objets.csv".
 * Méthode "describe" comprise dans la classe "Objet".
 */
	public void afficherObjet() {
		int j=1;
		Main.println(" >> 0: Ne rien faire");
		for(Objet anItem : objets) {
			Main.println(" >> "+j+": "+anItem.getAction()); 
			j++;
		}
	}
	
	
// Retourne la taille des objets pour composer la capacité de transport maximum du personnage.	
	public int getNbObjet()
	{
		return this.objets.size();
	}
	
	
// Permet d'utiliser les objets présents dans l'inventaire du personnage.	
	public void utiliserObj(int id, Personnage p, Carte c, List<Objet> lo)
	{
		((Utilisable)this.objets.get(id)).utiliserEffet(p);
		this.objets.remove(id);
	}
	
}
