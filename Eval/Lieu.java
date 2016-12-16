package p;
import java.util.ArrayList;
import java.util.List;

/**
 * Nicolas Durand et Dany Corbineau
 */
public class Lieu {
	
	
	protected List<Porte> listPortes= new ArrayList<>();
	protected String nom;
	protected String description;
	protected boolean visite = false;
	
	//Constructeur pour créer un Lieu, utilisé par Carte
    public Lieu(String nom, String description) {
    	this.nom = nom;
    	this.description = description;
    }
	//Booléen qui se vérifie si le Lieu est visité
    public boolean isVisite() {
		return visite;
	}
	//setter du booléen : visité
	public void setVisite(boolean visite) {
		this.visite = visite;
	}

	//Méthode permétant d'afficher les variables d'un Lieu sous une forme plus estéthique.
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
	
	//Getter de nom.
    public String getNom()
    {
    	return this.nom;
    }
    //Méthode servant à charger les portes, étonnamment.
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
    //Bon c'est évident ça aussi
    public int getNbPorte()
    {
    	return this.listPortes.size();
    }
    // Pareil
    public String getPorteDestById(int id)
    {
    	return this.listPortes.get(id).getDestination();
    }
    
	//Méthode débloquant la porte demandée
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
    
	//Booléen traduisant l'état de la porte (bloquée ou non)
    public boolean porteBloque(int idPorte)
    {
    	return this.listPortes.get(idPorte).estBloque();
    }
    public String getDescription()
    {
    	return this.description;
    }
    
    
    

}
