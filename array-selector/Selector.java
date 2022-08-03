import java.util.Arrays;

/**
* Defines a library of selection methods
* on arrays of ints.
*
* @author   Christina L
* @author   Dean Hendrix 
* @version  1/22/2021
*
*/
public final class Selector {

   /**
    * Can't instantiate this class.
    *
    * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a for Array.
    * @return minimum value of array.
    * @throws IllegalArgumentException for a == null or a.length == 0.
    */
   public static int min(int[] a) {
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      
      // select minimum value
      int min = a[0];
      for (int i = 0; i < a.length; i++)  {
         if (a[i] < min)   {
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. This method
    * throws IllegalArgumentException if a is null or has zero
    * length. The array a is not changed by this method.
    * @param a for Array.
    * @return maximum value in array.
    * @throws IllegalArgumentException for a == null or a.length == 0.
    */
   public static int max(int[] a)   {
   
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      
      // select maximum value
      int max = a[0];
      for (int i = 0; i < a.length; i++)  {
         if (a[i] > max)   {
            max = a[i];
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth minimum value. Note that there is no kth
    * minimum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a for Array.
    * @param k for k-1 distinct values less than kmin in array.
    * @return kth minimum value.
    * @throws IllegalArgumentException for a == null, 
    * a.length == 0, or no kth min value.
    */
   public static int kmin(int[] a, int k) {
   
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("There is no kth "
         + "minimum value in array.");
      }
      
      // copy & sort array
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      
      // solve for kmin. 
      int last = b.length - 1;
      int uniqueNum = 1;
      int kmin = 0;
      if (k == 1) {
         kmin = min(a);
      }
      for (int i = 0; i < last; i++)  {
         if (b[i] != b[i + 1])   {
            uniqueNum++;
            if (uniqueNum == k)  {
               kmin = b[i + 1]; // based off mapped calculations
            } 
         }
      }
      
      // exceptions
      if (k > uniqueNum)   {
         throw new IllegalArgumentException("k must be less "
            + "than or equal to the number of distinct integers.");
      }
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. This method
    * throws IllegalArgumentException if a is null, has zero length,
    * or if there is no kth maximum value. Note that there is no kth
    * maximum value if k < 1, k > a.length, or if k is larger than
    * the number of distinct values in the array. The array a is not
    * changed by this method.
    * @param a for Array.
    * @param k for k-1 distinct values greater than kmax in array.
    * @return kth maximum value.
    * @throws IllegalArgumentException for a == null, 
    * a.length == 0, or no kth max value.
    */
   public static int kmax(int[] a, int k) {
   
      // exceptions
      if (a == null || a.length < 0)   {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException("There is no kth "
            + "maximum value in array.");
      }
      
      // copy & sort array
      int[] b = Arrays.copyOf(a, a.length);
      Arrays.sort(b);
      
      // solve for kmax
      int last = b.length - 1;
      int uniqueNum = 1;
      int kmax = 0;
      if (k == 1)   {
         kmax = max(a);
      }
      
      for (int i = last; i > 0; i--)   {
         if (b[i] != b[i - 1])   {
            uniqueNum++;
            if (uniqueNum == k)  {
               kmax = b[i - 1];
            }
         }
      }      
      
      // exceptions
      if (k > uniqueNum)   {
         throw new IllegalArgumentException("k must be less "
            + "than or equal to the number of distinct integers.");
      }      
      return kmax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range [low..high]; that is, all the values that are greater
    * than or equal to low and less than or equal to high,
    * including duplicate values. The length of the returned array
    * is the same as the number of values in the range [low..high].
    * If there are no qualifying values, this method returns a
    * zero-length array. Note that low and high do not have
    * to be actual values in a. This method throws an
    * IllegalArgumentException if a is null or has zero length.
    * The array a is not changed by this method.
    * @param a for Array.
    * @param low for low point of range.
    * @param high for high point of range.
    * @return range asn array of low and high values.
    * @throws IllegalArgumentException for a == null or a.length == 0.
    */
   public static int[] range(int[] a, int low, int high) {
   
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
            
      // get length of range array
      int rLength = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] >= low && a[i] <= high) {
            rLength++;
         }
      }
      
      // create new range array
      int[] range = new int[rLength];
      
      // zero length array
      if (rLength == 0) {
         return range;
      }
      
      // range array
      int r = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] >= low && a[i] <= high) {
            range[r] = a[i];
            r++;
         }
      }    
      return range;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a for Array.
    * @param key for integer to find ceiling of.
    * @return ceiling of key.
    * @throws IllegalArgumentException for a == null, 
    * a.length == 0, or no ceiling.
    */
   public static int ceiling(int[] a, int key) {
   
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      
      // get length of ceiling array
      int cLength = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] >= key)  {
            cLength++;
         }
      }
      
      // create new ceiling array
      int[] ceiling = new int[cLength];
      
      // exceptions
      if (cLength == 0) {
         throw new IllegalArgumentException("No ceiling value found.");
      }
      
      // add values to ceiling array & return minimum value of ceiling array
      int c = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] >= key)  {
            ceiling[c] = a[i];
            c++;
         }
      }
      return min(ceiling);
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. This method throws an IllegalArgumentException if
    * a is null or has zero length, or if there is no qualifying
    * value. Note that key does not have to be an actual value in a.
    * The array a is not changed by this method.
    * @param a for Array.
    * @param key for integer to find floor of.
    * @return floor of key.
    * @throws IllegalArgumentException for a == null, 
    * a.length == 0, or no floor.
    */
   public static int floor(int[] a, int key) {
   
      // exceptions
      if (a == null || a.length == 0)  {
         throw new IllegalArgumentException("Array cannot be null "
            + "and must have 1 or more integers.");
      }
      
      // get length of floor array
      int fLength = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] <= key)  {
            fLength++;
         }
      }
      
      // create new floor array
      int[] floor = new int[fLength];
      
      // exception
      if (fLength == 0) {
         throw new IllegalArgumentException("No floor value found.");
      }
      
      // add values to floor array & return maximum value of floor array
      int f = 0;
      for (int i = 0; i < a.length; i++)  {
         if (a[i] <= key)  {
            floor[f] = a[i];
            f++;
         }
      }
      return max(floor);
   }

}
