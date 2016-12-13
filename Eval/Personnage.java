package com.ynov.p1;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Personnage {

  
    public Personnage(String str) {
    
    	String[] s2=str.split(";");
    	
    	nom=s2[0];
    	profession=s2[1];
    	pointsDeVie=Integer.valueOf(s2[2]);
    	niveauDeDefense=Integer.valueOf(s2[3]);
    	niveauAttaque=Integer.valueOf(s2[4]);
    	capaciteDeTransport=Integer.valueOf(s2[5]);
    	
    }

    private String nom;

    private String profession;

    private int pointsDeVie;

    private int niveauDeDefense;

    private int niveauAttaque;

    private int capaciteDeTransport;


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

    public void niveauPersonnage() {

    }

    public void appelerObjet() {

    }
    
    public void prendreDegats( int degatsDanger) throws mortPersonnageException {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
    	int degatsRecus = degatsDanger - nombreAleatoire;
    	if (degatsRecus > 0) 
    		pointsDeVie = pointsDeVie - (degatsRecus);   	
    	
    	
    	if (pointsDeVie <= 0)
    		throw new mortPersonnageException();
    	
    	System.out.println("Il reste à "+nom+" "+pointsDeVie+"HP.");
    	
    }

    public void attaquer() {
    	
    }

 
    public int getDegatsAttaque() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauAttaque) + 1));
        return nombreAleatoire;
    }

  
    public int getNiveauDefence() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
        return nombreAleatoire;
    }

   
    public void seDeplacer() {
    
    }

    public void inspecterObjet() {
    }

    public static void inspecterPiece() {
    	
    	Scanner sc = new Scanner(System.in);
    	int inspecterPiece = 0;
    	do{
    		System.out.println("Souhaitez vous fouiller la salle ? Répondre 0 pour Non & 1 pour Oui ");
            inspecterPiece = sc.nextInt();
            
            if(inspecterPiece != 1 && inspecterPiece != 2)
                System.out.println("Mode inconnu. Souhaitez vous fouiller la salle ? Répondre 0 pour Non & 1 pour Oui ");
            
            else if (inspecterPiece == 1)
            		System.out.println("Vous avez décidé de fouiller la pièce.");
            
            else if (inspecterPiece == 0)
            		System.out.println("Vous avez décidé de ne pas fouiller la pièce.");
    	}while(inspecterPiece !=0 && inspecterPiece !=1);
    }
    
    /*m Lorsqu'un personnage change de pièce
     *
     * 
     * 
     * 
     */
    	
    public void  description() {
    	System.out.println("Nom : "+nom+" - Profession : "+profession+" - HP : "+pointsDeVie+" - Def : "+niveauDeDefense+
    			" / Atk : "+niveauAttaque+" - Places d'objet : "+capaciteDeTransport);
    }

}