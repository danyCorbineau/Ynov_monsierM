package Eval;
import java.util.*;
import java.io.*;

//Par Malo Dupont

public class Objet {

    protected String name;
    protected String itemRoom;
    protected String description;
    protected int itemSize;

    public String getName() {return name;}


    public static ArrayList<Objet> csvToArrayList() throws FileNotFoundException {
    	
    	Scanner sc = new Scanner(new File("/Users/Malo/Documents/YNOV Ingésup B1/Projet P1 12-16 dec 2016/test.csv"));
    	sc.useDelimiter("\n");
    	
    	ArrayList<Objet> listeResult = new ArrayList<>();
        
    	while(sc.hasNext()){
    		listeResult.add(toSpecificSubObject(sc.next()));
    	}
    	
    	sc.close();
    	
    	return listeResult;
    }
    
    
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
    
    public void describe(){
    	System.out.print("Je suis l'objet "+name+", présent dans la salle "+itemRoom+".");
    }
    
    
    
}
