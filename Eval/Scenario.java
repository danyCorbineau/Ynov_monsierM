package Eval;

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
    public void setLevel(String levelName)
    {
    	niveau=new Niveau();
    }
    
    public boolean isValide()
    {
    	return niveau!=null && personnage!= null;
    }

    



}