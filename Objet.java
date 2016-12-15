package Eval;
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
    	
    	ArrayList<Objet> listeResult = new ArrayList<>();
        
    	while(sc.hasNext()){
    		listeResult.add(toSpecificSubObject(sc.next()));
    	}
    	
    	sc.close();
    	
    	return listeResult;
    }
    
    
    //Convertit le String specifie en entree (String provenant de l'ArrayList precedente) en instanciant les subclasses de la classe Objet
    public static Objet toSpecificSubObject(String aString) {
    	
		String t[] = new String[5];
    	t = aString.split(";");
    	
    	if(t[2].compareTo("I") == 0){
    		return new Information(t[0],t[1],t[3]);
    	}else if(t[2].compareTo("O") == 0){
    		return new Utilisable(t[0],t[1],t[3],Integer.parseInt(t[4]));
    	}else if(t[2].compareTo("C") == 0){
    		return new ClePorteSecrete(t[0],t[1],t[3]);
    	}  	    	
    	return null;
    }
    
    //Decrit chacune des instances des trois subClasses (cette methode est redefinie pour chaque subclass si besoin, selon les differents parametres a afficher
    abstract void getAction();
    
    
    abstract void utliserObjet();
    
    
    //Transmet les objets presents dans une salle précise donnee en parametre
    public void getItemInRoom(Objet objet, Lieu room) {
    	System.out.println("Dans la pièce"+room+", on trouve les(l') objet(s) suivant(s) : ");
    	
    	while(objet.itemRoom == room.nom){
    		System.out.println("> "+objet.name+";");
    	}
    	
    }
    
    
}
