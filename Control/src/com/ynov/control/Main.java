package com.ynov.control;

public class Main {

	public static void main(String[] args) {
		
		
		/*
		 * Partie 2
		 */
		
		/*
		 * create all instance
		 */
		Weapon epee = new Weapon("Epée", WeaponType.MELEE, 13),
				baton =  new Weapon("Baton", WeaponType.MAGICAL, 23);
		
		Player conan = new Player("Conan", 200),
				gandalf = new Player("Gandalf", 120),
				noob = new Player("Noob", 0);
		
		Monster loup = new Monster("Loup", 70, 20),
				dragon = new Monster("Dragon", 170, 100);
		
		Chest coffre = new Chest(); // Partie 4
		
		Shop magasin = new Shop(); // Partie 5
		
		/*
		 * set data
		 */
		conan.setWeapon(epee);
		conan.setXp(13);
		
		gandalf.setWeapon(baton);
		gandalf.setXp(25);
		
		noob.setXp(0);
		
		/*
		 * describe player and monsters
		 */
		try {
			conan.describe();
		} catch (PlayerDeadExeption e1) {
			System.out.println(conan.getName()+" est mort!!! Il ne peut plus se décrire.");
		}
		try {
			gandalf.describe();
		} catch (PlayerDeadExeption e) {
			System.out.println(gandalf.getName()+" est mort!!! Il ne peut plus se décrire.");
		}
		
		try {
			noob.describe();
		} catch (PlayerDeadExeption e) {
			System.out.println(noob.getName()+" est mort!!! Il ne peut plus se décrire.");
		}
		
		loup.describe();
		dragon.describe();
		
		/*
		 * Partie 3 players attack
		 */
		gandalf.attaquer(loup);
		conan.attaquer(dragon);
		
		/*
		 * Partie 4 conan loot a chest
		 */
		conan.looter(coffre);
		
		/*
		 * Partie 5 the shop
		 */
		magasin.addItemToShop("Armure", 50);
		magasin.addItemToShop("Potion", 10);
		magasin.addItemToShop("Chaval", 200);
		
		for( String s : magasin.getItemsCheaperThan(100))
			System.out.println("Pour moins de 100€, je peut avoir: "+s);
		
		
	}

}
