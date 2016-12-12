package Eval;
import java.util.*;
import java.io.*;

public class Objet {

    private String name;
    protected String itemRoom;
    protected ArrayList<String> listeResult;
    private String[] itemsParam;
    
    public Objet(){
    	
    }
    
    public Objet(String name){
    	this.name = name;
    }
    
    public Objet(String name, String itemRoom){
    	this.name = name;
    	this.itemRoom = itemRoom;
    }

    public String getName() {return name;}


    public ArrayList<String> csvToArrayList() throws FileNotFoundException {
    	
    	Scanner sc = new Scanner(new File("/Users/Malo/Documents/YNOV Ingésup B1/Projet P1 12-16 dec 2016/test.csv"));
    	sc.useDelimiter(";");
    	
    	ArrayList<String> listeResult = new ArrayList<>();
        
    	while(sc.hasNext()){
    		listeResult.add(sc.next());
    	}
    	sc.close();
    	
    	
    	this.listeResult = listeResult;
    	
    	return listeResult;
    }
    
}