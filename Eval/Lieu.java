package p;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 */
public class Lieu {
	
	
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


    public void seDecrire() {
    	System.out.println("\n--> Vous êtes dans "+nom+".\n"+description+"\nCette pièce possède "+listPortes.size()+" portes.\n");
    	int j=1;
    	System.out.println(" >> "+0+": ne rien faire.");
    	for(Porte p: listPortes)
    	{
    		System.out.print(" >> "+j+": ");
    		p.decrire();
    		j++;
    	}
    	
    }
    public String getNom()
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
        			this.listPortes.get(this.listPortes.size()-1).setCle(Integer.valueOf(str[4].split(" ")[1]));
        		}
    		}
    		
    	}
    }
    
    public int getNbPorte()
    {
    	return this.listPortes.size();
    }
    
    public String getPorteDestById(int id)
    {
    	return this.listPortes.get(id).getDestination();
    }
    
    public void debloquerPorte(int clePorte)
    {
    	for(Porte p: this.listPortes)
    	{
    		if(p.getCleId()==clePorte)
    		{
    			p.setBloque(false);
    		}
    	}
    }
    
    public boolean porteBloque(int idPorte)
    {
    	return this.listPortes.get(idPorte).estBloque();
    }
    
    
    
    

}