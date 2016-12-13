package Eval;

//Par Malo Dupont

public class Utilisable extends Objet {

    public Utilisable(String itemRoom, String name, String description, int itemSize) {
    	this.itemRoom = itemRoom;
    	this.name = name;
    	this.description = description;
    	this.itemSize = itemSize;
    }
   
    
    public void describe() {
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+", je prends "+itemSize+" places dans l'inventaire.\nVoici ma description : "+description);
    }

}