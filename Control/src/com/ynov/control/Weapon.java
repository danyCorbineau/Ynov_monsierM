package com.ynov.control;

public class Weapon {
	private String name;
	private WeaponType type;
	private int damages;
	
	public Weapon(String name, WeaponType type, int damage)
	{
		this.name=name;
		this.type=type;
		this.damages=damage;
	}

	public String getName() {
		return name;
	}

	public WeaponType getType() {
		return type;
	}

	public int getDamages() {
		return damages;
	}
	
	
	

}
