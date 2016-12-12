package com.ynov.p1;

import java.util.*;


public class Personnage {

  
    public Personnage(String str) {
    
    	String[] s2=str.split("; ");
    	
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


    public void chargemenPersonnage() {

    }

    public void niveauPersonnage() {

    }

    public void appelerObjet() {

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

    public void inspecterPiece() {
    }
    
    public void  description() {
    	System.out.println("Nom : "+nom+" - Profession : "+profession+" - HP : "+pointsDeVie+" - Def : "+niveauDeDefense+
    			" / Atk : "+niveauAttaque+" - Places d'objet : "+capaciteDeTransport);
    }

}