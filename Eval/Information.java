package Eval;


public class Information extends Objet {
	
	private String description;

	
	
    public Information() {
    	if(listeResult.get(2) == "I" || listeResult.get(2) == "O"){
    		this.description = listeResult.get(3);    		
    	}
    	
    	
    }


    public String getDescription() {return description;}

}