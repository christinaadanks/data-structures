import java.util.Comparator;

/*
 * Binary search methods to find the first and last key.
 *
 * @author Christina L
 * @version 2/6/2021
 */

public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    * @param a - array to search.
    * @param key - search key.
    * @param comparator - comparison order.
    * @return index of first occurrence of key.
    * @throws NullPointerException if any parameters are null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, 
                                          Comparator<Key> comparator) {
      // exceptions
      if (a == null | key == null | comparator == null)  {
         throw new NullPointerException("Parameters cannot be null.");
      }
      
      int left = 0;
      int right = a.length - 1;
      if (comparator.compare(key, a[0]) == 0)  {
         return 0;
      }
      while (left <= right)   {
         int middle = (left + right) / 2;
         
         if (comparator.compare(key, a[middle]) < 0)  {
            right = middle - 1;
         }
         else if (comparator.compare(key, a[middle]) > 0)   {
            left = middle + 1;
         }
         else if (comparator.compare(key, a[middle]) == 0 
                     && comparator.compare(a[middle - 1], a[middle]) == 0)  {
            right = middle - 1;
         }
         else  {
            return middle;
         }
      }
      return -1;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    * @param a - array to search.
    * @param key - search key.
    * @param comparator - comparison order.
    * @return index of last occurrence of key.
    * @throws NullPointerException if any parameters are null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, 
                                          Comparator<Key> comparator) { 
      // exceptions
      if (a == null | key == null | comparator == null)  {
         throw new NullPointerException("Parameters cannot be null.");
      }
      
      int left = 0;
      int right = a.length - 1;
      if (comparator.compare(key, a[right]) == 0)  {
         return right;
      }
      while (left <= right)   {
         int middle = (left + right) / 2;
         
         if (comparator.compare(key, a[middle]) < 0)   {
            right = middle - 1;
         }
         else if (comparator.compare(key, a[middle]) > 0)   {
            left = middle + 1;
         }
         else if (comparator.compare(key, a[middle]) == 0 
                     && comparator.compare(a[middle + 1], a[middle]) == 0) {
            left = middle + 1;           
         }
         else  {
            return middle;
         }
      }
      return -1;                                            
   }
    
}
