package p;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Niveau: Permet de charger un niveau et de controller tout les elements du niveau (dangers, carte, objets) du jeux
 */

public class Niveau {
	
	private List<Danger> dangers;
    private Carte carte;
    private List<Objet> objets;
    
    private String nom;
    private String description;
    
	/**
	 * Constructeur qui initialise les attributes
	 */
    public Niveau() {
    	dangers=new ArrayList<>();
    	carte=null;
    	objets=new ArrayList<>();
    }
    
    
    /**
     * charge tout les elements du niveau 
     * @param fileName nom du fichier du niveau moins .txt
     * @throws FileNotFoundException exception si un fichier n'a pas été trouvé
     */
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
    	Main.println("\n#--------------------#\n");
    	Main.println("--> "+nom+"\n\n"+this.description);
		Main.println("\n--> Ce niveau contient "+carte.getSize()+" Salles, "+objets.size()+" Objets et "+dangers.size()+" Dangers.\n");
		Main.println("\n#--------------------#\n");
    	
    	
    	try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	//lieuActuel=carte.getfirstLieu();
    	
    }
    
    public String getName()
    {
    	return this.nom;
    }
    
    public int getNbDanger()
    {
    	return this.dangers.size();
    }
    
    public boolean allVisited()
    {
    	return carte.isTotalVisite();
    }
    
    public Lieu getFirstLieu()
    {
    	return carte.getPremierLieux();
    }
    
    public List<Danger> getDangers()
    {
    	return this.dangers;
    }
    
    public List<Objet> getAllObjet()
    {
    	return this.objets;
    }
    
    public void removeDanger(Danger d)
    {
    	this.dangers.remove(d);
    }
    
    public Lieu getLieuByName(String name)
    {
    	return carte.getLieuByName(name);
    }
    
    public Carte getCarte()
    {
    	return this.carte;
    }
    
   

    





}