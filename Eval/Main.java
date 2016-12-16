package p;

public class Main {

	public static void main(String[] args) {
		Menu m=new Menu();
		
		m.lancer();
		
	}
	
	public static void println(String s)
	{
	Main.print(s+"\n");
	}
	
	public static void print(String s)
	{
		System.out.print(s);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}







