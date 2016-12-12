package com.ynov.control;

public class Monster implements Lootable{
	private String name;
	private int damages;
	private int hp;
	
	public Monster(String name, int pv, int damage)
	{
		this.name=name;
		this.hp=pv;
		this.damages=damage;
	}

	public String getName() {
		return name;
	}

	public int getDamages() {
		return damages;
	}

	public int getHp() {
		return hp;
	}
	
	public void describe()
	{
		System.out.println("Je suis un "+this.getName()+" ("+this.getHp()+" HP) et je peux faire jusqu'à "+this.getDamages()+" dégats.");
	}
	
	/*
	 * partie 3
	 */
	
	public void looseHp(int v)
	{
		this.hp-=v;
		if(this.getHp()<0)
			this.hp=0;
	}
	

	/*
	 * Partie 4
	 */
	
	@Override
	public String getLoot() {
		return "Morceau de cuir";
	}
	
	

}
