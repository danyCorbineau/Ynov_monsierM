package Eval;
import java.io.FileNotFoundException;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Scenario: permet de lier un niveau avec un personnage et permet le d�roulement du jeu
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
     * Donne une valeur au personnage du sc�nario
     * @param p personnage qui sera utiliser dans le sc�nario
     */
    public void setPersonnage(Personnage p)
    {
    	this.personnage=p;
    }
    
    /**
     * Danne un niveau au sc�nario
     * @param levelName nom du fichier niveau � charger moins .txt
     * @throws FileNotFoundException exception g�n�r� si un fichier est manquant
     */
    public void setLevel(String levelName) throws FileNotFoundException
    {
    	niveau=new Niveau();
    	niveau.charger(levelName);
    }
    
    /**
     * V�rifie si ont peut lancer un senario
     * @return true si un personnage et un niveau ont �t� charg� 
     */
    public boolean isValide()
    {
    	return niveau!=null && personnage!= null;
    }
    
    /**
     * V�rifie si un niveau � �t� charg�
     * @return true si un niveau est charg�
     */
    public boolean haveNiveau()
    {
    	return niveau!=null;
    }
    
    /**
     * V�rifie si un personnage � �t� charg�
     * @return true si un personnage est charg�
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