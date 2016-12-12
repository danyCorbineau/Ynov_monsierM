package Eval;

public class DangerMeurtException extends Exception{
	
	
	DangerMeurtException(Danger d)
	{
		super("Danger "+d.getName());
	}

}
