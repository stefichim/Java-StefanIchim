package lab7_comp;

import java.util.ArrayList;
import java.util.List;

public class Board {

	  private List<Token> tokens = new ArrayList<>();//lista de tokens
	  
	  public Board(int n)//n este dimnesiunea tablei
	    {
	        for(int i = 1; i <= n; i++)
	        {
	            tokens.add(new Token(i, true));
	        }
	    }

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}

	public Board(List<Token> tokens) {
		super();
		this.tokens = tokens;
	}
	  
	  
}
