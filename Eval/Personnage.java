package com.ynov.p1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/* Jérémy NUNES
 * Cette classe définit des objets concernant les personnages.
 * Elle permet également de charger les personnages pour pouvoir jouer (ainsi que leur niveau, objets, stats,...)
 */

public class Personnage {
	

    private String nom;

    private String profession;

    private int pointsDeVie;
    
    private int pointsDeVieMax;

    private int niveauDeDefense;

    private int niveauAttaque;

    private int capaciteDeTransport;
    
    
/*Les objets établis pour le personnage.
 *Les informations sont chargés à partir du fichier "Personnages.csv".
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
    
    
/* Charge le personnage dans le jeu après avoir selectionné le personnage interprété.
 * Si jamais l'accès au fichier des personnages (.csv) n'aboutit pas, la console affichera : "FileNotFoundException".
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
 * Charge un personnage une fois la partie lancé avec un niveau prédéfini.
 */
    public void niveauPersonnage() {
    }

    
/*
 * Le personnage appele un objet.
 */
    public void appelerObjet() {
    }
   
    
/*
 * Retourne les points de vie possédés par le personnage.    
 */
    public int pointsDeVie() {
    	return pointsDeVie;
    }

    
/*
 * Un personnage reçoit des dégats de la part d'un danger. Lors de ceci, il tire aléatoirement une défense allant de 0 jusqu'à son
 * nombre maximum de points de défense, ceci soustrait aux points d'attaque du danger ennemi.
 * 
 * Si un personnage reçoit moins de dégats qu'il possède de défense alors :
 * (Exemple : Le danger cause 10 de dégats, le personnage tire une défense de 18) Alors les points de vie du personnage sont inchangés
 * 
 * Si les points de vie du personnage tombent à 0 alors il meurt (liaison avec la classe "mortPersonnageException").     
 */
    public void prendreDegats( int degatsDanger) throws mortPersonnageException {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
    	int degatsRecus = degatsDanger - nombreAleatoire;
    	if (degatsRecus > 0) 
    		pointsDeVie = pointsDeVie - (degatsRecus);   		
    	
    	
    	if (pointsDeVie <= 0)
    		throw new mortPersonnageException();
    	
    	int pdvPourCent = (pointsDeVie*100) / pointsDeVieMax;
    	
    	System.out.println("Il reste à "+nom+" : "+pointsDeVie+" HP. ("+pdvPourCent+")");
    }

    
/*
 * Le personnage entame une action d'attaque.    
 */
    public void attaquer() {
    }


/*
 * Le joueur tire une attaque aléatoire allant de 0 jusqu'au nombre maximum de points d'attaque qu'il possède.     
 */  
    public int getDegatsAttaque() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauAttaque) + 1));
        return nombreAleatoire;
    }

    
/*
 * Le joueur tire une défense aléatoire allant de 0 jusqu'au nombre maximum de points de défense qu'il possède.     
 */  
    public int getNiveauDefense() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
        return nombreAleatoire;
    }


/*
 * Le joueur se déplace sur la carte.    
 */
    public void seDeplacer() {
    }

    
/*
 * Le personnage inspecte un objet.
 */
    public void inspecterObjet() {
    }

    
/*
 * Demande au joueur s'il veut fouiller ou non la salle dans laquelle il est présent.
 * Si le joueur ne répond par par 0 (Non) ou par 1 (Oui) alors la question lui sera reposé en boucle.    
 */
    public static void inspecterPiece() {
    	
    	Scanner sc = new Scanner(System.in);
    	int inspecterPiece = 0;
    	do{
    		System.out.println("Souhaitez vous fouiller la salle ? Répondre 0 pour Non & 1 pour Oui.");
            inspecterPiece = sc.nextInt();
            
            if(inspecterPiece != 1 && inspecterPiece != 2)
                System.out.println("Mode inconnu. Souhaitez vous fouiller la salle ? Répondre 0 pour Non & 1 pour Oui.");
            
            else if (inspecterPiece == 1)
            		System.out.println("Vous avez décidé de fouiller la pièce.");
            
            else if (inspecterPiece == 0)
            		System.out.println("Vous avez décidé de ne pas fouiller la pièce.");
    	}while(inspecterPiece !=0 && inspecterPiece !=1);
    }
/* 
 * Lorsqu'un personnage change de pièce..
 * 
 * 
 */

    
/*
 * Permet d'écrire les caractéristiques des différents personnages dans la console lors du choix de personnage dans le menu. 
 */
    public void  description() {
    	System.out.println("Mon pseudo est "+nom+", je suis un "+profession+". Je possède un nombre de HP égal à "+pointsDeVie+
    			", une défense de "+niveauDeDefense+", une attaque de "+niveauAttaque+
    			" et je peux porter jusqu'à "+capaciteDeTransport+" objets.");
    }

}