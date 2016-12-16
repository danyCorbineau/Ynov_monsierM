package p;

import java.util.List;

public class Room{
	
	private Lieu l;
	private Danger d=null;
	private List<Objet> o;
	
	public Room(Lieu l,List<Objet> allObj, List<Danger> danger) {
		
		l.setVisite(true);
		this.l=l;
		o=Objet.getItemsInRoom(l, allObj);
		
		if(danger.size()>0)
			if((int)(Math.random()*2)==0)
				d=danger.get((int)(Math.random()*danger.size()));
	}
	
	public void affDataRoom()
	{
		System.out.println("Vous êtes dans la salle "+l.getName());
		if(d!=null)
			System.out.print("Il y a 1 danger et il y a ");
		else
			System.out.print("Il n'y a pas de danger et il y a ");
		System.out.println(o.size()+" objet(s).");
	}
	
	public boolean haveDanger()
	{
		return d!=null;
	}
	
	public int dangerAttaquer()
	{
		return d.attaquer();
	}
	
	public Danger getDanger()
	{
		return this.d;
	}
	
	public void affDanger()
	{
		System.out.println(d.toString());
	}
	public void describeRoom()
	{
		l.seDecrire();
	}
	public int getNbPort()
	{
		return l.getNbPort();
	}
	
	public String getPortDestById(int id)
	{
		return this.l.getPortDestById(id);
	}
	
	public boolean affAllIteminRoom()
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
	public int getNbObj()
	{
		return this.o.size();
	}
	public void affObjet(int id)
	{
		System.out.println(this.o.get(id).getAction());
	}
	public Objet getObj(int id)
	{
		return this.o.get(id);
	}
	
	public boolean portBloque(int idPorte)
	{
		return this.l.porteBloque(idPorte);
	}
	
	public void affAllObj()
	{
		int j=0;
		for(Objet ob: this.o)
		{
			System.out.println("--- "+j+" --- "+ob.getName());
			j++;
		}
	}
	
	public void suprObj(Objet ob)
	{
		this.o.remove(ob);
	}
	public Danger suprDanger()
	{
		Danger da=d;
		d=null;
		return da;
	}
	
}
