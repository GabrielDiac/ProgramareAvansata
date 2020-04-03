import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Board {
    int sizeBoard;
    List<Token> listToken = new ArrayList<Token>();

    public Board(int sizeBoard) {
        this.sizeBoard = sizeBoard;
        for (int i = 0; i < sizeBoard; i++) {
            this.listToken.add(new Token(i));
        }
        System.out.println("Lista:");
        Collections.shuffle(this.listToken);
        /*for (int i = 0; i < listToken.size(); i++) {
            System.out.println(listToken.get(i));*/
        for (Token token : listToken ) {
            System.out.println(token.getValoareToken());
        }

        //listToken.forEach(System.out::println);
    }

    public void setListToken(List<Token> listToken) {
        this.listToken = listToken;
    }

    public void printBoard() {
        System.out.print("INcepem ");
        for (Token token : listToken) {
            System.out.println(token.getValoareToken());
        }
        System.out.print("Terminat ");
    }
    public int getSizeBoard() {
        return sizeBoard;
    }

    public void setSizeBoard(int sizeBoard) {
        this.sizeBoard = sizeBoard;
    }

    public List<Token> getListToken() {
        return listToken;
    }
}
