package p;
import java.util.*;
import java.io.*;

//Par Malo Dupont
//Classe parente des objets,regroupe les methodes pour importer le fichier .csv, le lire et le convertir, pour créer des instances d'objets

//Petite note : Il n'y a pas forcement toutes les methodes necessaires pour l'instant (notamment pour les interactions), 

public abstract class Objet {

    protected String name;
    protected String itemRoom;
    protected String description;
    protected int itemSize;


    //Convertit les données du fichier specifie en entree (.csv) en ArrayList
    public static ArrayList<Objet> csvToArrayList(String fileName) throws FileNotFoundException {
    	
    	Scanner sc = new Scanner(new File(fileName));
    	sc.useDelimiter("\n");
    	int nbCle=0;
    	ArrayList<Objet> listeResult = new ArrayList<>();
        
    	while(sc.hasNext()){
    		listeResult.add(toSpecificSubObject(sc.next(),nbCle));
    	}
    	
    	sc.close();
    	
    	return listeResult;
    }
    
    public String getNameRoom()
    {
    	return this.itemRoom;
    }
    
    
    //Convertit le String specifie en entree (String provenant de l'ArrayList precedente) en instanciant les subclasses de la classe Objet
    public static Objet toSpecificSubObject(String aString,int nbCleActuel) {
    	
		String t[] = new String[5];
    	t = aString.split(";");
    	
    	
    	if(t[2].compareTo("I") == 0){
    		return new Information(t[0],t[1],t[3]);
    	}else if(t[2].compareTo("O") == 0){
    		return new Utilisable(t[0],t[1],t[3],1);
    	}else if(t[2].compareTo("C") == 0){
    		nbCleActuel++;
    		return new ClePorteSecrete(t[0],t[1],t[3],nbCleActuel);
    	}  	    	
    	return null;
    }
    
    //Decrit chacune des instances des trois subClasses (cette methode est redefinie pour chaque subclass si besoin, selon les differents parametres a afficher
    abstract String getAction();
    
    
    abstract public String utliserObjet(Personnage p,Carte c,List<Objet> listObj);
    
    
    //Transmet les objets presents dans une salle précise donnee en parametre
    public static List<Objet> getItemsInRoom(Lieu room,List<Objet> l) {
    	List<Objet> lo=new ArrayList<>();
    	int c=0;
    	for(Objet o: l)
    	{
    		if(o.getNameRoom().compareTo(room.getName())==0)
    			lo.add(o);
    	}
    	return lo;
    }
    
    public String getName()
    {
    	return this.name;
    }
    
}
