package p;

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
    private Inventaire inventaire;
    
    
/*
 * Les objets établis pour le personnage.
 * Les informations sont chargés à partir du fichier "Personnages.csv".
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
    	inventaire = new Inventaire();
    }
    
    
/* 
 * Charge le personnage dans le jeu après avoir selectionné le personnage interprété.
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
			e1.printStackTrace();
		}

    	try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }


// Retourne le nom du personnage.
    public String getNom() {return nom;}
    

// Retourne les points de vie possédés par le personnage.    
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
    public void prendreDegats( int degatsDanger) throws MortPersonnageException {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
    	int degatsRecus = degatsDanger - nombreAleatoire;
    	if (degatsRecus > 0) 
    		pointsDeVie = pointsDeVie - (degatsRecus);   		
    	
    	System.out.println("\n--> "+this.nom+" s'est fait attaquer !\n");
    	if (pointsDeVie <= 0)
    		throw new MortPersonnageException();
    	
    	int pdvPourCent = (pointsDeVie*100) / pointsDeVieMax;
    	
    	
    	Main.println("\n--> Il reste à "+nom+" "+pointsDeVie+"HP ("+pdvPourCent+"%).");
    }


// Le personnage entame une action d'attaque.    
    public void attaquer(Danger d) throws DangerMeurtException {
    	d.perdPv(this.getDegatsAttaque());
    }


// Le joueur tire une attaque aléatoire allant de 0 jusqu'au nombre maximum de points d'attaque qu'il possède.     
    public int getDegatsAttaque() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauAttaque) + 1));
        return nombreAleatoire;
    }

    
// Le joueur tire une défense aléatoire allant de 0 jusqu'au nombre maximum de points de défense qu'il possède.     
    public int getNiveauDefense() {
    	int nombreAleatoire = (int)(Math.random() * ((niveauDeDefense) + 1));
        return nombreAleatoire;
    }

    
// Permet d'écrire les caractéristiques des différents personnages dans la console lors du choix de personnage dans le menu. 
    public void  description() {
    	Main.println("Mon pseudo est "+nom+", je suis un "+profession+". Je possède un total de "+pointsDeVie+
    			"HP, une défense de "+niveauDeDefense+", une attaque de "+niveauAttaque+
    			" et je peux porter jusqu'à "+capaciteDeTransport+" objets.");
    }
    
    
// Ajoute un objet à l'inventaire du personnage.
    public void addObjet(Objet test) {
    	inventaire.ajouterObjet(test);
    }
  
    
// Supprime un objet de l'inventaire du personnage.
    public void suprObjet(Objet test) {
    	inventaire.supprimerObjet(test);
    }

    
// Affiche l'inventaire
    public void afficherInventaire() {
    	inventaire.afficherObjet();
    }
    
	
// Retourne le nombre d'items dans l'inventaire du personnage.
    public int getNbItemInventaire()
    {
    	return inventaire.getNbObjet();
    }
    
	
/*
 * Gère les objets de l'inventaire :
 * id : 	Utilise un objet défini.
 * this : 	Paramètre l'ID de l'objet.
 * c : 		Paramètre la carte du niveau.
 * lo : 	Paramètre la liste d'objet du niveau.
 */
	public void utiliserObjInventaire(int id, Carte c, List<Objet> lo)
	{
		inventaire.utiliserObj(id, this, c, lo);
	}
	

// Permet d'ajouter des PV au personnage (Par utilisation d'une potion).
	public void ajoutPv(int pv)
	{
		String plusMoins="";
		if(pv>0)
			plusMoins="+"+pv+").";
		else
			plusMoins=""+pv+").";
		
		this.pointsDeVie+=pv;
		if(this.pointsDeVie>this.pointsDeVieMax)
			this.pointsDeVie=this.pointsDeVieMax;
		Main.println(" -- Vous avez "+this.pointsDeVie+" ("+plusMoins);
	}
   
}
