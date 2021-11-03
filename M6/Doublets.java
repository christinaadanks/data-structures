import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author CHRISTINA LIU (CZL0144@auburn.edu)
 * @author Dean Hendrix (dh@auburn.edu)
 *
 * @version 2/26/2021
 */
public class Doublets implements WordLadderGame {

   // The word list used to validate words.
   // Must be instantiated and populated in the constructor.
   // FIELDS
   private TreeSet<String> lexicon;
    


   /**
    * Instantiates a new instance of Doublets with the lexicon populated with
    * the strings in the provided InputStream. The InputStream can be formatted
    * in different ways as long as the first string on each line is a word to be
    * stored in the lexicon.
    */
   public Doublets(InputStream in) {
      try {
         lexicon = new TreeSet<String>(); // instantiate lexicon object
         
         Scanner s =
            new Scanner(new BufferedReader(new InputStreamReader(in)));
         while (s.hasNext()) {
            String str = s.next();
            lexicon.add(str.toLowerCase()); // store str in lexicon
            s.nextLine();
         }
         in.close();
      }
      catch (java.io.IOException e) {
         System.err.println("Error reading from InputStream.");
         System.exit(1);
      }
   }


   //////////////////////////////////////////////////////////////
   // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
   //////////////////////////////////////////////////////////////
 
   /**
    * Returns the Hamming distance between two strings, str1 and str2. The
    * Hamming distance between two strings of equal length is defined as the
    * number of positions at which the corresponding symbols are different. The
    * Hamming distance is undefined if the strings have different length, and
    * this method returns -1 in that case. See the following link for
    * reference: https://en.wikipedia.org/wiki/Hamming_distance
    *
    * @param  str1 the first string
    * @param  str2 the second string
    * @return      the Hamming distance between str1 and str2 if they are the
    *                  same length, -1 otherwise
    */
   public int getHammingDistance(String str1, String str2)   {
   
      // EXCEPTION: string lengths are not equal
      if (str1.length() != str2.length()) {
         return -1;
      }
      
      str1 = str1.toLowerCase();
      str2 = str2.toLowerCase();
      
      int ham = 0;
      for (int i = 0; i < str1.length(); i++)  {
         if (str1.charAt(i) != str2.charAt(i))  {
            ham++;   // increase when characters are different
         }
      }
      return ham;
   }
    
   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
   public List<String> getMinLadder(String start, String end)   {
      List<String> empty = new ArrayList<>();
      List<String> minLadder = new ArrayList<String>();
      start = start.toLowerCase();
      end = end.toLowerCase();
      
      // EXCEPTION: null
      if (start == null || end == null) {
         return empty;
      }
      
      // EXCEPTION: word isn't a word
      if (!isWord(start) || !isWord(end)) {
         return empty;
      }
      
      // EXCEPTION: word lengths are different
      if (getHammingDistance(start, end) == -1) {
         return empty;
      }
      
      if (isWord(start) && isWord(end)) {
         minLadder = bfs(start, end); // breadth first search
      }
      return minLadder;
   }
   
   /**
    * BFS search method.
    *
    */
   private List<String> bfs(String start, String end) {
      start = start.toLowerCase();
      end = end.toLowerCase();
      List<String> empty = new ArrayList<>();
      List<String> list = new ArrayList<String>();
      List<String> ladder = new ArrayList<String>();
      TreeSet<String> visited = new TreeSet<String>();
      Deque<Node> queue = new ArrayDeque<Node>();
      String word;
      
      if (start.equals(end))  {
         ladder.add(start);
         return ladder; // start and end are same word
      }
      
      Node startNode = new Node(start);
      visited.add(start);
      queue.add(startNode);
      
      while (!queue.isEmpty())   {
         Node n = queue.removeFirst(); 
         word = n.word;
         
         List<String> neighbors = getNeighbors(word);
         for (String neighbor : neighbors)   {
            if (!visited.contains(neighbor)) {
               Node nNode = new Node(neighbor, n);
               visited.add(neighbor);
               queue.addLast(nNode);
            
               if (neighbor.equals(end))  {
                  Node prev = nNode.next;
                  word = nNode.word;
                  list.add(word);
                  while(prev != null)  {
                     word = prev.word;
                     list.add(0, word);
                     prev = prev.next;
                  }
                  return list;
               }
            }
         }
      }
      return empty;
   }
   
   /**
    * Returns all the words that have a Hamming distance of one relative to the
    * given word.
    *
    * @param  word the given word
    * @return      the neighbors of the given word
    */
   public List<String> getNeighbors(String word) {
      word = word.toLowerCase();
      List<String> empty = new ArrayList<>();
      List<String> neighbors = new ArrayList<String>();
      
      for (String testWord : lexicon) {   // add neighbors of word
         if (getHammingDistance(word, testWord) == 1)   {
            neighbors.add(testWord);
         }
      }
      
      // EXCEPTION: no neighbors
      if (neighbors.isEmpty())   {
         return empty;
      }
      
      return neighbors;
   }

   /**
    * Returns the total number of words in the current lexicon.
    *
    * @return number of words in the lexicon
    */
   public int getWordCount()   {
      return lexicon.size();  // words in lexicon
   }

   /**
    * Checks to see if the given string is a word.
    *
    * @param  str the string to check
    * @return     true if str is a word, false otherwise
    */
   public boolean isWord(String str) {
      str = str.toLowerCase();
      if (lexicon.contains(str)) {  // check lexicon for word
         return true;
      }
      return false;
   }

   /**
    * Checks to see if the given sequence of strings is a valid word ladder.
    *
    * @param  sequence the given sequence of strings
    * @return          true if the given sequence is a valid word ladder,
    *                       false otherwise
    */
   public boolean isWordLadder(List<String> sequence)  {
   
      // EXCEPTION: null or empty list
      if (sequence == null || sequence.isEmpty()) {
         return false;
      }
      
      int end = sequence.size() - 1;
      for (int i = 0; i < end; i++) {
         String w1 = sequence.get(i);
         String w2 = sequence.get(i + 1);
         if (!isWord(w1) || !isWord(w2))  {
            return false;
         }
         if (getHammingDistance(w1, w2) != 1)   {
            return false;
         }
      }
      return true;
   }
   
   /**
    * Defines a node class.
    */
   private class Node   {
      String word;
      Node next;
      List<String> neighbors;
      
      /**
       * Instantiate Node.
       */
      public Node(String s)   {
         this.word = s;
         this.neighbors = getNeighbors(this.word);
      }
      
      /**
       * Instantiate node linking.
       */
      public Node(String s, Node nex) {
         this.word = s;
         this.next = nex;
         this.neighbors = getNeighbors(this.word);
      }
   }
   
}

