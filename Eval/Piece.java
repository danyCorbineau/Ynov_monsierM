package p;

import java.util.List;
import java.util.Scanner;

public class Piece {
	private Lieu l;
	private Danger d=null;
	private List<Objet> o;
	
	public Piece(Lieu l,List<Objet> allObj, List<Danger> danger) {
		
		l.setVisite(true);
		this.l=l;
		o=Objet.getItemsInpiece(l, allObj);
		
		if(danger.size()>0)
			if((int)(Math.random()*2)==0)
				d=danger.get((int)(Math.random()*danger.size()));
	}
	
	public void afficherChoixUtilisateur()
	{
		System.out.println("Que voulez vous faire ?");
		
		System.out.println("  --1: Inspecter");
		System.out.println("  --2: Changer de salle");
		System.out.println("  --3: Ouvrir l'inventaire");
		if(this.existeDanger())
		{
			System.out.println("  --4: Inspecter le danger");
			System.out.println("  --5: Attaquer le danger");
		}
	}
	
	
	public void affDatapiece()
	{
		System.out.println("Vous êtes dans la salle "+l.getName());
		if(d!=null)
			System.out.print("Il y a 1 danger et il y a ");
		else
			System.out.print("Il n'y a pas de danger et il y a ");
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
	private void describepiece()
	{
		l.seDecrire();
	}
	private int getNbPort()
	{
		return l.getNbPort();
	}
	
	private String getPortDestById(int id)
	{
		return this.l.getPortDestById(id);
	}
	
	private boolean affAllIteminpiece()
	{
		if(o.size()>0)
		{
			System.out.println("Objet dans "+l.getName()+" :");
			int j=1;
			System.out.println("0: ne rien faire.");
			for(Objet ob: o)
			{
				System.out.println(j+": "+ob.getAction());
				j++;
			}
			return true;
		}
		else
		{
			System.out.println("   ---!!! Il n'y a rien à voir ici !!!---   ");
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
	
	private boolean portBloque(int idPorte)
	{
		return this.l.porteBloque(idPorte);
	}
	
	private void affAllObj()
	{
		int j=0;
		for(Objet ob: this.o)
		{
			System.out.println("--- "+j+" --- "+ob.getName());
			j++;
		}
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
		if(this.affAllIteminpiece())
		{
			System.out.println("Taper le numero de l'objet a voir ou utiliser.");
			int choix=sc.nextInt();
			if(choix>0&&choix-1<this.getNbObj())
			{
				System.out.println("Taper 1 pour activer l'objet ou 2 pour voire la description");
				int utilisation=sc.nextInt();
				if(utilisation==1)
				{
					Objet oTemp=this.getObj(choix-1);
					this.suprObj(oTemp);
					String s=oTemp.utliserObjet(p,n.getCarte(),n.getAllObjet());
					if(s!=null)
						System.out.println("Information: "+s);
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
		this.describepiece();
		int choix=sc.nextInt();
		if(choix>0 && choix-1<this.getNbPort())
		{
			 if(!this.portBloque(choix-1))
			 {
				 System.out.println("change vers: "+this.getPortDestById(choix-1));
				 Lieu lieu=n.getLieuByName(this.getPortDestById(choix-1));
 				if(lieu!=null)
 					ret=new Piece(lieu,n.getAllObjet(),n.getDangers());
					else
						System.out.println("!!!! Une erreur est survenue !!!! Impossible de changer.");   
			 }
			 else
			 {
				 System.out.println(" La porte est bloqué.");
			 }
		}
		return ret;
	}
	
	public void choixInventaire(Scanner sc,Personnage p,Niveau n)
	{
		int choix;
		System.out.println("Inventaire: ");
		p.afficherInventaire();
		System.out.println("Taper le numero de l'objet à utiliser");
		choix=sc.nextInt();
		if(choix>0&&choix-1<p.getNbItemInventaire())
		{
			p.utiliserObjInventaire(choix-1, n.getCarte(), n.getAllObjet());
		}
	}
	
	public void choixAttaquerDanger(Personnage p,Niveau n)
	{
		try {
			p.attaquer(this.getDanger());
		} catch (DangerMeurtException e1) {
			System.out.println("  --!! Vous avez battu un danger !!--  ");
			n.removeDanger(this.suprDanger());
			if(n.getNbDanger()==0)
			{
				System.out.println("------!!!!!! Bravo, vous avez battu tout les dangers !!!!!!------");
			}
		}
	}
	
	
	
}
