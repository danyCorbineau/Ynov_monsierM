package p;

import java.util.List;

//Par Malo Dupont
//Classe pour les objets utilisables, que l'on peut mettre dans l'inventaire

public class Utilisable extends Objet {

	//Constructeur pour definir un objet avec lequel on peut interagir, stocker dans l'inventaire
    public Utilisable(String itemRoom, String name, String description, int itemSize) {
    	this.itemRoom = itemRoom;
    	this.name = name;
    	this.description = description;
    	this.itemSize = itemSize;
    }
   
    //voir dans Objet
    public String getAction() {
    	return (name+", "+itemSize+" places dans l'inventaire.\n"+description+".");
    }

	@Override
	public String utliserObjet(Personnage p, Carte c,List<Objet> listObj) {
		listObj.remove(this);
		p.addObjet(this);
		return null;
	}

    

}