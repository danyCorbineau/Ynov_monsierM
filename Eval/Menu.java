package Eval;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/*
 * Dany CORBINEAU ; dany.corbineau@ynov.com
 * Classe Menu: Permet � l'utilisateur de choisir un niveau, un personnage et de lancer le sc�nario
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
		boolean loop=true;
		
		
		while(loop)
		{
			if(!s.haveNiveau()){ System.out.println("1 : Choisir un niveau"); }
			if(!s.havePerso()){ System.out.println("2 : Choisir un personnage"); }
			if(s.isValide()){ System.out.println("3 : Jouer"); }
			System.out.println("4 : Quitter");
			
			try
			{
				switch(sc.nextInt())
				{
				case 1: 
					try {
						System.out.println("Nom du fichier niveau:");
						s.setLevel(sc.next()+".txt");
					} catch (FileNotFoundException e) {
						System.out.println("--- Les niveau n'existe pas. ---");
					}
					break;
				case 2: 
					try {
						System.out.println("Nom du fichier personnage:");
						while(listePerso.size()>0)
							listePerso.remove(0);
						
						Personnage.chargementP(sc.next()+".csv", listePerso);
						
						System.out.println(listePerso.size()+" personnages charg�es.");
						for(int j=0 ; j<listePerso.size() ; j++)
						{
							Personnage p=listePerso.get(j);
							System.out.print("    -"+j+": ");
							p.description();
						}
						System.out.println("-- !! Tapez le n� du personnage que vous voulez incarner. !! --");
						int i=sc.nextInt();
						if(i<listePerso.size()&&i>0)
						{
							s.setPersonnage(listePerso.get(i));
							System.out.println("--- Vous incarner un personnage.");
						}
						
					} catch (FileNotFoundException e) {
						System.out.println("--- Les personnages n'existes pas. ---");
					}
					break;
				case 3: 
					if(s.isValide())
						s.startSenario();
					else if(s.haveNiveau())
						System.out.println("--- Il faut choisir un personnage. ---");
					else if(s.havePerso())
						System.out.println("--- Il faut choisir un niveau. ---");
					else
						System.out.println("--- Il faut choisir un personnage et un niveau. ---");
					break;
				case 4: loop=false; break;
				}
			}
			catch(InputMismatchException e)
			{
				sc.nextLine();
				System.out.println("---!!!! Donn�es invalide !!!!---");
			}
		}
		sc.close();
	}
	
	

}
