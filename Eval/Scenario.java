package Eval;

import java.io.FileNotFoundException;

public class Scenario {
	private Niveau niveau;
    private Personnage personnage;
    
    
    public Scenario() {
    	niveau=null;
    	personnage=null;
    }
    
    public void setPersonnage(Personnage p)
    {
    	this.personnage=p;
    }
    public void setLevel(String levelName) throws FileNotFoundException
    {
    	niveau=new Niveau();
    	niveau.charger(levelName);
    }
    
    public boolean isValide()
    {
    	return niveau!=null && personnage!= null;
    }
    
    public boolean haveNiveau()
    {
    	return niveau!=null;
    }
    public boolean havePerso()
    {
    	return personnage!=null;
    }
    
    public void startSenario()
    {
    	
    }
    
    



}