package commepackagenormal;
import java.util.*;

/**
 * 
 */
public class Lieu {


    public Lieu(String nom, String description) {
    	this.nom = nom;
    	this.description = description;
    }


    String nom;


    String description;


 
    void explorer() {
// Penser à la liaison de portes
    }


    public void seDecrire() {
    	System.out.println(nom +"\n"+ description);
    }

}