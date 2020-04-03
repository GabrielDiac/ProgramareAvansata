import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable{
    String name;
    Board board;
    List<Token> listTokenPlayer = new ArrayList<Token>();
    int activation;
    Player opponent;


    public Player(String name, Board board,int act) {
        this.name = name;
        this.board = board;
        this.activation=act;

    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public  void extractToken()
    {
        Random rand = new Random();
        //int i = board.getSizeBoard()-1;
        Token temp;
        temp=board.getListToken().get(rand.nextInt(board.getListToken().size()));
        listTokenPlayer.add(temp);
        //System.out.println("Nrdeextars:");
        //System.out.println(temp.getValoareToken());
       // int pos =board.getListToken().indexOf(temp);
       /* for (Token token : board.getListToken() ) {
            if(token.getValoareToken()==temp.getValoareToken())
                board.getListToken().remove(temp);
        }*/
        List<Token> listTokenTemp = new ArrayList<Token>();
        for (Token token : board.getListToken() ) {
            if(token.getValoareToken()!=temp.getValoareToken())
                listTokenTemp.add(token);}
        board.setListToken(listTokenTemp);
      //  board.printBoard();
        board.setSizeBoard(board.getSizeBoard()-1);

        setActivation(0);
        opponent.setActivation(1);
    }

    public List<Token> getListTokenPlayer() {
        return listTokenPlayer;
    }

    public int getActivation() {
        return activation;
    }

    public void setActivation(int activation) {
        this.activation = activation;
    }

    public  void printerList()   {
        /*for(int i = 0; i < listTokenPlayer.size(); i++) {
            System.out.println(listTokenPlayer.get(i));*/
            System.out.println(this.name + " : ");
        for (Token token : listTokenPlayer ) {
            System.out.println(token.getValoareToken());
        }

    }
    @Override
    public void run()
    {synchronized (this) {
        try {
            while (board.getSizeBoard() !=0) {
                //System.out.println(activation);
                 if(getActivation()==1)
                extractToken();
                 else
                     Thread.sleep(10);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


}
