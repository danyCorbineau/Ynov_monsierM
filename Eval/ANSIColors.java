package p;

public enum ANSIColors {
	
	ANSI_RESET ("\u001B[0m"),
	ANSI_RED ("[r=255,g=0,b=0]"),
	ANSI_GREEN ("\u001B[32m"),
	ANSI_YELLOW ("\u001B[33m"),
	ANSI_BLUE ("\u001B[34m"),
	ANSI_PURPLE ("\u001B[35m"),
	ANSI_CYAN ("\u001B[36m");
	
	private String ansiCode;
	
	ANSIColors(String ansiCode){
		this.ansiCode = ansiCode;
	}
	public String toString() {return ansiCode;}
	}

