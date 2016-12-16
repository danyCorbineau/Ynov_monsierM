package p;

import java.util.List;

//Par Malo Dupont
//Classe pour les objets utilisables, que l'on peut mettre dans l'inventaire

public class Utilisable extends Objet {
	int pvAjout=0;

	//Constructeur pour definir un objet avec lequel on peut interagir, stocker dans l'inventaire
    public Utilisable(String itemPiece, String name, String description, int itemTaille,String pvAjout) {
    	this.itemPiece = itemPiece;
    	this.name = name;
    	this.description = description;
    	this.itemTaille = itemTaille;
    	this.pvAjout=Integer.valueOf(pvAjout);
    }
   
    //voir dans Objet
    public String getAction() {
    	return (name+", "+itemTaille+" places dans l'inventaire.\n"+description+".");
    }
    
    
    public void utiliserEffet(Personnage p)
    {
    	p.ajoutPv(pvAjout);
    }

    /**
     * Méthode qui met dans l'inventaire un objet utilisable
     */
	@Override
	public String utliserObjet(Personnage p, Carte c,List<Objet> listObj) {
		System.out.println("\n--> Vous placer dans l'inventaire "+this.getName()+" !");
		listObj.remove(this);
		p.addObjet(this);
		return null;
	}

}