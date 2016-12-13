package Eval;

//Par Malo Dupont

public class Information extends Objet {	
	
	
    public Information(String itemRoom, String name, String description) {
  		this.itemRoom = itemRoom;
  		this.name = name;
    	this.description = description;
    	}
    
    public void describe(){
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+".\nVoici ma description : "+description);
    }

}