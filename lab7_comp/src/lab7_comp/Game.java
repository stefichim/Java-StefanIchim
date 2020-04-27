package lab7_comp;

public class Game {

    private Board board;//pentru fiecare joc fac un obiect de tip board

   
	public Game(Board board) {
		super();
		this.board = board;
	}

	public void startJoc() {
		Player player1=new Player("PLAYER1");
        Player player2=new Player("PLAYER2");
        Player player3=new Player("PLAYER3");
       
        Player.setBoard(board);
        Thread t1=new Thread(player1);
        Thread t2=new Thread(player2);
        Thread t3=new Thread(player3);
        t1.start();
        t2.start();
        t3.start();
	}
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
    
}
