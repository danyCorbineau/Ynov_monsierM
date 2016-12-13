package Eval;
import java.util.*;


public class Porte {
	String nom;
    String lieuAr;
    int key=0;

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
		System.out.println("Porte: "+nom+" vers "+lieuAr);
	}
	

}