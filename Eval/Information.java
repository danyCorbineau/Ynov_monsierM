package p;

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
    public void getAction(){
    	System.out.println(name+"\n"+description+".");
    }

	@Override
	void utliserObjet() {
		this.getAction();
	}

}