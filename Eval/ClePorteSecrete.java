package p;

import java.util.List;

//Par Malo Dupont
//Classe pour les objets qui ouvrent des passages secrets, menant à d'autres salles, voire à la sortie 

public class ClePorteSecrete extends Objet {

    protected String newRoomName;
    protected String accessType;
    int cleId;
    
    //Constructeur pour definir un objet qui ouvre un passage secret
    public ClePorteSecrete(String itemRoom, String name, String accessType,int id) {
    	this.itemRoom = itemRoom;
    	this.name = name;
    	this.accessType = accessType;
    	this.cleId=id;
    }
    
    
    //voir dans Objet
    public String getAction(){
    	return (name+", ouvre la porte "+accessType+"."+description+".");
    }

    
    /*Méthode pour créer un nouveau passage, non terminé, il faut faire le lien avec la partie de Nicolas
    *void addNewRoom(String newRoomName, String accessType) {
    *	new Porte(this.newRoomName, this.accessType);
    }
	*/


	@Override
	public String utliserObjet(Personnage p, Carte c,List<Objet> listObj) {
		listObj.remove(this);
		c.debloquerPorte(this.cleId);
		System.out.println("Porte avec clée"+ cleId +"débloqué.");
		return null;
	}

}