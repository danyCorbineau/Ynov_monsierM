package Eval;

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
    public void describe() {
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+", je prends "+itemSize+" places dans l'inventaire.\nVoici ma description : "+description);
    }

}