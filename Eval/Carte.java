package p;

//Nicolas Durand et Dany Corbineau

import java.util.*;
import java.io.*;


	// A partir d'un fichier .txt, la classe carte récupère les informations et les classes en fonction de leur type dans les classes Lieu et Porte
public class Carte {
	
	private String nom;
    	private List<Lieu> listLieux= new ArrayList<>();

    
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
				System.err.println("\n/!\\Erreur à la fermeture de la carte /!\\\n");
				e.printStackTrace();
			}

			
		
	}

	

	// Cette méthode permet de vérifier si la carte à bien été chargé. Elle permet également de visualiser la carte.
    public void describe() {
		for (int i = 0; i < listLieux.size(); i++){
			listLieux.get(i).seDecrire();
		}
	
		
	}
	
	//Ce booléen est vérifié si tous les lieux sont visités
    public boolean isTotalVisite() {
		return getTotalVisite();
	}

	//Cette méthode établie l'état du booléen vu précédemment
	public boolean getTotalVisite() {
		for(Lieu lieu : listLieux) {
			if (!lieu.isVisite()) {
				Main.println("\n--> Il reste a visiter "+lieu.getNom()+".");
				return false;
			}
		}
		Main.println("--> Vous avez tout visité.");
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
    
	
	//Cette méthode permet d'associer un nom de lieu à une variable de type lieu de manière à recouper les info du fichier carte.txt
    public Lieu getLieuByName(String name)
    {
    	for(Lieu l: this.listLieux)
    	{
    		if(l.getNom().compareTo(name)==0)
    			return l;
    	}
    	return null;
    }
    
	//Méthode faisant le lien entre un objet clé et une porte secrète, de manière à la deverrouiller
    public void debloquerPorte(int clePorte)
    {
    	for(Lieu l: this.listLieux)
    	{
    		l.debloquerPorte(clePorte);
    	}
    	
    }
    

}
