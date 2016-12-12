package com.ynov.control;

public class Player {
	private String name;
	private int hp;
	private long xp;
	private Weapon weapon;
	
	/*
	 * constructors
	 */
	public Player(String name)
	{
		this.name=name;
	}
	
	public Player(String name, int pv)
	{
		this.name=name;
		this.hp=pv;
	}
	
	
	/*
	 * getters, setters
	 */
	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		if(hp<0)
			hp=0;
		
		this.hp = hp;
	}

	public long getXp() {
		return xp;
	}

	public void setXp(long xp) {
		this.xp = xp;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}
	
	
	/*
	 * describe
	 */
	public void describe() throws PlayerDeadExeption
	{
		if(this.getHp()<=0)
			throw new PlayerDeadExeption(this);
		
		System.out.println("Je suis "+this.getName()+" ("+this.getHp()+" PV), et je peux faire jusqu'à "+this.getWeapon().getDamages()+" dégats avec mon "+this.getWeapon().getName()+" de type "+this.getWeapon().getType()+".");
	}
	
	
	/*
	 * attaque
	 */
	public void attaquer(Monster m)
	{
		int pointAleat;
		
		System.out.println("\n---\nCombat entre "+this.getName()+" ("+this.getHp()+") et"+ m.getName()+ " ("+m.getHp()+").\n");
		
		/*
		 * Loop 
		 */
		while( this.getHp()>0 && m.getHp()>0 )
		{
			/*
			 * gen player att
			 */
			pointAleat=(int) (Math.random()*(this.getWeapon().getDamages()+1));
			
			/*
			 * gen a critical hit
			 */
			if((int)(Math.random()*2)==0)
			{
				pointAleat*=2;
				System.out.print("(Coup critique) ");
			}
			
			/*
			 * print player att
			 */
			System.out.println("- "+this.getName()+" attaque "+m.getName()+" avec une puissance de "+pointAleat+".");
			m.looseHp(pointAleat);
			System.out.println(m.getName()+" a "+m.getHp()+" HP.");
			
			/*
			 * if monster is alive
			 */
			if(m.getHp()>0)
			{
				/*
				 * print monster att
				 */
				
				this.setHp(this.getHp()-m.getDamages());
				System.out.println("-- "+m.getName()+" attaque ("+m.getDamages()+" ATT). "+ this.getName()+ " a "+this.getHp()+" HP.");
			}
			else
			{
				/*
				 * player win and print msg
				 */
				
				this.setXp(this.getXp()+10);
				
				System.out.println("Le monstre "+m.getName()+" a été battue par "+this.getName()+" ("+this.getHp()+" HP).");
				System.out.println(this.getName()+" gagne 10 XP et a donc "+this.getXp()+" XP.");
				this.looter(m);
			}
			
		}
		
		/*
		 * id player is dead
		 */
		if(this.getHp()<=0)
		{
			this.setXp(0);
			System.out.println(this.getName()+" a perdu. Il perd son XP.");
		}
		System.out.println("\n---\n");
		
	}
	
	/*
	 * Partie 4 
	 * loot
	 */
	public void looter(Lootable l)
	{
		System.out.println(this.getName()+" vient de récupérer un objet: "+l.getLoot());
	}
	
	
	
	

}
