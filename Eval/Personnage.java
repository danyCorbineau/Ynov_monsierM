package com.ynov.p1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/* J�r�my NUNES
 * Cette classe d�finit des objets concernant les personnages.
 * Elle permet �galement de charger les personnages pour pouvoir jouer (ainsi que leur niveau, objets, stats,...)
 */

public class Personnage {
	

    private String nom;

    private String profession;

    private int pointsDeVie;
    
    private int pointsDeVieMax;

    private int niveauDeDefense;

    private int niveauAttaque;

    private int capaciteDeTransport;
    
    
/*Les objets �tablis pour le personnage.
 *Les informations sont charg�s � partir du fichier "Personnages.csv".
 */
    public Personnage(String str) {
        
    	String[] s2=str.split(";");
    	
    	nom=s2[0];
    	profession=s2[1];
    	pointsDeVie=Integer.valueOf(s2[2]);
    	niveauDeDefense=Integer.valueOf(s2[3]);
    	niveauAttaque=Integer.valueOf(s2[4]);
    	capaciteDeTransport=Integer.valueOf(s2[5]);
    	pointsDeVieMax = pointsDeVie;	
    }
    
    
/* Charge le personnage dans le jeu apr�s avoir selectionn� le personnage interpr�t�.
 * Si jamais l'acc�s au fichier des personnages (.csv) n'aboutit pas, la console affichera : "FileNotFoundException".
 */
    public static void chargementP(String cP, List listPersonnage) throws FileNotFoundException {

    	DataInputStream dis = new DataInputStream(new FileInputStream(new File(cP)));
    	
    	String ligne;
    	
    	try {
			while ((ligne = dis.readLine()) !=null){	
				
				listPersonnage.add(new Personnage(ligne));	
				
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

    	try {
			dis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
/*
 * Charge un personnage une fois la partie lanc� avec un niveau pr�d�fini.
 */
    public void niveauPersonnage() {
    }

    
/*
 * Le personnage appele un objet.
 */
    public void appelerObjet() {
    }
   
    
/*
 * Retourne les points de vie poss�d�s par le personnage.    
 */
    public int pointsDeVie() {
    	return pointsDeVie;
    }

    
/*
 * Un personnage re�oit des d�gats de la part d'un danger. Lors de ceci, il tire al�atoirement une d�fense allant de 0 jusqu'� son
 * nombre maximum de points de d�fense, ceci soustrait aux points d'attaque du danger ennemi.
 * 
 * Si un personnage re�oit moins de d�gats qu'il poss�de de d�fense alors :
 * (Exemple : Le danger cause 10 de d�gats, le personnage tire une d�fense de 18) Alors les points de vie du personnage sont inchang�s
 * 
 * Si les points de vie du personnage tombent � 0 alors il meurt (liaison avec la classe "mortPersonnageException").     
 */
    public void prendreDegats( int degatsDanger) throws mortPersonnageException {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
    	int degatsRecus = degatsDanger - nombreAleatoire;
    	if (degatsRecus > 0) 
    		pointsDeVie = pointsDeVie - (degatsRecus);   		
    	
    	
    	if (pointsDeVie <= 0)
    		throw new mortPersonnageException();
    	
    	int pdvPourCent = (pointsDeVie*100) / pointsDeVieMax;
    	
    	System.out.println("Il reste � "+nom+" : "+pointsDeVie+" HP. ("+pdvPourCent+")");
    }

    
/*
 * Le personnage entame une action d'attaque.    
 */
    public void attaquer() {
    }


/*
 * Le joueur tire une attaque al�atoire allant de 0 jusqu'au nombre maximum de points d'attaque qu'il poss�de.     
 */  
    public int getDegatsAttaque() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauAttaque) + 1));
        return nombreAleatoire;
    }

    
/*
 * Le joueur tire une d�fense al�atoire allant de 0 jusqu'au nombre maximum de points de d�fense qu'il poss�de.     
 */  
    public int getNiveauDefense() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
        return nombreAleatoire;
    }


/*
 * Le joueur se d�place sur la carte.    
 */
    public void seDeplacer() {
    }

    
/*
 * Le personnage inspecte un objet.
 */
    public void inspecterObjet() {
    }

    
/*
 * Demande au joueur s'il veut fouiller ou non la salle dans laquelle il est pr�sent.
 * Si le joueur ne r�pond par par 0 (Non) ou par 1 (Oui) alors la question lui sera repos� en boucle.    
 */
    public static void inspecterPiece() {
    	
    	Scanner sc = new Scanner(System.in);
    	int inspecterPiece = 0;
    	do{
    		System.out.println("Souhaitez vous fouiller la salle ? R�pondre 0 pour Non & 1 pour Oui.");
            inspecterPiece = sc.nextInt();
            
            if(inspecterPiece != 1 && inspecterPiece != 2)
                System.out.println("Mode inconnu. Souhaitez vous fouiller la salle ? R�pondre 0 pour Non & 1 pour Oui.");
            
            else if (inspecterPiece == 1)
            		System.out.println("Vous avez d�cid� de fouiller la pi�ce.");
            
            else if (inspecterPiece == 0)
            		System.out.println("Vous avez d�cid� de ne pas fouiller la pi�ce.");
    	}while(inspecterPiece !=0 && inspecterPiece !=1);
    }
/* 
 * Lorsqu'un personnage change de pi�ce..
 * 
 * 
 */

    
/*
 * Permet d'�crire les caract�ristiques des diff�rents personnages dans la console lors du choix de personnage dans le menu. 
 */
    public void  description() {
    	System.out.println("Mon pseudo est "+nom+", je suis un "+profession+". Je poss�de un nombre de HP �gal � "+pointsDeVie+
    			", une d�fense de "+niveauDeDefense+", une attaque de "+niveauAttaque+
    			" et je peux porter jusqu'� "+capaciteDeTransport+" objets.");
    }

}