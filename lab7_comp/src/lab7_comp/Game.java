package lab7_comp;

public class Game {

    private Board board;//pentru fiecare joc fac un obiect de tip board

   
	public Game(Board board) {
		super();
		this.board = board;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}
    
}
