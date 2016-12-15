package p;
import java.util.*;



	//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier à des lieux précis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuAr;
    private int key=0;
    private boolean bloque;
    
    public Porte(String nom, String lieuAr) {
    	this.nom = nom;
    	this.lieuAr = lieuAr;
    }
    
    public void setKey(int k)
    {
    	this.key=k;
    }


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getLieuAr() {
		return lieuAr;
	}

	public void setLieuAr(String lieuAr) {
		this.lieuAr = lieuAr;
	}
	
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
	
	public String getDest()
	{
		return lieuAr;
	}
	
	
}