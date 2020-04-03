import java.util.ArrayList;
import java.util.List;

public class Game {
    Board board;
    //List<Player> listPlayer = new ArrayList<Player>();
   // List<Token> secundar = new ArrayList<Token>();
    Player player1;
    Player player2;
    //listPlayer.add(player1);
    //listPlayer.add(player2);

    public Game(Board board,Player player1,Player player2) {
        this.board = board;
        this.player1=player1;
        this.player2=player2;


      //  player1.printerList();
    }
    public void startGame() throws InterruptedException
    {
        Thread t1 = new Thread(player1);
        Thread t2 = new Thread(player2);
        //  player1.printerList();
        t1.start();
        Thread.sleep(10);
        t2.start();
        t1.join();
        t2.join();
        //showT();
    }
    public void showT()
    {
        this.player1.printerList();
        this.player2.printerList();
    }



}
