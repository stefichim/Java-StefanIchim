package lab7_comp;

public class Token {

	  private int number;
	  private boolean blank;//poate sa fie true sau false
	
	  //------getters and setters  
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public boolean isBlank() {
		return blank;
	}
	public void setBlank(boolean blank) {
		this.blank = blank;
	}
	
	//----constructor
	public Token(int number, boolean blank) {
		super();
		this.number = number;
		this.blank = blank;
	}
	  
}
