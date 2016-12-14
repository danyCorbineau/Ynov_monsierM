package Eval;
import java.io.FileNotFoundException;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Scenario: permet de lier un niveau avec un personnage et permet le déroulement du jeu
 */

public class Scenario {
	private Niveau niveau;
    private Personnage personnage;
    
    /**
     * Constructeur qui initialise
     */
    public Scenario() {
    	niveau=null;
    	personnage=null;
    }
    
    /**
     * Donne une valeur au personnage du scénario
     * @param p personnage qui sera utiliser dans le scénario
     */
    public void setPersonnage(Personnage p)
    {
    	this.personnage=p;
    }
    
    /**
     * Danne un niveau au scénario
     * @param levelName nom du fichier niveau à charger moins .txt
     * @throws FileNotFoundException exception généré si un fichier est manquant
     */
    public void setLevel(String levelName) throws FileNotFoundException
    {
    	niveau=new Niveau();
    	niveau.charger(levelName);
    }
    
    /**
     * Vérifie si ont peut lancer un senario
     * @return true si un personnage et un niveau ont été chargé 
     */
    public boolean isValide()
    {
    	return niveau!=null && personnage!= null;
    }
    
    /**
     * Vérifie si un niveau à été chargé
     * @return true si un niveau est chargé
     */
    public boolean haveNiveau()
    {
    	return niveau!=null;
    }
    
    /**
     * Vérifie si un personnage à été chargé
     * @return true si un personnage est chargé
     */
    public boolean havePerso()
    {
    	return personnage!=null;
    }
    
    /**
     * Lance le senario
     */
    public void startSenario()
    {
    	if(this.isValide())
    	{
    		
    	}
    }
    
    



}