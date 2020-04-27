package lab7_comp;

import java.util.ArrayList;
import java.util.List;

public class Board {

	 static List<Token> tokens = new ArrayList<>();//lista de tokens
	 int number; 
	 
	 public void addToken(Token x) {//functie cu care adaug token-uri pe board
		 tokens.add(x);
	 }
	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Board(int numar) {
		super();
		this.number = numar;
	}
	  
	  
}
