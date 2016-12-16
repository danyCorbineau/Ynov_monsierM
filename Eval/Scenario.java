package p;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Scenario: permet de lier un niveau avec un personnage et permet le déroulement du jeu
 */

public class Scenario {
	private Niveau niveau;
    private Personnage personnage;
    
    private Piece piece;
    
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
    public void donnerPersonnage(Personnage p)
    {
    	this.personnage=p;
    }
    
    /**
     * Danne un niveau au scénario
     * @param levelName nom du fichier niveau à charger moins .txt
     * @throws FileNotFoundException exception généré si un fichier est manquant
     */
    public void donnerLevel(String levelName) throws FileNotFoundException
    {
    	niveau=new Niveau();
    	niveau.charger(levelName);
    }
    
    /**
     * Vérifie si ont peut lancer un senario
     * @return true si un personnage et un niveau ont été chargé 
     */
    public boolean estValide()
    {
    	return niveau!=null && personnage!= null;
    }
    
    /**
     * Vérifie si un niveau à été chargé
     * @return true si un niveau est chargé
     */
    public boolean aUnNiveau()
    {
    	return niveau!=null;
    }
    
    /**
     * Vérifie si un personnage à été chargé
     * @return true si un personnage est chargé
     */
    public boolean aUnPerso()
    {
    	return personnage!=null;
    }
    
    /**
     * Lance le senario
     */
    public void lancerSenario(Scanner sc)
    {
    	if(this.estValide())
    	{
    		int choix;
    		boolean boucle=true;
    		
    		Main.println("Vous avez choisi le niveau "+niveau.getNom()+" !");// name
    		piece=new Piece(niveau.getLieuDepart(),niveau.getToutObjet(),niveau.getDangers());
    		
    		
    		
    		while( (!niveau.estToutVisite() || niveau.getNbDanger()>0) && boucle)
    		{
    			Main.println("--> Il reste "+niveau.getNbDanger()+" danger(s).");
    			piece.affDatapiece();
    			
    			try {
    				if(piece.existeDanger())
    					personnage.prendreDegats(piece.dangerAttaquer());
				} catch (MortPersonnageException e) {
					System.out.println("\n#-------------------#\n"+
							   "|     GAME OVER     |\n"+
							   "| Vous avez perdu ! |\n"+
							   "#-------------------#\n");
					boucle=false;
					continue;
				}
    			piece.afficherChoixUtilisateur();
    			try
        		{
        			choix=sc.nextInt();
        			if(choix<6||choix>0)
        				new InputMismatchException();
        			
        			switch(choix)
        			{
        			case 1: // inspecter pièce
        				piece.choixInspecter(sc,niveau,personnage);
        				break;
        			case 2: // changer pièce
        				Piece pi=piece.choixChangerPiece(sc, niveau);
        				if(pi!=null)
        					this.piece=pi;
        				break;
        			case 3: // inventaie
        				piece.choixInventaire(sc, personnage, niveau);
        				break;
        			case 4: if(piece.existeDanger()){piece.affDanger();} break; // afficher danger stats
        			case 5: // attaquer un danger
        				if(piece.existeDanger())
        				{
        					piece.choixAttaquerDanger(personnage, niveau);
        				}
        				break;
        			}
        			
        			
        			
        		}
        		catch(InputMismatchException e)
        		{
        			sc.nextLine();
        			System.err.println("\n/!\\ Données invalides /!\\\n");
        		}
    		}
		Main.println("\n#-------------------#\n"+
    		 		   "|     GAME OVER     |\n"+
				   "| Vous avez gagné ! |\n"+
    				   "#-------------------#\n");
    	}
    }
    
    



}
