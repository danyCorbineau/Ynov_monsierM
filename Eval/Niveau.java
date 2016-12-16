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
    public void charger(String nomFichier) throws FileNotFoundException
    {
    	DataInputStream dis = new DataInputStream(new FileInputStream(new File(nomFichier)));
    	
    	try {
			nom=dis.readLine();
			carte=new Carte(dis.readLine());
			objets=Objet.csvToArrayList(dis.readLine());
			dangers=Danger.chargerDangers(dis.readLine(), dangers);
	    	
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
    	//lieuActuel=carte.getfirstLieu();
    	
    }
    
    public String getNom()
    {
    	return this.nom;
    }
    
    public int getNbDanger()
    {
    	return this.dangers.size();
    }
    
    public boolean estToutVisite()
    {
    	return carte.isTotalVisite();
    }
    
    public Lieu getLieuDepart()
    {
    	return carte.getPremierLieux();
    }
    
    public List<Danger> getDangers()
    {
    	return this.dangers;
    }
    
    public List<Objet> getToutObjet()
    {
    	return this.objets;
    }
    
    public void suprDanger(Danger d)
    {
    	this.dangers.remove(d);
    }
    
    public Lieu getLieuParNom(String name)
    {
    	return carte.getLieuByName(name);
    }
    
    public Carte getCarte()
    {
    	return this.carte;
    }
    
   

    





}