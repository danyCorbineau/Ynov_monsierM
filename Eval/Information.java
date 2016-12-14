package Eval;

//Par Malo Dupont
//

public class Information extends Objet {	
	
	//Constructeur pour definir un objet dont on peut seulement voir la description, pas d'interactions plus poussees avec lui
    public Information(String itemRoom, String name, String description) {
  		this.itemRoom = itemRoom;
  		this.name = name;
    	this.description = description;
    	}
    
    //voir dans Objet
    public void describe(){
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+".\nVoici ma description : "+description);
    }

}