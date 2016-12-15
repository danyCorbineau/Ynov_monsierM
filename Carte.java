package commepackagenormal;

//Nicolas Durand

import java.util.*;
import java.io.*;



public class Carte {
	String nom;
    List<Lieu> listLieux= new ArrayList<>();


    
    // Ce constructeur permet de charger un fichier carte.txt et d'en récupérer les informations.
	public Carte(String nomFichier) throws FileNotFoundException {

			DataInputStream dis = new DataInputStream(new FileInputStream(new File(nomFichier)));
			String fulltext="";
			
			String temp;
			try {
				while(( temp=dis.readLine())!=null)
				{
					fulltext+=temp;
				}
			} catch (IOException e1) {
			}
			
			
			String[] strLieu=fulltext.split(">");
			
			for(String s: strLieu)
			{
				
				String[] strParam=s.split("\\\\");
				listLieux.add(new Lieu(strParam[0],strParam[1]));
				
				String[] strPorte=strParam[2].split("\n");
				listLieux.get(listLieux.size()-1).chargerPorte(strPorte);
			}
			
			
			try {
				dis.close();
			} catch (IOException e) {
				System.out.println("Problème à la fermeture de la carte !");
				e.printStackTrace();
			}

			
		
	}

	
	
	

	// Cette méthode permet de vérifier si la carte à bien été chargé. Elle permet également de visualiser la carte.
    public void describe() {
		for (int i = 0; i < listLieux.size(); i++){
			listLieux.get(i).seDecrire();
		}
		
		
	}
    // Permet de connaitre le nombre de lieux que possède une carte.
    public int getSize()
    {
    	return this.listLieux.size();
    }
    

}