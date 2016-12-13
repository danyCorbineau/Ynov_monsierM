package Eval;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
	Scenario s;
	List<Personnage> listePerso;
	
	
	public Menu()
	{
		s=new Scenario();
		listePerso=new ArrayList<>();
		//load perso
	}
	
	public void start()
	{
		Scanner sc=new Scanner(System.in);
		boolean loop=true;
		
		
		while(loop)
		{
			System.out.println("1 : Choisir un niveau\n2 : Choisir un personnage\n3 : Jouer\n4 : Quitter\n");
			
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
						
						System.out.println(listePerso.size()+" personnages chargées.");
						for(int j=0 ; j<listePerso.size() ; j++)
						{
							Personnage p=listePerso.get(j);
							System.out.print("    -"+j+": ");
							p.description();
						}
						System.out.println("Tapez le n° du personnage que vous voulez incarner.");
						int i=sc.nextInt();
						s.setPersonnage(listePerso.get(i));
						
					} catch (FileNotFoundException e) {
						System.out.println("--- Le personnages n'existe pas. ---");
					}
					
					break;
				case 3: 
					if(s.isValide())
					{
						s.startSenario();
					}
					else
					{
						System.out.println("--- Il faut choisir un personnage et un niveau. ---");
					}
					
					break;
				case 4: loop=false; break;
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
