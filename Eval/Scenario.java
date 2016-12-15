package p;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Scenario: permet de lier un niveau avec un personnage et permet le déroulement du jeu
 */

public class Scenario {
	private Niveau niveau;
    private Personnage personnage;
    
    Room room;
    
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
    public void startSenario(Scanner sc)
    {
    	if(this.isValide())
    	{
    		int choix;
    		boolean loop=true;
    		
    		System.out.println("Vous avez choisie "+niveau.getName());// name
    		room=new Room(niveau.getFirstLieu(),niveau.getAllObjet(),niveau.getDangers());
    		
    		
    		
    		while(!niveau.allVisited() && niveau.getNbDanger()>0 && loop)
    		{
    			room.affDataRoom();
    			System.out.println("Que voulez vous faire?");
    			
    			System.out.println("  --1: Inspecter");
    			System.out.println("  --2: Changer de salle");
    			System.out.println("  --3: Ouvrire l'inventaire");
    			if(room.haveDanger())
    			{
    				System.out.println("  --4: Inspecter le danger");
        			System.out.println("  --5: Attaquer le danger");
    			}
    			
    			try
        		{
        			choix=sc.nextInt();
        			if(choix<6||choix>0)
        				new InputMismatchException();
        			
        			switch(choix)
        			{
        			case 1:
        				room.affAllIteminRoom();
        				
        				
        				break;
        			case 2: 
        				room.describeRoom();
        				choix=sc.nextInt();
        				if(choix>0 && choix-1<room.getNbPort())
        				{
        					Lieu lieu=niveau.getLieuByName(room.getPortDestById(choix-1));
            				if(lieu!=null)
            					room=new Room(lieu,niveau.getAllObjet(),niveau.getDangers());
           					else
           						System.out.println("!!!! une erreur est survenue !!!! Imposible de changer.");      					
        				}
        				break;
        			case 4: room.affDanger(); break;
        			case 5: 
        				try {
							personnage.attaquer(room.getDanger());
						} catch (DangerMeurtException e1) {
							System.out.println("  --!! Vous avez battue un danger !!--  ");
							niveau.removeDanger(room.getDanger());
							if(niveau.getNbDanger()==0)
							{
								System.out.println("------!!!!!! Bravo vous avez battue tout les dangez !!!!!!------");
							}
							
						}
        				break;
        			}
        			try {
        				if(room.haveDanger())
        					personnage.prendreDegats(room.dangerAttaquer());
					} catch (mortPersonnageException e) {
						System.out.println(" ---!!! Vous avez perdue !!!--- ");
						loop=false;
					}
        			
        			
        		}
        		catch(InputMismatchException e)
        		{
        			sc.nextLine();
        			System.out.println("---!!!! Données invalide !!!!---");
        		}
    		}
    	}
    }
    
    



}