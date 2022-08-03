import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  CHRISTINA L (czl0144@auburn.edu)
 * @version 1/30/2021
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
    * Returns the minimum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the minimum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T min(Collection<T> coll, Comparator<T> comp) {
   
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      
      // find min
      Iterator<T> itr = coll.iterator();
      T min = itr.next();
      if (itr.hasNext())   {
         for (T item : coll)   {
            if (comp.compare(item, min) < 0)  {
               min = item;
            }
         }
      }          
      return min;
   }


   /**
    * Selects the maximum value in the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty, this method throws a
    * NoSuchElementException. This method will not change coll in any way.
    *
    * @param coll    the Collection from which the maximum is selected
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T max(Collection<T> coll, Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      
      // find max
      Iterator<T> itr = coll.iterator();
      T max = itr.next();
      if (itr.hasNext())   {
         for (T item : coll)   {
            if (comp.compare(item, max) > 0)  {
               max = item;
            }
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth minimum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth minimum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the kth minimum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      if (k < 1 || k > coll.size()) {
         throw new NoSuchElementException("There is no kth "
            + "minimum value in array.");
      }
      
      // sort collection
      ArrayList<T> list = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      for (T item : coll)  {
         list.add(item);
      }
      java.util.Collections.sort(list, comp);
      
      // solve for kmin
      int last = list.size() - 1;
      int uniqueNum = 1;
      T kmin = null;
      if (k == 1) {
         kmin = min(coll, comp);
      }
      for (int i = 0; i < last; i++)  {
         if (!list.get(i).equals(list.get(i + 1)))  {
            uniqueNum++;
            if (uniqueNum == k)  {
               kmin = list.get(i + 1); // based off mapped calculations
            } 
         }
      }      
      
      // exceptions
      if (k > uniqueNum)   {
         throw new NoSuchElementException("k must be less "
            + "than or equal to the number of distinct integers.");
      }
      return kmin;
   }


   /**
    * Selects the kth maximum value from the Collection coll as defined by the
    * Comparator comp. If either coll or comp is null, this method throws an
    * IllegalArgumentException. If coll is empty or if there is no kth maximum
    * value, this method throws a NoSuchElementException. This method will not
    * change coll in any way.
    *
    * @param coll    the Collection from which the kth maximum is selected
    * @param k       the k-selection value
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the kth maximum value in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      if (k < 1 || k > coll.size()) {
         throw new NoSuchElementException("There is no kth "
            + "minimum value in array.");
      }
      
      // sort collection
      ArrayList<T> list = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      for (T item : coll)  {
         list.add(item);
      }
      java.util.Collections.sort(list, comp);
      
      // solve for kmin
      int last = list.size() - 1;
      int uniqueNum = 1;
      T kmax = null;
      if (k == 1) {
         kmax = max(coll, comp);
      }
      for (int i = last; i > 0; i--)  {
         if (!list.get(i).equals(list.get(i - 1)))  {
            uniqueNum++;
            if (uniqueNum == k)  {
               kmax = list.get(i - 1); // based off mapped calculations
            } 
         }
      }      
      
      // exceptions
      if (k > uniqueNum)   {
         throw new NoSuchElementException("k must be less "
            + "than or equal to the number of distinct integers.");
      }
      return kmax;
   }


   /**
    * Returns a new Collection containing all the values in the Collection coll
    * that are greater than or equal to low and less than or equal to high, as
    * defined by the Comparator comp. The returned collection must contain only
    * these values and no others. The values low and high themselves do not have
    * to be in coll. Any duplicate values that are in coll must also be in the
    * returned Collection. If no values in coll fall into the specified range or
    * if coll is empty, this method throws a NoSuchElementException. If either
    * coll or comp is null, this method throws an IllegalArgumentException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the range values are selected
    * @param low     the lower bound of the range
    * @param high    the upper bound of the range
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        a Collection of values between low and high
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                   Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
            
      // create range array
      ArrayList<T> range = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      
      for (T item : coll)  {
         if (comp.compare(item, low) >= 0 && comp.compare(item, high) <= 0)   {
            range.add(item);
         }
      }
      
      // exceptions
      if (range.isEmpty()) {
         throw new NoSuchElementException("No values " 
               + "fall into specified range.");
      }
   
      return range;
   }


   /**
    * Returns the smallest value in the Collection coll that is greater than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the ceiling value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the ceiling value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      
      // create ceiling array
      ArrayList<T> list = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      
      for (T item : coll)  {
         if (comp.compare(item, key) >= 0)  {
            list.add(item);
         }
      }
      
      // exceptions
      if (list.size() == 0)   {
         throw new NoSuchElementException("There is no qualifying value.");
      }
      
      // find smallest value of ceiling
      T ceiling = min(list, comp);
           
      return ceiling;
   }


   /**
    * Returns the largest value in the Collection coll that is less than
    * or equal to key, as defined by the Comparator comp. The value of key
    * does not have to be in coll. If coll or comp is null, this method throws
    * an IllegalArgumentException. If coll is empty or if there is no
    * qualifying value, this method throws a NoSuchElementException. This
    * method will not change coll in any way.
    *
    * @param coll    the Collection from which the floor value is selected
    * @param key     the reference value
    * @param comp    the Comparator that defines the total order on T
    * @param <T>     the type parameter
    * @return        the floor value of key in coll
    * @throws        IllegalArgumentException as per above
    * @throws        NoSuchElementException as per above
    */
   public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) {
      // exceptions
      if (coll == null || comp == null)  {
         throw new IllegalArgumentException("Value cannot be null.");
      }
      if (coll.isEmpty())  {
         throw new NoSuchElementException("Collection cannot be empty.");
      }
      
      // create ceiling array
      ArrayList<T> list = new ArrayList<T>();
      Iterator<T> itr = coll.iterator();
      
      for (T item : coll)  {
         if (comp.compare(item, key) <= 0)  {
            list.add(item);
         }
      }
      
      // exceptions
      if (list.size() == 0)   {
         throw new NoSuchElementException("There is no qualifying value.");
      }
      
      // find smallest value of ceiling
      T floor = max(list, comp);
           
      return floor;
   }

}
