package Eval;

//Par Malo Dupont
//Classe pour les objets qui ouvrent des passages secrets, menant à d'autres salles, voire à la sortie 

public class ClePorteSecrete extends Objet {

    protected String newRoomName;
    protected String accessType;
    
    //Constructeur pour definir un objet qui ouvre un passage secret
    public ClePorteSecrete(String itemRoom, String name, String accessType) {
    	this.itemRoom = itemRoom;
    	this.name = name;
    	this.accessType = accessType;
    }
    
    
    //voir dans Objet
    public void describe(){
    	System.out.println("Je suis l'objet "+name+", présent dans la salle "+itemRoom+". J'ouvre le passage "+accessType);
    }

    
    //Méthode pour créer un nouveau passage, non terminé, il faut faire le lien avec la partie de Nicolas
    void addNewRoom(String newRoomName, String accessType) {
    	//new Lieu();

    }

}