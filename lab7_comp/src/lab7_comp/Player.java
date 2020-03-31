package lab7_comp;

import java.util.ArrayList;
import java.util.List;

public class Player implements Runnable {

	  private String name;
	  private List<Token> tokens = new ArrayList<>();
	
	
	static void printAP(int a, int d, int n)  { //metoda care calculeaza progresia aritmetica
	 
		int curentTerm; 
		curentTerm=a; 
		for (int i = 1; i <= n; i++)  {
			System.out.print(curentTerm + " "); 
		 curentTerm =curentTerm + d; 
		}
	} 
	public Player(String name, List<Token> tokens) {
		super();
		this.name = name;
		this.tokens = tokens;
	}
	
	
	
			@Override
	public void run() {
			// TODO Auto-generated method stub
			
	}	
	public String getName() {
			return name;
		}
	public void setName(String name) {
			this.name = name;
		}
	
	
	
	public List<Token> getTokens() {
			return tokens;
		}
	
	
	
	public void setTokens(List<Token> tokens) {
			this.tokens = tokens;
		}
}
