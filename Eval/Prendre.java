package Eval;


public class Prendre extends Objet {

    private String description;
    private int itemSize;

    public Prendre(String description, int itemSize) {
    	super(description);
    	this.description = description;
    	this.itemSize = itemSize;
    }
    
    public Prendre(String itemName) {
      	this.description = itemName;
    }

    

    public String getItemName() {return description;}

}