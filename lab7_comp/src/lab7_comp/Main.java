package lab7_comp;

public class Main {

	public static void main(String[] args) {
		//Board board = new Board(15);//am setat dimensiunea tablei
		Token t1=new Token(1,false);
        Token t2=new Token(2,false);
        Token t3=new Token(3,false);
        Token t4=new Token(4,false);
        Token t5=new Token(5,false);
        Board board=new Board(4);
        board.addToken(t1);
        board.addToken(t2);
        board.addToken(t3);
        board.addToken(t4);
        board.addToken(t5);
        Game g1;
        g1 = new Game(board);
       g1.startJoc();
	}

}
