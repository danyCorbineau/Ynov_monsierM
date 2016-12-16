package p;

//Cette classe permet d'instancier les portes (et autres acces) que l'on va lier à des lieux précis dans la classe Lieu.

public class Porte {
	private String nom;
    private String lieuArrive;
    private int key=0;
    
    public Porte(String nom, String lieuAr) {
    	this.nom = nom;
    	this.lieuArrive = lieuAr;
    }
    
    public void setCle(int k)
    {
    	this.key=k;
    }


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getLieuArrive() {
		return lieuArrive;
	}

	public void setLieuArrive(String lieuAr) {
		this.lieuArrive = lieuAr;
	}
	
	public void decrire()
	{
		if (key == 0)
		System.out.println(nom+" vers "+lieuArrive);
		else
		System.out.println(nom+" vers "+lieuArrive+ ", Clé : "+ key);
	}

	public boolean estBloque() {
		return key!=0;
	}

	public void setBloque(boolean bloque) {
		if(!bloque)
			key=0;
	}
	
	public String getDestination()
	{
		return lieuArrive;
	}
	
	public int getCleId()
	{
		return this.key;
	}
	
	
}