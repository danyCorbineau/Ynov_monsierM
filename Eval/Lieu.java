package commepackagenormal;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 */
public class Lieu {
	
	// lieu visité ? (boolean + get set)
	
	private List<Porte> listPortes= new ArrayList<>();

    private String nom;

    private String description;

	private boolean visite = false;
	
	
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
    	System.out.println("\nLieu: "+nom +"\n"+ description +"\nCette pièce possède "+listPortes.size()+" portes\n");
    	for(Porte p: listPortes)
    	{
    		System.out.print(" --- ");
    		p.describe();
    	}
    	
    }
    public String getName()
    {
    	return this.getName();
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
        			this.listPortes.get(this.listPortes.size()-1).setKey(Integer.valueOf(str[4].split(" ")[1]));
    		}
    		
    	}
    }
    

}