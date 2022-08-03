import java.util.Arrays;

/*
 * Program to provide complete autocomplete functionality for a
 * given set of strings and weights.
 *
 * @author Christina L
 * @version 2/6/2021
 */

public class Autocomplete {

   // fields
   private Term[] terms;

   /**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
    * @param terms - array to initialize.
    * @throws NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] terms) { 
      if (terms == null)   {
         throw new NullPointerException("Terms cannot be null.");
      }
      
      this.terms = new Term[terms.length];
      for (int i = 0; i < terms.length; i++) {
         this.terms[i] = terms[i];
      }
      Arrays.sort(this.terms);
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
    * @param prefix - prefix to search.
    * @throws NullPointerException if prefix is null.
    * @return array with terms that start with the given prefix.
	 */
	public Term[] allMatches(String prefix) { 
      if (prefix == null)  {
         throw new NullPointerException("Prefix cannot be null.");
      }
      
      int firstIndex = BinarySearch.firstIndexOf(terms, new Term(prefix, 0),
                  Term.byPrefixOrder(prefix.length()));
      
      if (firstIndex < 0) {
         return new Term[0];
      }
      
      int lastIndex = BinarySearch.lastIndexOf(terms, new Term(prefix, 0),
                  Term.byPrefixOrder(prefix.length()));
                  
      Term[] match = new Term[lastIndex - firstIndex + 1];
      for (int i = firstIndex; i <= lastIndex; i++) {
         match[i - firstIndex] = terms[i];
      }
      
      Arrays.sort(match, Term.byDescendingWeightOrder());
      
      return match;      
   
   }

}
