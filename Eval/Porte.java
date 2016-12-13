package commepackagenormal;
import java.util.*;


public class Porte {


    public Porte(String nom, Lieu lieuDep, String lieuAr) {
    	this.nom = nom;
    	this.lieuDep = lieuDep;
    	this.lieuAr = lieuAr;
    }


    String nom;

    Lieu lieuDep;
    
    String lieuAr;


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Lieu getLieuDep() {
		return lieuDep;
	}

	public void setLieuDep(Lieu lieuDep) {
		this.lieuDep = lieuDep;
	}

	public String getLieuAr() {
		return lieuAr;
	}

	public void setLieuAr(String lieuAr) {
		this.lieuAr = lieuAr;
	}

}