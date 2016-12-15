package p;
import java.util.*;



	//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier � des lieux pr�cis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuAr;
    private int key=0;
    private boolean bloque;
    
    //Le constructeur permet d'instancier les portes elles-m�mes
    public Porte(String nom, String lieuAr) {
    	this.nom = nom;
    	this.lieuAr = lieuAr;
    }
    
    //setKey d�termine si la porte peut s'ouvrir avec une cl�
    public void setKey(int k)
    {
    	this.key=k;
    }

    //getNom retourne le nom de la porte demand�e
	public String getNom() {
		return nom;
	}
	
	//setNom quant � lui permet de modifier le nom de la porte demand�e
	public void setNom(String nom) {
		this.nom = nom;
	}

	//getLieuAr retourne le lieu d'arriv�e de l'acces (porte) demand�e
	public String getLieuAr() {
		return lieuAr;
	}

	//setLieuAr permet de modifier le lieu d'arriv�e de la porte demand�e
	public void setLieuAr(String lieuAr) {
		this.lieuAr = lieuAr;
	}
	
	//describe affiche le nom de la porte, son lieu d'arriv�e et, si elle est secr�te.
	public void describe()
	{
		if (key == 0)
		System.out.println("Porte: "+nom+" vers "+lieuAr);
		else
		System.out.println("Porte: "+nom+" vers "+lieuAr+ ", Cl� : "+ key);
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}
	
}