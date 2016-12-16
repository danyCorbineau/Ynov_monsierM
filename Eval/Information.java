package p;

import java.util.List;

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
    public String getAction(){
    	return (name+"\n"+description+".");
    }

	@Override
	public String utliserObjet(Personnage p,Carte c,List<Objet> listObj) {
		return description;
	}

	

}