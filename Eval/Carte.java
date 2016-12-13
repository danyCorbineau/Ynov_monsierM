package commepackagenormal;
import java.util.*;
import java.io.*;
import java.io.File;

public class Carte {



	@SuppressWarnings("deprecation")
	public Carte(String nomFichier) throws FileNotFoundException {

			DataInputStream dis = new DataInputStream(new FileInputStream(new File(nomFichier)));
			
			String string ="";
			
			try {
				String temp;
				while ((temp=dis.readLine())!=null) {
					string += temp+"\n";
				}
			} catch (IOException e) {
				System.out.println("Si cette exception s'affiche, c'est normal !");
				System.out.println(string);
				e.printStackTrace();

			}
			

			System.out.println(string);
			
			try {
				dis.close();
			} catch (IOException e) {
				System.out.println("Problème à la fermeture de la carte !");
				e.printStackTrace();
			}

			String[] splitArraySalle;
			String[] splitArrayLieu;
			String[] splitArrayPorte;
			
			splitArraySalle = string.split(">");
			
			for (int i = 0; i < splitArraySalle.length; i++)
			{
				splitArrayLieu = splitArraySalle[i].split("\\");
				
				listLieux.add(new Lieu(splitArrayLieu[0], splitArrayLieu[1]));
				
				splitArrayPorte = splitArraySalle[2].split("\" \"");
				
				listPortes.add(new Porte(splitArrayPorte[0], listLieux.get(i), splitArrayPorte[1]));
			}
		
	}

	
	
	String nom;

    List<Lieu> listLieux= new ArrayList<>();

    
    
    List<Porte> listPortes= new ArrayList<>();

    
    
    
    public void describe() {
		for (int i = 0; i < listLieux.size(); i++){
			
			listLieux.get(i).seDecrire();
		}
	}
    


  
    public int getSize()
    {
    	return this.listLieux.size();
    }
    

}