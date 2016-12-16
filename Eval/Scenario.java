package p;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import p.Main;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Scenario: permet de lier un niveau avec un personnage et permet le d�roulement du jeu
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
     * Donne une valeur au personnage du sc�nario
     * @param p personnage qui sera utiliser dans le sc�nario
     */
    public void donnerPersonnage(Personnage p)
    {
    	this.personnage=p;
    }
    
    /**
     * Danne un niveau au sc�nario
     * @param levelName nom du fichier niveau � charger moins .txt
     * @throws FileNotFoundException exception g�n�r� si un fichier est manquant
     */
    public void donnerLevel(String levelName) throws FileNotFoundException
    {
    	niveau=new Niveau();
    	niveau.charger(levelName);
    }
    
    /**
     * V�rifie si ont peut lancer un senario
     * @return true si un personnage et un niveau ont �t� charg� 
     */
    public boolean estValide()
    {
    	return niveau!=null && personnage!= null;
    }
    
    /**
     * V�rifie si un niveau � �t� charg�
     * @return true si un niveau est charg�
     */
    public boolean aUnNiveau()
    {
    	return niveau!=null;
    }
    
    /**
     * V�rifie si un personnage � �t� charg�
     * @return true si un personnage est charg�
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
    		
    		Main.println("Vous avez choisi le niveau "+niveau.getName()+" !");// name
    		piece=new Piece(niveau.getFirstLieu(),niveau.getAllObjet(),niveau.getDangers());
    		
    		
    		
    		while( (!niveau.allVisited() || niveau.getNbDanger()>0) && boucle)
    		{
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
        			case 1: // inspecter pi�ce
        				piece.choixInspecter(sc,niveau,personnage);
        				break;
        			case 2: // changer pi�ce
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
        			System.err.println("\n/!\\ Donn�es invalides /!\\\n");
        		}
    		}
    		Main.println("\n#--------------------#\n");
    		System.out.println("--> Partie Termin�e ! Bien jou� � vous !");
    		System.out.println("\n#--------------------#\n");
    	}
    }
    
    



}