package p;

//Nicolas Durand

import java.util.*;
import java.io.*;


	// A partir d'un fichier .txt, la classe carte récupère les informations et les classes en fonction de leur type dans les classes Lieu et Porte
public class Carte {
	
	private String nom;
    private List<Lieu> listLieux= new ArrayList<>();
    private boolean totalVisite = false;

    
    // Ce constructeur permet de charger un fichier carte.txt et d'en récupérer les informations.
	public Carte(String nomFichier) throws FileNotFoundException {

			DataInputStream dis = new DataInputStream(new FileInputStream(new File(nomFichier)));
			String fulltext="";
			
			String temp;
			try {
				while(( temp=dis.readLine())!=null)
				{
					fulltext+=temp+"\n";
				}
			} catch (IOException e1) {
			}
			
			
			String[] strLieu=fulltext.split(">");
			
			for(String s: strLieu)
			{
				
				String[] strParam=s.split("\\\\");
				if (strParam.length>1) {
				listLieux.add(new Lieu(strParam[0].split("\"")[1],strParam[1]));
				
				
				String[] strPorte=strParam[2].split("\n");
				
				listLieux.get(listLieux.size()-1).chargerPorte(strPorte);
			}
			}
			
			
			try {
				dis.close();
			} catch (IOException e) {
				System.out.println("Problème à la fermeture de la carte !");
				e.printStackTrace();
			}

			
		
	}

// ajouter une méthode static dans carte pour connaitre les porte d'un lieu en rentrant un lieu	
// Convertir String nom de lieu en lieu
	

	// Cette méthode permet de vérifier si la carte à bien été chargé. Elle permet également de visualiser la carte.
    public void describe() {
		for (int i = 0; i < listLieux.size(); i++){
			listLieux.get(i).seDecrire();
		}
	
		
	}
    public boolean isTotalVisite() {
		return totalVisite;
	}

	public boolean getTotalVisite(boolean totalVisite) {
		for(Lieu lieu : listLieux) {
			if (!lieu.isVisite()) {
				return false;
			}
		}
		return true;
	}

	// Permet de récuperer le premier lieu d'une carte (la première salle, le point de départ du niveau...)
    public Lieu getPremierLieux() 
    {
		return listLieux.get(0);
	}

	// Permet de connaitre le nombre de lieux que possède une carte.
    public int getSize()
    {
    	return this.listLieux.size();
    }
    

}