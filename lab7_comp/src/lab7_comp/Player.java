package lab7_comp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;


public class Player implements Runnable {

    private final String name;
    private boolean ok = true;
    public static Board board;
    public static volatile int indicativPlayer=0;  
    public static volatile int randJucator=1;
    List<Token> tokenPlayer = new ArrayList<>();
    static List<Token> list;
    public Player(String name) {

        this.name = name;
    }

    static void setBoard(Board board) {
        Player.board = board;
        Player.list=Collections.synchronizedList(board.tokens);
    }

    @Override

    public void run() {
        indicativPlayer++;
       
        int nrPlayer=indicativPlayer;
        while (ok) {
                
                synchronized(list)
                        {   if(nrPlayer==randJucator)
                        {if (list.isEmpty()) {
                    System.out.println("Totii playeri au castigat");
                    System.exit(0);

                }
                Random rand = new Random();
                int i = rand.nextInt(list.size());
                while (i == 0) {
                    i = rand.nextInt(list.size());
                }
                Token t1 = list.get(i);

                tokenPlayer.add(t1);
                System.out.println("Playerul " + randJucator + " a ales " + list.get(i).getNumber());
                if (list.get(i).getNumber() > board.number) {
                    ok = false;
                    System.out.println("Playerul " + randJucator + " a castigat");
                    System.exit(0);
                }
                list.remove(i);
                if(randJucator==1)
                    randJucator=2;
                else
                if(randJucator==2)
                    randJucator=3;
                else
                if(randJucator==3)
                    randJucator=1;
                list.notifyAll();
                        }
                else    
                        try {
                            list.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                        }

        }
    }}

    @Override
    public String toString() {
        return "Player{" + "name=" + name + '}';
    }

}
