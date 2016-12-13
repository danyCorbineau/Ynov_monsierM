package Eval;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Niveau {
	
	private List<Danger> dangers;
    private Carte carte;
    private List<Objet> objets;
    
    private String nom;
    private String description;
    
	
    public Niveau() {
    	dangers=new ArrayList<>();
    	carte=null;
    	objets=new ArrayList<>();
    	
    	
    	
    }
    
    public void charger(String fileName) throws FileNotFoundException
    {
    	DataInputStream dis = new DataInputStream(new FileInputStream(new File(fileName)));
    	
    	try {
			nom=dis.readLine();
			carte=new Carte(dis.readLine());
			objets=Objet.csvToArrayList(dis.readLine());
			dangers=Danger.loadDangers(dis.readLine(), dangers);
	    	
	    	description="";
	    	String s;
	    	while((s=dis.readLine())!=null)
	    		description+=s+"\n";
	    	
		} catch (IOException e) {
			
		}
    	System.out.println(nom+"\nDescription:	"+this.description+
				"\n -- Ce Niveau contient "+carte.getSize()+" Salles, "+objets.size()+" Objets et "+dangers.size()+" Dangers.");
    	
    	
    	try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    





}