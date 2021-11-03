import java.util.Comparator;

/**
 * Compare terms using different comparison orders (lexicographic, 
 * descending order of weight, lexicographic using the first length
 * characters of the query string).
 *
 * @author Christina Liu
 * @version 2/6/2021
 */



public class Term implements Comparable<Term> {

   // fields
   private final String query;
   private final long weight;

   /**
    * Initialize a term with the given query and weight.
    * This method throws a NullPointerException if query is null,
    * and an IllegalArgumentException if weight is negative.
    * @param query - search term.
    * @param weight - weight of the term.
    * @throws NullPointerException when query is null.
    * @throws IllegalArgumentException when weight is negative.
    */
   public Term(String query, long weight) {
      // exceptions
      if (query == null)   {
         throw new NullPointerException("Query cannot be null.");
      }
      if (weight < 0)   {
         throw new IllegalArgumentException("Weight cannot be negative.");
      }
      
      // initialize
      this.query = query;
      this.weight = weight;      
   }

   /**
    * Compares the two terms in descending order of weight.
    * @return descending weight order.
    */
   public static Comparator<Term> byDescendingWeightOrder() {
      return new DescendingWeightOrder();      
   }
   
   // descending weight order
   private static class DescendingWeightOrder implements Comparator<Term>  {
      public int compare(Term t1, Term t2)  {
         if (t1.weight < t2.weight)   {
            return 1;
         }
         else if (t1.weight > t2.weight)  {
            return -1;
         }
         else  {
            return 0;
         }
      }
   }

   /**
    * Compares the two terms in ascending lexicographic order of query,
    * but using only the first length characters of query. This method
    * throws an IllegalArgumentException if length is less than or equal
    * to zero.
    * @param length - first length characters of query to compare.
    * @return ascending prefix order.
    * @throws IllegalArgumentException when length is less than or 
    * equal to 0.
    */
   public static Comparator<Term> byPrefixOrder(int length) {
      // exception
      if (length <= 0)   {
         throw new IllegalArgumentException("Length must be greater than 0.");
      }
      return new AscendingPrefixOrder(length);      
   }
   
   // ascending prefix order
   private static class AscendingPrefixOrder implements Comparator<Term>   {
      private final int length;
      public AscendingPrefixOrder(int length)   {
         this.length = length;
      }
      
      // compare method
      public int compare(Term t1, Term t2)   {
         String q1;
         String q2;
         if (t1.query.length() < length)  {
            q1 = t1.query;
         }
         else  {
            q1 = t1.query.substring(0, length);
         }
         
         if (t2.query.length() < length)  {
            q2 = t2.query;
         }
         else  {
            q2 = t2.query.substring(0, length);
         }
         return q1.compareTo(q2);
      }
   } 
   

   /**
    * Compares this term with the other term in ascending lexicographic order
    * of query.
    */
   @Override
   public int compareTo(Term other) {
      return this.query.compareTo(other.query);
   }

   /**
    * Returns a string representation of this term in the following format:
    * query followed by a tab followed by weight
    */
   @Override
   public String toString()   {
      return query + "\t" + weight;
   }

}