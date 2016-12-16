package p;

import java.util.List;
import java.util.Scanner;

import p.Main;

public class Piece {
	private Lieu l;
	private Danger d=null;
	private List<Objet> o;
	
	public Piece(Lieu l,List<Objet> allObj, List<Danger> danger) {
		
		l.setVisite(true);
		this.l=l;
		o=Objet.getItemsDansPiece(l, allObj);
		
		if(danger.size()>0)
			if((int)(Math.random()*2)==0)
				d=danger.get((int)(Math.random()*danger.size()));
	}
	
	public void afficherChoixUtilisateur()
	{
		Main.println("\n--> Que voulez-vous faire ?\n");
		
		Main.println(" >> 1: Inspecter");
		System.out.println(" >> 2: Changer de salle");
		System.out.println(" >> 3: Ouvrir l'inventaire");
		if(this.existeDanger())
		{
			System.out.println(" >> 4: Inspecter le danger");
			System.out.println(" >> 5: Attaquer le danger");
		}
		Main.print("\n> ");
	}
	
	
	public void affDatapiece()
	{
		Main.println("\n--> Vous êtes dans la salle "+l.getNom()+".");
		if(d!=null)
			System.out.print("\n--> Dans cette salle, il y a 1 danger, ainsi que ");
		else
			System.out.print("\n--> Dans cette salle, il n'y a pas de danger, mais il y a ");
		System.out.println(o.size()+" objet(s).");
	}
	
	public boolean existeDanger()
	{
		return d!=null;
	}
	
	public int dangerAttaquer()
	{
		return d.attaquer();
	}
	
	private Danger getDanger()
	{
		return this.d;
	}
	
	public void affDanger()
	{
		System.out.println(d.toString());
	}
	private void decrirePiece()
	{
		l.seDecrire();
	}
	private int getNbPorte()
	{
		return l.getNbPorte();
	}
	
	private String getPorteDestById(int id)
	{
		return this.l.getPorteDestById(id);
	}
	
	private boolean affToutItemDansPiece()
	{
		if(o.size()>0)
		{
			Main.println("--> Liste des objets dans "+l.getNom()+" :\n");
			int j=1;
			Main.println(" >> 0: ne rien faire.");
			for(Objet ob: o)
			{
				System.out.println(j+": "+ob.getAction());
				j++;
			}
			return true;
		}
		else
		{
			System.out.println("\n--> Il n'y a aucun objet dans cette pièce !\n");
			return false;
		}
	}
	private int getNbObj()
	{
		return this.o.size();
	}
	private void affObjet(int id)
	{
		System.out.println(this.o.get(id).getAction());
	}
	private Objet getObj(int id)
	{
		return this.o.get(id);
	}
	
	private boolean porteBloque(int idPorte)
	{
		return this.l.porteBloque(idPorte);
	}
	
	private void suprObj(Objet ob)
	{
		this.o.remove(ob);
	}
	private Danger suprDanger()
	{
		Danger da=d;
		d=null;
		return da;
	}
	
	
	public void choixInspecter(Scanner sc,Niveau n,Personnage p)
	{
		if(this.affToutItemDansPiece())
		{
			Main.print("\n--> Quel objet souhaitez vous prendre ?\n> ");
			int choix=sc.nextInt();
			if(choix>0&&choix-1<this.getNbObj())
			{
				Main.print("--> Que souhaitez-vous faire ?\n >> 1: Activer l'objet\n >> 2: Inspecter l'objet\n\n> ");
				int utilisation=sc.nextInt();
				if(utilisation==1)
				{
					Objet oTemp=this.getObj(choix-1);
					this.suprObj(oTemp);
					String s=oTemp.utliserObjet(p,n.getCarte(),n.getToutObjet());
					if(s!=null)
						Main.println("\n--> Description : \n"+s);
				}
				else if(utilisation==2)
				{
					this.affObjet(choix-1);
				}
			}
		}
	}
	
	public Piece choixChangerPiece(Scanner sc, Niveau n)
	{
		Piece ret=null;
		this.decrirePiece();
		int choix=sc.nextInt();
		if(choix>0 && choix-1<this.getNbPorte())
		{
			 if(!this.porteBloque(choix-1))
			 {
				 System.out.println("change vers: "+this.getPorteDestById(choix-1));
				 Lieu lieu=n.getLieuParNom(this.getPorteDestById(choix-1));
 				if(lieu!=null)
 					ret=new Piece(lieu,n.getToutObjet(),n.getDangers());
					else
						System.err.println("\n/!\\Erreur ! Impossible de changer de salle./!\\\n");   
			 }
			 else
			 {
				 Main.println("\n--> La porte est bloquée ! Impossible de l'ouvrir.\n");
			 }
		}
		return ret;
	}
	
	public void choixInventaire(Scanner sc,Personnage p,Niveau n)
	{
		int choix;
		Main.println("#---------------#\n"+
				     "|  INVENTAIRE   |\n"+
			     	 "#---------------#\n");

		p.afficherInventaire();
		Main.println("--> Quel objet utiliser ?\n> ");
		choix=sc.nextInt();
		if(choix>0&&choix-1<p.getNbItemInventaire())
		{
			p.utiliserObjInventaire(choix-1, n.getCarte(), n.getToutObjet());
		}
	}
	
	public void choixAttaquerDanger(Personnage p,Niveau n)
	{
		try {
			p.attaquer(this.getDanger());
		} catch (DangerMeurtException e1) {
			System.out.println("\n--> Vous avez battu le danger "+d.getName()+" !\n"); 
			n.suprDanger(this.suprDanger());
			if(n.getNbDanger()==0)
			{
				System.out.println("\n--> ");
			}
		}
	}
	
	
	
}
