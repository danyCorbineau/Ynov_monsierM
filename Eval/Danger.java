package Eval;
import java.util.*;

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


}