package Eval;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * 
 */
public class Danger {

	private String nom;
	private int pv;
	private int attaque;
	
    public Danger(String line) {
    	String[] temp=line.split(";");
    	
    	nom=temp[0];
    	pv=Integer.valueOf(temp[1]);
    	attaque=Integer.valueOf(temp[2]);
    	
    }
    
    public int attaquer()
    {
    	return this.attaque;
    }
    
    public void perdPv(int pv) throws DangerMeurtException
    {
    	this.pv-=pv;
    	if(pv<=0)
    		throw new DangerMeurtException(this);
    }
    
    
    public String toString()
    {
		return nom+" "+pv+" "+attaque;
    }
    public String getName()
    {
    	return this.nom;
    }
    
    public static List<Danger> loadDangers(String fName,List<Danger> dangers) throws FileNotFoundException
    {
    	DataInputStream dis = new DataInputStream(new FileInputStream(new File(fName)));
    	
    	try {
    		String s;
    		while((s=dis.readLine())!=null)
			{
    			dangers.add(new Danger(s));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	
    	try {
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return dangers;
    }
    


}