package Eval;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/*
 * Dany CORBINEAU, dany.corbineau@ynov.com
 * Classe Danger: permet le chargement et le développement d'un danger dans le jeu vidéo
 * 
 */


public class Danger {

	private String nom;
	private int pv;
	private int attaque;
	
	/**
	 * charge un danger grâce à une ligne du csv
	 * @param line ligne du csv
	 */
    public Danger(String line) {
    	String[] temp=line.split(";");
    	
    	nom=temp[0];
    	pv=Integer.valueOf(temp[1]);
    	attaque=Integer.valueOf(temp[2]);
    	
    }
    
    /**
     * retourne l'attaque du joueur
     */
    public int attaquer()
    {
    	return this.attaque;
    }
    
    /**
     * diminue la vie du danger
     * @param pv nombre de pv qu'il va perdre
     * @throws DangerMeurtException généré si le nombre de pv<0
     */
    public void perdPv(int pv) throws DangerMeurtException
    {
    	this.pv-=pv;
    	if(pv<=0)
    		throw new DangerMeurtException(this);
    }
    
    /**
     * retourn une description de l'objet
     */
    public String toString()
    {
		return nom+" "+pv+" "+attaque;
    }
    
    /**
     * 
     * @return le nom de l'objet
     */
    public String getName()
    {
    	return this.nom;
    }
    
    
    /**
     * 
     * @param fName nom du fichier moins .csv
     * @param dangers la liste de danger à remplire
     * @return la liste remplie
     * @throws FileNotFoundException si le fichier n'est pas trouvé
     */
    public static List<Danger> loadDangers(String fName,List<Danger> dangers) throws FileNotFoundException
    {
    	DataInputStream dis = new DataInputStream(new FileInputStream(new File(fName)));
    	
    	try {
    		String s;
    		while((s=dis.readLine())!=null)
			{
    			dangers.add(new Danger(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return dangers;
    }
    


}