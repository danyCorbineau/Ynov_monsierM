package p;

import java.util.List;

//Par Malo Dupont
//Classe pour les objets qui ouvrent des passages secrets, menant à d'autres salles, voire à la sortie 

public class ClePorteSecrete extends Objet {

    protected String nouveauNomPiece;
    protected String typeAccess;
    int cleId;
    
    //Constructeur pour definir un objet qui ouvre un passage secret
    public ClePorteSecrete(String itemRoom, String name, String accessType,int id) {
    	this.itemPiece = itemRoom;
    	this.name = name;
    	this.typeAccess = accessType;
    	this.cleId=id;
    }
    
    
    //voir dans Objet
    public String getAction(){
    	return ("\n--> L'objet "+name+", ouvre la porte "+typeAccess+" vers "+typeAccess +".");
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
		System.out.println("\n--> La Porte a été débloquée avec la clé "+ cleId +".\n");
		return null;
	}

}