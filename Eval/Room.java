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
		System.out.println(o.size()+" objets.");
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
	
	public void affAllIteminRoom()
	{
		System.out.println("Objet dans "+l.getName()+" :");
		for(Objet ob: o)
		{
			ob.getAction();
		}
		
	}
	
	

}
