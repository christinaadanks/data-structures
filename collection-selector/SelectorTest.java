import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class SelectorTest {

   ///////////////////////
   ///// Collections /////
   ///////////////////////
   
   // exception collections
   static Collection<Integer> exC = null;
   static Collection<Integer> empC = new ArrayList<>();
   
   // test collections
   static Collection<Integer> c1 = new ArrayList<Integer>(Arrays.asList(2, 8, 7, 3, 4));
   static Collection<Integer> c2 = new ArrayList<Integer>(Arrays.asList(5, 9, 1, 7, 3));
   static Collection<Integer> c3 = new ArrayList<Integer>(Arrays.asList(8, 7, 6, 5, 4));
   static Collection<Integer> c4 = new ArrayList<Integer>(Arrays.asList(8, 2, 8, 7, 3, 3, 4));
   static Collection<Integer> c5 = new ArrayList<Integer>(Arrays.asList(6));
   static Collection<Integer> c6 = new ArrayList<Integer>(Arrays.asList(0, 9));
   static Collection<Integer> c7 = new ArrayList<Integer>(Arrays.asList(2, 1, 4, 7, 4, 8, 3, 6, 4, 7));
   static Collection<Integer> c8 = new ArrayList<Integer>(Arrays.asList(-4, -4));
   
   ///////////////////////
   ///// Comparators /////
   ///////////////////////
   
   // exception comparators
   static Comparator<Integer> exCo = null;
   
   // defines total order on integers as ascending natural order.
   static Comparator<Integer> comp = 
      new Comparator<Integer>()  {
         public int compare(Integer i1, Integer i2)   {
            return i1.compareTo(i2);
         }
      };
   
   /////////////////////////////////
   ///// Tests for min method. /////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void minExceptionTest()   {
      try   {
         Selector.<Integer>min(exC, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void minExceptionTest2()  {
      try   {
         Selector.<Integer>min(c1, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void minExceptionTest3()  {
      try   {
         Selector.<Integer>min(empC, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   /**
    * Tests for typical cases.
    */
   @Test
   public void minT1()  {
      Integer expected = 2;
      Integer actual = Selector.<Integer>min(c1, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void minT2()  {
      Integer expected = 2;
      Integer actual = Selector.<Integer>min(c4, comp);
      Assert.assertEquals(expected, actual);
   }
  
  /**
   * Tests for special cases.
   */
   @Test
   public void minST1()  {
      Integer expected = 6;
      Integer actual = Selector.<Integer>min(c5, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void minST2()  {
      Integer expected = 0;
      Integer actual = Selector.<Integer>min(c6, comp);
      Assert.assertEquals(expected, actual);
   }
   
   /////////////////////////////////
   ///// Tests for max method. /////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void maxExcTest1()   {
      try   {
         Selector.<Integer>max(exC, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void maxExcTest2()  {
      try   {
         Selector.<Integer>max(c1, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void maxExcTest3()  {
      try   {
         Selector.<Integer>max(empC, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   /**
    * Tests for typical cases.
    */
   @Test
   public void maxT1()  {
      Integer expected = 8;
      Integer actual = Selector.<Integer>max(c1, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void maxT2()  {
      Integer expected = 8;
      Integer actual = Selector.<Integer>max(c4, comp);
      Assert.assertEquals(expected, actual);
   }
  
  /**
   * Tests for special cases.
   */
   @Test
   public void maxST1()  {
      Integer expected = 6;
      Integer actual = Selector.<Integer>max(c5, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void maxST2()  {
      Integer expected = 9;
      Integer actual = Selector.<Integer>max(c6, comp);
      Assert.assertEquals(expected, actual);
   }

   //////////////////////////////////
   ///// Tests for kmin method. /////
   //////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void kminExcTest1()   {
      try   {
         Selector.<Integer>kmin(exC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kminExcTest2()  {
      try   {
         Selector.<Integer>kmin(c1, 2, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void kminExcTest3()  {
      try   {
         Selector.<Integer>kmin(empC, 2, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kminExcTest4() {
      try   {
         Selector.<Integer>kmin(c1, 0, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kminExcTest5() {
      try   {
         Selector.<Integer>kmin(c1, 6, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kminExcTest6() {
      try   {
         Selector.<Integer>kmin(c8, 2, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
      
   /**
    * Tests for typical cases.
    */
   @Test
   public void kminT1()  {
      Integer expected = 2;
      Integer actual = Selector.<Integer>kmin(c1, 1, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void kminT2()  {
      Integer expected = 5;
      Integer actual = Selector.<Integer>kmin(c2, 3, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void kminT3()  {
      Integer expected = 8;
      Integer actual = Selector.<Integer>kmin(c3, 5, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void kminT4()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmin(c4, 3, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void kminT5() {
      Integer expected = 2;
      Integer actual = Selector.<Integer>kmin(c7, 2, comp);
      Assert.assertEquals(expected, actual);
   }
   
    
   //////////////////////////////////
   ///// Tests for kmax method. /////
   //////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void kmaxExcTest1()   {
      try   {
         Selector.<Integer>kmax(exC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kmaxExcTest2()  {
      try   {
         Selector.<Integer>kmax(c1, 2, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void kmaxExcTest3()  {
      try   {
         Selector.<Integer>kmax(empC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kmaxExcTest4() {
      try   {
         Selector.<Integer>kmax(c1, 0, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void kmaxExcTest5() {
      try   {
         Selector.<Integer>kmax(c1, 6, comp);
         Assert.fail("Did not throw NoSuchElementException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
      
   /**
    * Tests for typical cases.
    */
   @Test
   public void kmaxT1()  {
      Integer expected = 8;
      Integer actual = Selector.<Integer>kmax(c1, 1, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void kmaxT2()  {
      Integer expected = 5;
      Integer actual = Selector.<Integer>kmax(c2, 3, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void kmaxT3()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmax(c3, 5, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void kmaxT4()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>kmax(c4, 3, comp);
      Assert.assertEquals(expected, actual);
   }
   
   ///////////////////////////////////
   ///// Tests for range method. /////
   ///////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void rangeExcTest1()   {
      try   {
         Selector.<Integer>range(exC, 2, 6, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void rangeExcTest2()  {
      try   {
         Selector.<Integer>range(c1, 2, 6, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void rangeExcTest3()  {
      try   {
         Selector.<Integer>range(empC, 2, 6, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void rangeExcTest4() {
      try   {
         Selector.<Integer>range(c1, 9, 10, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
         
   /**
    * Tests for typical cases.
    */
   @Test
   public void rangeT1()  {
      Collection<Integer> expected = new ArrayList<Integer>(Arrays.asList(2, 3, 4));
      int low = 1;
      int high = 5;
      Collection<Integer> actual = Selector.<Integer>range(c1, low, high, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void rangeT2()  {
      Collection<Integer> expected = new ArrayList<Integer>(Arrays.asList(5, 3));
      int low = 3;
      int high = 5;
      Collection<Integer> actual = Selector.<Integer>range(c2, low, high, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void rangeT3()  {
      Collection<Integer> expected = new ArrayList<Integer>(Arrays.asList(8, 7, 6, 5, 4));
      int low = 4;
      int high = 8;
      Collection<Integer> actual = Selector.<Integer>range(c3, low, high, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void rangeT4()  {
      Collection<Integer> expected = new ArrayList<Integer>(Arrays.asList(7, 3, 3, 4));
      int low = 3;
      int high = 7;
      Collection<Integer> actual = Selector.<Integer>range(c4, low, high, comp);
      Assert.assertEquals(expected, actual);
   }
   
   /////////////////////////////////////
   ///// Tests for ceiling method. /////
   /////////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void ceilExcTest1()   {
      try   {
         Selector.<Integer>ceiling(exC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void ceilExcTest2()  {
      try   {
         Selector.<Integer>ceiling(c1, 2, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void ceilExcTest3()  {
      try   {
         Selector.<Integer>ceiling(empC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void ceilExcTest4() {
      try   {
         Selector.<Integer>ceiling(c1, 9, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
      
   /**
    * Tests for typical cases.
    */
   @Test
   public void ceilT1()  {
      Integer expected = 2;
      Integer actual = Selector.<Integer>ceiling(c1, 1, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void ceilT2()  {
      Integer expected = 7;
      Integer actual = Selector.<Integer>ceiling(c2, 7, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void ceilT3()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>ceiling(c3, 0, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void ceilT4()  {
      Integer expected = 7;
      Integer actual = Selector.<Integer>ceiling(c4, 5, comp);
      Assert.assertEquals(expected, actual);
   }
   
   ///////////////////////////////////
   ///// Tests for floor method. /////
   ///////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
    
   @Test
   public void floorExcTest1()   {
      try   {
         Selector.<Integer>floor(exC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void floorExcTest2()  {
      try   {
         Selector.<Integer>floor(c1, 2, exCo);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }

   @Test
   public void floorExcTest3()  {
      try   {
         Selector.<Integer>floor(empC, 2, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
   @Test
   public void floorExcTest4() {
      try   {
         Selector.<Integer>floor(c1, 1, comp);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (NoSuchElementException e)  {
         Assert.assertTrue(true);
      }
      catch (Exception e)  {
         Assert.fail("Threw incorrect exception.");
      }
   }
   
      
   /**
    * Tests for typical cases.
    */
   @Test
   public void floorT1()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>floor(c1, 6, comp);
      Assert.assertEquals(expected, actual);
   }
  
   @Test
   public void floorT2()  {
      Integer expected = 1;
      Integer actual = Selector.<Integer>floor(c2, 1, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void floorT3()  {
      Integer expected = 8;
      Integer actual = Selector.<Integer>floor(c3, 9, comp);
      Assert.assertEquals(expected, actual);
   }
   
   @Test
   public void floorT4()  {
      Integer expected = 4;
      Integer actual = Selector.<Integer>floor(c4, 5, comp);
      Assert.assertEquals(expected, actual);
   }
   
}
