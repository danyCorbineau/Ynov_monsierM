package p;
import java.util.*;



	//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier à des lieux précis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuAr;
    private int key=0;
    
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
		System.out.println(nom+" vers "+lieuAr);
		else
		System.out.println(nom+" vers "+lieuAr+ ", Clé : "+ key);
	}

	public boolean isBloque() {
		return key!=0;
	}

	public void setBloque(boolean bloque) {
		if(!bloque)
			key=0;
	}
	
	public String getDest()
	{
		return lieuAr;
	}
	
	public int getKeyId()
	{
		return this.key;
	}
	
	
}