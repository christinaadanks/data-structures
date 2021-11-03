import java.util.List;
import java.util.TreeSet;
import java.io.File;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.SortedSet;

/**
 * Program for a word search game.
 *
 * @author CHRISTINA LIU (czl0144@auburn.edu)
 * @version 2/19/2021
 */
 
public class BoggleWordGame implements WordSearchGame {

   // FIELDS
   private TreeSet<String> lexicon;
   private List<Integer> path;
   private List<Integer> allPath;
   private SortedSet<String> scoreWords;
   private boolean[][] visited;
   private boolean loaded = false;
   private int size;
   private int minLength;
   private String[][] board;   
   private static final String[] START_BOARD = {"E", "E", "C", "A",
                                                "A", "L", "E", "P",
                                                "H", "N", "B", "O",
                                                "Q", "T", "T", "Y"};
   
   /**
    * BoggleWordGame constructor.
    */
   public BoggleWordGame() {
      lexicon = new TreeSet<String>();
      path = new ArrayList<Integer>();
      allPath = new ArrayList<Integer>();
      scoreWords = new TreeSet<String>();
      size = 4;      
      setBoard(START_BOARD);
   }
   
   /**
    * Loads the lexicon into a data structure for later use. 
    * 
    * @param fileName A string containing the name of the file to be opened.
    * @throws IllegalArgumentException if fileName is null
    * @throws IllegalArgumentException if fileName cannot be opened.
    */
   public void loadLexicon(String fileName) {
      lexicon = new TreeSet<String>();      
      
      // EXCEPTION: null file
      if (fileName == null)   {
         throw new IllegalArgumentException("fileName is null.");
      }
      
      try   {
         Scanner file = new Scanner(new File(fileName));
         
         while (file.hasNext())  {
            String lexString = file.next();
            lexicon.add(lexString.toUpperCase()); // add to lexicon
            file.nextLine();
         }
         
         file.close();  // close file
      }
      
      // EXCEPTION: file cannot be opened
      catch (Exception e)  {
         throw new IllegalArgumentException("File cannot be opened.");
      }
      loaded = true;
   }
   
   /**
    * Stores the incoming array of Strings in a data structure that will make
    * it convenient to find words.
    * 
    * @param letterArray This array of length N^2 stores the contents of the
    *     game board in row-major order. Thus, index 0 stores the contents of board
    *     position (0,0) and index length-1 stores the contents of board position
    *     (N-1,N-1). Note that the board must be square and that the strings inside
    *     may be longer than one character.
    * @throws IllegalArgumentException if letterArray is null, or is  not
    *     square.
    */ 
   public void setBoard(String[] letterArray)  {
   
      // EXCEPTION: null array
      if (letterArray == null)   {
         throw new IllegalArgumentException("Array is null.");
      }
      
      // EXCEPTION: not square
      int b = (int) Math.sqrt(letterArray.length);
      if ((int) Math.pow(b, 2) !=  letterArray.length) {
         throw new IllegalArgumentException("Array is not square.");
      }
      
      board = new String[b][b];  // create board
      visited = new boolean[b][b];
      int index = 0;
      for (int i = 0; i < b; i++)  {
         for (int k = 0; k < b; k++) {
            board[i][k] = letterArray[index];
            index++;
         }
      }
      size = b;
   }
   
   /**
    * String representation of current board suitable for printing.
    * @return String representation of board.
    */
   public String getBoard()  {
      String boardStr = "| ";
      for (int i = 0; i < size; i++)   {
         if (i > 0)  {
            boardStr += "\n| ";
         }
         for (int k = 0; k < size; k++)   {
            boardStr += board[i][k] + " ";
         }
         boardStr += "|";
      }
      return boardStr;
   }
   
   /**
    * Retrieves all scorable words on the game board, according to the stated game
    * rules.
    * 
    * @param minimumWordLength The minimum allowed length (i.e., number of
    *     characters) for any word found on the board.
    * @return java.util.SortedSet which contains all the words of minimum length
    *     found on the game board and in the lexicon.
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */   
   public SortedSet<String> getAllScorableWords(int minimumWordLength)  {
      minLength = minimumWordLength;
      scoreWords.clear();
      
      // EXCEPTION: length < 1
      if (minimumWordLength < 1)   {
         throw new IllegalArgumentException("Minimum length is less than 1.");
      }
      
      // EXCEPTION: loadLexicon not called
      if (!loaded)  {
         throw new IllegalStateException("Lexicon not called.");
      }
      
      for (int i = 0; i < size; i++)   {
         for (int k = 0; k < size; k++)   {
            String wordSoFar = board[i][k];
            dfs2(i, k, wordSoFar);  // find words recursively
         }  
      }
      return scoreWords;
   }
      
 /**
   * Computes the cummulative score for the scorable words in the given set.
   * To be scorable, a word must (1) have at least the minimum number of characters,
   * (2) be in the lexicon, and (3) be on the board. Each scorable word is
   * awarded one point for the minimum number of characters, and one point for 
   * each character beyond the minimum number.
   *
   * @param words The set of words that are to be scored.
   * @param minimumWordLength The minimum number of characters required per word
   * @return the cummulative score of all scorable words in the set
   * @throws IllegalArgumentException if minimumWordLength < 1
   * @throws IllegalStateException if loadLexicon has not been called.
   */        
   public int getScoreForWords(SortedSet<String> words, int minimumWordLength)  {
      minLength = minimumWordLength;
      
      // EXCEPTION: length < 1
      if (minimumWordLength < 1) {
         throw new IllegalArgumentException("Minimum length is less than 1.");
      }
      
      // EXCEPTION: loadLexicon not called
      if (!loaded)  {
         throw new IllegalStateException("Lexicon not called.");
      }
      
      int score = 0;
      Iterator<String> itr = words.iterator();
      while (itr.hasNext())   {
         String word = itr.next();
         if (word.length() >= minLength && isValidWord(word) && !isOnBoard(word).isEmpty())  {
            score += (word.length() - minLength) + 1; 
         }  // score +1 for word & +1 for each char more than the min
      }
     
      return score;
   }
   
