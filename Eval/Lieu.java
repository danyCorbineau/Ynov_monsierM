package p;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 */
public class Lieu {
	
	// lieu visité ? (boolean + get set)
	
	protected List<Porte> listPortes= new ArrayList<>();

	protected String nom;

	protected String description;

	protected boolean visite = false;
	
	
    public Lieu(String nom, String description) {
    	this.nom = nom;
    	this.description = description;
    }

	
    public boolean isVisite() {
		return visite;
	}


	public void setVisite(boolean visite) {
		this.visite = visite;
	}


	void explorer() {
// Penser à la liaison de portes
    }


    public void seDecrire() {
    	System.out.println("\n--> Vous êtes dans "+nom+".\n"+description+"\nCette pièce possède "+listPortes.size()+" portes.\n");
    	int j=1;
    	System.out.println(" >> "+0+": ne rien faire.");
    	for(Porte p: listPortes)
    	{
    		System.out.print(" >> "+j+": ");
    		p.describe();
    		j++;
    	}
    	
    }
    public String getName()
    {
    	return this.nom;
    }
    
    public void chargerPorte(String[] portes)
    { 
    	for(String s: portes)
    	{
			

    		String[] str=s.split("\"");
    		if(str.length>1)
    		{
    			this.listPortes.add(new Porte(str[1],str[3]));
        		if(str.length>4)
        		{
        			this.listPortes.get(this.listPortes.size()-1).setKey(Integer.valueOf(str[4].split(" ")[1]));
        		}
    		}
    		
    	}
    }
    
    public int getNbPort()
    {
    	return this.listPortes.size();
    }
    
    public String getPortDestById(int id)
    {
    	return this.listPortes.get(id).getDest();
    }
    
    public void debloquerPorte(int clePorte)
    {
    	for(Porte p: this.listPortes)
    	{
    		if(p.getKeyId()==clePorte)
    		{
    			p.setBloque(false);
    		}
    	}
    }
    
    public boolean porteBloque(int idPorte)
    {
    	return this.listPortes.get(idPorte).isBloque();
    }
    
    
    
    

}