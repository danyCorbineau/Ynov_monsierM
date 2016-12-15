package p;
import java.util.*;



	//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier à des lieux précis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuAr;
    private int key=0;
    private boolean bloque;
    
    //Le constructeur permet d'instancier les portes elles-mêmes
    public Porte(String nom, String lieuAr) {
    	this.nom = nom;
    	this.lieuAr = lieuAr;
    }
    
    //setKey détermine si la porte peut s'ouvrir avec une clé
    public void setKey(int k)
    {
    	this.key=k;
    }

    //getNom retourne le nom de la porte demandée
	public String getNom() {
		return nom;
	}
	
	//setNom quant à lui permet de modifier le nom de la porte demandée
	public void setNom(String nom) {
		this.nom = nom;
	}

	//getLieuAr retourne le lieu d'arrivée de l'acces (porte) demandée
	public String getLieuAr() {
		return lieuAr;
	}

	//setLieuAr permet de modifier le lieu d'arrivée de la porte demandée
	public void setLieuAr(String lieuAr) {
		this.lieuAr = lieuAr;
	}
	
	//describe affiche le nom de la porte, son lieu d'arrivée et, si elle est secrète.
	public void describe()
	{
		if (key == 0)
		System.out.println("Porte: "+nom+" vers "+lieuAr);
		else
		System.out.println("Porte: "+nom+" vers "+lieuAr+ ", Clé : "+ key);
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}
	
}