   /**
    * Determines if the given word is in the lexicon.
    * 
    * @param wordToCheck The word to validate
    * @return true if wordToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */ 
   public boolean isValidWord(String wordToCheck)  {
   
      // EXCEPTION: null word
      if (wordToCheck == null)   {
         throw new IllegalArgumentException("Invalid.");
      }
      
      // EXCEPTION: loadLexicon not called
      if (!loaded) {
         throw new IllegalStateException("Invalid.");
      }
      return lexicon.contains(wordToCheck.toUpperCase()); // check if word is in lexicon
   }
   
   /**
    * Determines if there is at least one word in the lexicon with the 
    * given prefix.
    * 
    * @param prefixToCheck The prefix to validate
    * @return true if prefixToCheck appears in lexicon, false otherwise.
    * @throws IllegalArgumentException if prefixToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */   
   public boolean isValidPrefix(String prefixToCheck) {
   
      // EXCEPTION: null prefix
      if (prefixToCheck == null) {
         throw new IllegalArgumentException("Invalid.");
      }
      
      // EXCEPTION: loadLexicon not called
      if (!loaded) {
         throw new IllegalStateException("Invalid.");
      }
      
      prefixToCheck = prefixToCheck.toUpperCase();
      String word = lexicon.ceiling(prefixToCheck);
      if (word != null) {  // check if at least one prefix is in lexicon
         return word.startsWith(prefixToCheck);
      }
      return false;      
   }
   
   /**
    * Determines if the given word is in on the game board. If so, it returns
    * the path that makes up the word.
    * @param wordToCheck The word to validate
    * @return java.util.List containing java.lang.Integer objects with  the path
    *     that makes up the word on the game board. If word is not on the game
    *     board, return an empty list. Positions on the board are numbered from zero
    *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
    *     board, the upper left position is numbered 0 and the lower right position
    *     is numbered N^2 - 1.
    * @throws IllegalArgumentException if wordToCheck is null.
    * @throws IllegalStateException if loadLexicon has not been called.
    */  
   public List<Integer> isOnBoard(String wordToCheck) {
   
      // EXCEPTION: null word
      if (wordToCheck == null)   {
         throw new IllegalArgumentException("Invalid.");
      }
      
      // EXCEPTION: loadLexicon not called
      if (!loaded) {
         throw new IllegalStateException("Invalid.");
      }

      path.clear();
      allPath.clear();  // remove all elements from lists
      
      for (int i = 0; i < size; i++) {
         for (int k = 0; k < size; k++) {
            if (wordToCheck.startsWith(board[i][k]))   {
               int element = k + (i * size);
               path.add(element);
               String wordSoFar = board[i][k];
               dfs(i, k, wordToCheck, wordSoFar);  // find word recursively
               if (!allPath.isEmpty()) {
                  return allPath;
               }
               path.clear();
               allPath.clear();  // remove all elements from lists
            }
         }
      }
      return path;
   }
   
   /**
    * Recursive depth first search for isOnBoard.
    *
    * @param x - x value.
    * @param y - y value.
    * @param wordToCheck - word to check for.
    * @param wordSoFar - state of the word so far in the search.
    */
    
   private void dfs(int x, int y, String wordToCheck, String wordSoFar) {                                  
      visited[x][y] = true;
      wordSoFar = wordSoFar.toUpperCase();
      int end = size - 1;
      
      // EXCEPTION: prefix not found in lexicon
      if (!(isValidPrefix(wordSoFar))) {
         return;
      }         
      
      if (wordSoFar.equals(wordToCheck)) {
         allPath = new ArrayList<Integer>(path);
         return;
      }
      
      for (int i = -1; i <= 1; i++) {
         for (int k = -1; k <= 1; k++) {
            if (wordSoFar.equals(wordToCheck)) {
               return;
            }
            if ((x + i) <= (end) && (x + i) >= 0
               && (y + k) <= (end) && (y + k) >= 0
               && !visited[x + i][y + k]) {
               
               visited [x + i][y + k] = true;
               int element = (x + i) * size + y + k;
               path.add(element);
               dfs(x + i, y + k, wordToCheck, wordSoFar + board[x + i][y + k]);
               path.remove(path.size() - 1);
               visited[x + i][y + k] = false;             
            }
         }
      }
      visited[x][y] = false;
      return;                              
   }
   
   /**
    * Recursive depth first search for getAllScorableWords.
    *
    * @param x - x value.
    * @param y - y value.
    * @param minWords - words to check for that are valid words & greater than the
    *    minimum length.
    */
   private void dfs2(int x, int y, String minWords)   {
      visited[x][y] = true;
      int end = size - 1;
      minWords = minWords.toUpperCase();
      
      // EXCEPTION: prefix not found in lexicon
      if (!isValidPrefix(minWords)) {
         return;
      }
      
      if (isValidWord(minWords) && minWords.length() >= minLength) {
         scoreWords.add(minWords); // add if word meets all criteria
      } 
      
      for (int i = -1; i <= 1; i++) {
         for (int k = -1; k <= 1; k++) {
            if ((x + i) <= (end) && (x + i) >= 0
               && (y + k) <= (end) && (y + k) >= 0
               && !visited[x + i][y + k]) {
               visited [x + i][y + k] = true;
               dfs2(x + i, y + k, minWords + board[x + i][y + k]);
               visited[x + i][y + k] = false;      
            }
         }
      }
      visited[x][y] = false;
   }
   
}

   