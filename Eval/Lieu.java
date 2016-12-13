package Eval;
import java.util.*;

import javax.swing.plaf.synth.SynthSeparatorUI;

/**
 * 
 */
public class Lieu {
	List<Porte> listPortes= new ArrayList<>();

    public Lieu(String nom, String description) {
    	this.nom = nom;
    	this.description = description;
    }


    String nom;


    String description;


 
    void explorer() {
// Penser à la liaison de portes
    }


    public void seDecrire() {
    	System.out.println("Lieu: "+nom +"\n"+ description);
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
    		
    		this.listPortes.add(new Porte(str[0],str[1]));
    		if(str.length==3)
    			this.listPortes.get(this.listPortes.size()-1).setKey(Integer.valueOf(str[2]));
    		
    	}
    }
    

}