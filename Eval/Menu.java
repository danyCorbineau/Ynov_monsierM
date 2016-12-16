package p;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Menu: Permet à l'utilisateur de choisir un niveau, un personnage et de lancer le scénario
 */


public class Menu {
	private Scenario s;
	private List<Personnage> listePerso;
	
	/**
	 * Constructeur
	 */
	public Menu()
	{
		s=new Scenario();
		listePerso=new ArrayList<>();
	}
	
	/**
	 * Lancement du jeu
	 */
	public void start()
	{
		Scanner sc=new Scanner(System.in);
		boolean boucle=true;
		
		System.out.println();
		System.out.println("#--------------------------------------------------------------------------------------------------------------------------------#\n"+
						   "|  _       ___     ___  ____   _______ _____ ___________ _____ _____ _   _ _____ _____     _____ ______ _____ _____ _____ _____  |\n"+
						   "| | |     / _ \\    |  \\/  \\ \\ / /  ___|_   _|  ___| ___ \\_   _|  ___| | | /  ___|  ___|   |  __ \\| ___ \\  _  |_   _|_   _|  ___| |\n"+
						   "| | |    / /_\\ \\   | .  . |\\ V /\\ `--.  | | | |__ | |_/ / | | | |__ | | | \\ `--.| |__     | |  \\/| |_/ / | | | | |   | | | |__   |\n"+
						   "| | |    |  _  |   | |\\/| | \\ /  `--. \\ | | |  __||    /  | | |  __|| | | |`--. \\  __|    | | __ |    /| | | | | |   | | |  __|  |\n"+
						   "| | |____| | | |   | |  | | | | /\\__/ / | | | |___| |\\ \\ _| |_| |___| |_| /\\__/ / |___    | |_\\ \\| |\\ \\\\ \\_/ / | |   | | | |___  |\n"+
						   "| \\_____/\\_| |_/   \\_|  |_/ \\_/ \\____/  \\_/ \\____/\\_| \\_|\\___/\\____/ \\___/\\____/\\____/     \\____/\\_| \\_|\\___/  \\_/   \\_/ \\____/  |\n"+                                                    
						   "|                                                                                                                                |\n"+
						   "#--------------------------------------------------------------------------------------------------------------------------------#\n");
		
		
		while(boucle)
		{
			if(!s.haveNiveau()){ Main.println("1 : Choisir un niveau"); }
			if(!s.havePerso()){ Main.println("2 : Choisir un personnage"); }
			if(s.isValide()){ Main.println("3 : Jouer"); }
			Main.print("4 : Quitter\n> ");
			
			try
			{
				switch(sc.nextInt())
				{
				case 1: 
					try {
						
						Main.print("\n--> Nom du fichier niveau :\n> ");
						s.setLevel(sc.next()+".txt");
					} catch (FileNotFoundException e) {
						System.err.println("\n/!\\ Ce niveau n'existe pas /!\\\n");
					}
					break;
				case 2: 
					try {
						Main.println("\n--> Nom du fichier personnage :\n>");
						while(listePerso.size()>0)
							listePerso.remove(0);
						
						Personnage.chargementP(sc.next()+".csv", listePerso);
						
						Main.println("--> "+listePerso.size()+" personnages chargés.\n");
						for(int j=0 ; j<listePerso.size() ; j++)
						{
							Personnage p=listePerso.get(j);
							System.out.print("  >> "+j+" : ");
							p.description();
						}
						Main.print("\n--> Quel personnage souhaitez vous incarner ?\n> ");
						int i=sc.nextInt();
						if(i<listePerso.size()&&i>=0)
						{
							s.setPersonnage(listePerso.get(i));
							Main.println("\n--> Vous avez choisi d'incarner "+listePerso.get(i).getNom()+" !\n");
						}
						
					} catch (FileNotFoundException e) {
						System.err.println("\n/!\\ Ce personnage n'existe pas /!\\\n");
					}
					break;
				case 3: 
					if(s.isValide())
					{
						s.startSenario(sc);
					}
					else if(s.haveNiveau())
						Main.println("--> Il faut d'abord choisir un personnage avant de jouer !\n");
					else if(s.havePerso())
						Main.println("--> Il faut d'abord choisir un niveau avant de jouer !\n");
					else
						Main.println("--> Il faut d'abord choisir un personnage, ainsi qu'un niveau avant de jouer !\n");
					break;
				case 4: boucle=false; break;
				}
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
				System.err.println("/!\\ Données invalides ! /!\\");
			}

			
		}
		sc.close();
	}
	
	

}
