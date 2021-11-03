import java.util.SortedSet;
import java.util.TreeSet;
public class ExampleGameClient {

    public static void main(String[] args) {
       WordSearchGame game = WordSearchGameFactory.createGame();
       game.loadLexicon("words.txt");
       game.setBoard(new String[]{"I"});
       System.out.print("LENT is on the board at the following positions: ");
       System.out.println(game.isOnBoard("I"));
       System.out.print("POPE is not on the board: ");
       System.out.println(game.isOnBoard("POPE"));
       System.out.println("All words of length 6 or more: ");
       System.out.println(game.getAllScorableWords(4));
       SortedSet<String> words = game.getAllScorableWords(4);
       System.out.println(game.getScoreForWords(words, 4));
       System.out.println(game.getBoard());
    }
}