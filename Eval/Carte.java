package commepackagenormal;
import java.util.*;
import java.io.*;


public class Carte {


    @SuppressWarnings("deprecation")
	public Carte() throws FileNotFoundException {

			DataInputStream dis = new DataInputStream(new FileInputStream(new File("carteTest.txt")));
			try {
				dis.readLine();
			} catch (IOException e) {
				System.out.println("Y'a une couille dans Carte !");
				e.printStackTrace();
			}
			try {
				dis.close();
			} catch (IOException e) {
				System.out.println("Problème à la fermeture de la carte !");
				e.printStackTrace();
			}

		
    }




    

	String nom;

    List<Lieu> listLieux= new ArrayList<>();


    List<Porte> listPortes= new ArrayList<>();


    void chargerCarte() {
        
    }
    
    public int getSize()
    {
    	return this.listLieux.size();
    }
    

}