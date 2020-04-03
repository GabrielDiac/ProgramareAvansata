import java.util.*;

public class Main {

    public static void main(String[] args)  throws InterruptedException{






            Board board = new Board(11);
            Player player1=new Player("Ion",board,1);
            Player player2=new Player("Marian",board,0);
            player1.setOpponent(player2);
            player2.setOpponent(player1);

            Game game = new Game(board,player1,player2);
            game.startGame();

       game.showT();
    }
}
