package Eval;

//Par Malo Dupont

public class ClePorteSecrete extends Objet {

    private String newRoomName;
    private String accessType;
    
    public ClePorteSecrete(String itemRoom, String name, String accessType) {
    	this.itemRoom = itemRoom;
    	this.name = name;
    	this.accessType = accessType;

    }
    
    public void describe(){
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+". J'ouvre le passage "+accessType);
    }

    
    void addNewRoom(String newRoomName, String accessType) {
    	//new Lieu();

    }

}