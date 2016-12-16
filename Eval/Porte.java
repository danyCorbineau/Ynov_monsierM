package p;
//Nicolas Durand et Dany Corbineau

//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier à des lieux précis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuArrive;
    private int key=0;
    
	/**
	* Constructeur de porte, Philippon Père et Fils
	* Constructeur des types portes
	**/
    public Porte(String nom, String lieuAr) {
    	this.nom = nom;
    	this.lieuArrive = lieuAr;
    }
    //Setter de key
    public void setCle(int k)
    {
    	this.key=k;
    }

	//Getter de nom
	public String getNom() {
		return nom;
	}
	//Setter de nom, que de répétitions
	public void setNom(String nom) {
		this.nom = nom;
	}

	//Getter de lieuArrive (Le lieu où menne une porte)
	public String getLieuArrive() {
		return lieuArrive;
	}
	
	//ça c'est le setter
	public void setLieuArrive(String lieuAr) {
		this.lieuArrive = lieuAr;
	}
	//Donne toutes les infos d'une porte, l'affichage diffère si c'est une porte secrète ou non
	public void decrire()
	{
		if (key == 0)
		System.out.println(nom+" vers "+lieuArrive);
		else
		System.out.println(nom+" vers "+lieuArrive+ ", Clé : "+ key);
	}
	//Booléen déterminant si la porte à besoin d'une clé
	public boolean estBloque() {
		return key!=0;
	}
	//setter du même booléen
	public void setBloque(boolean bloque) {
		if(!bloque)
			key=0;
	}
	//Getter du Lieu d'arrivée
	public String getDestination()
	{
		return lieuArrive;
	}
	//Getter de l'identif
	public int getCleId()
	{
		return this.key;
	}
	
	
}
