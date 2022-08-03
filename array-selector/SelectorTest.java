import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Christina L
 * @version 1/22/2021
 */
 
public class SelectorTest {

   /////////////////////////////////
   ///// Tests for min method. /////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void minExceptionTest()   {
   
      int[] a = new int[0];
      try   {
         Selector.min(a);
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
   
      int[] a = null;
      try   {
         Selector.min(a);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void minNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      Assert.assertEquals(2, Selector.min(a));
   }

   @Test
   public void minNormTest2()  {
      int[] a = {8, 7, 6, 5, 4};
      Assert.assertEquals(4, Selector.min(a));
   }
   
   /**
    * Tests for boundary cases.
    */
   @Test
   public void minBoundTest() {
      int[] a = {0, 3};
      Assert.assertEquals(0, Selector.min(a));
   }
   
   /**
    * Tests for special cases.
    */
   @Test
   public void minSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      Assert.assertEquals(2, Selector.min(a));
   }
   
   /////////////////////////////////
   ///// Tests for max method. /////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void maxIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.max(a);
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
   public void maxIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.max(a);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void maxNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      Assert.assertEquals(8, Selector.max(a));
   }

   @Test
   public void maxNormTest2()  {
      int[] a = {8, 7, 6, 5, 4};
      Assert.assertEquals(8, Selector.max(a));
   }
   
   /**
    * Tests for boundary cases.
    */
   @Test
   public void maxBoundTest() {
      int[] a = {0, 3};
      Assert.assertEquals(3, Selector.max(a));
   }
   
   /**
    * Tests for special cases.
    */
   @Test
   public void maxSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      Assert.assertEquals(8, Selector.max(a));
   }
   
   /////////////////////////////////
   ///// Tests for kmin method. /////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void kminIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.kmin(a, 1);
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
   public void kminIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.kmin(a, 1);
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
   public void kminIllegalTest3() {
   
      int[] a = {2, 6, 7, 9};
      try {
         Selector.kmin(a, 5);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void kminNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      Assert.assertEquals(2, Selector.kmin(a, 1));
   }

   @Test
   public void kminNormTest2()  {
      int[] a = {5, 9, 1, 7, 3};
      Assert.assertEquals(5, Selector.kmin(a, 3));
   }
   
   @Test
   public void kminNormTest3()  {
      int[] a = {2, 6, 1, 8};
      Assert.assertEquals(8, Selector.kmin(a, 4));
   }
   

   /**
    * Tests for special cases.
    */
   @Test
   public void kminSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      Assert.assertEquals(4, Selector.kmin(a, 3));
   }
   
   @Test
   public void kminSpecialTest2() {
      int[] a = {5, 9, 7, 3, 1, 3};
      Assert.assertEquals(3, Selector.kmin(a, 2));
   }
   
   @Test
   public void kminSpecialTest3() {
      int[] a = {3, 1, 5, 1, 9, 7, 7};
      Assert.assertEquals(9, Selector.kmin(a, 5));
   }
   
   @Test
   public void kminSpecialTest4() {
      int[] a = {3, 1, 1, 5, 5, 7, 1, 5};
      Assert.assertEquals(7, Selector.kmin(a, 4));
   }   
   
   @Test
   public void kminSpecialTest5() {
      int[] a = {7, 1, 0, 6};
      Assert.assertEquals(0, Selector.kmin(a, 1));
   }   
   
   ////////////////////////////////
   //// Tests for kmax method. ////
   ////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void kmaxIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.kmax(a, 1);
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
   public void kmaxIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.kmax(a, 1);
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
   public void kmaxIllegalTest3() {
   
      int[] a = {2, 6, 7, 9};
      try {
         Selector.kmax(a, 5);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void kmaxNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      Assert.assertEquals(8, Selector.kmax(a, 1));
   }

   @Test
   public void kmaxNormTest2()  {
      int[] a = {5, 9, 1, 7, 3};
      Assert.assertEquals(5, Selector.kmax(a, 3));
   }
   
   @Test
   public void kmaxNormTest3()  {
      int[] a = {2, 6, 1, 8};
      Assert.assertEquals(1, Selector.kmax(a, 4));
   }
   

   /**
    * Tests for special cases.
    */
   @Test
   public void kmaxSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      Assert.assertEquals(4, Selector.kmax(a, 3));
   }
   
   @Test
   public void kmaxSpecialTest2() {
      int[] a = {5, 9, 7, 3, 1, 3};
      Assert.assertEquals(1, Selector.kmax(a, 5));
   }
   
   @Test
   public void kmaxSpecialTest3() {
      int[] a = {3, 1, 5, 1, 9, 7, 7};
      Assert.assertEquals(3, Selector.kmax(a, 4));
   }
   
   @Test
   public void kmaxSpecialTest4() {
      int[] a = {3, 2, 1, 7, 7, 5, 5, 7, 5};
      Assert.assertEquals(2, Selector.kmax(a, 4));
   }   
   
   @Test
   public void kmaxSpecialTest5() {
      int[] a = {7, 1, 0, 6};
      Assert.assertEquals(7, Selector.kmax(a, 1));
   }   
   
   /////////////////////////////////
   //// Tests for range method. ////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void rangeIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.range(a, 1, 6);
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
   public void rangeIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.range(a, 1, 6);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void rangeNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      int[] expected = {2, 3, 4};
      int low = 1;
      int high = 5;
      Assert.assertArrayEquals(expected, Selector.range(a, low, high));
   }

   @Test
   public void rangeNormTest2()  {
      int[] a = {5, 9, 1, 7, 3};
      int[] expected = {5, 3};
      int low = 3;
      int high = 5;
      Assert.assertArrayEquals(expected, Selector.range(a, low, high));
   }
   
   @Test
   public void rangeNormTest3()  {
      int[] a = {8, 7, 6, 5, 4};
      int[] expected = {8, 7, 6, 5, 4};
      int low = 4;
      int high = 8;
      Assert.assertArrayEquals(expected, Selector.range(a, low, high));
   }
   

   /**
    * Tests for special cases.
    */
   @Test
   public void rangeSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      int[] expected = {7, 3, 3, 4};
      int low = 3;
      int high = 7;
      Assert.assertArrayEquals(expected, Selector.range(a, low, high));
   }
   
   ///////////////////////////////////
   //// Tests for ceiling method. ////
   ///////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void ceilingIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.ceiling(a, 5);
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
   public void ceilingIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.ceiling(a, 3);
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
   public void ceilingIllegalTest3()   {
   
      int[] a = {8, 7, 6, 4};
      try   {
         Selector.ceiling(a, 9);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void ceilingNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      
      Assert.assertEquals(2, Selector.ceiling(a, 1));
   }

   @Test
   public void ceilingNormTest2()  {
      int[] a = {2, 8, 7, 3, 4};
      
      Assert.assertEquals(7, Selector.ceiling(a, 7));
   }
   
   @Test
   public void ceilingNormTest3()  {
      int[] a = {8, 7, 6, 5, 4};
      
      Assert.assertEquals(4, Selector.ceiling(a, 0));
   }
   

   /**
    * Tests for special cases.
    */
   @Test
   public void ceilingSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      
      Assert.assertEquals(7, Selector.ceiling(a, 5));
   }      
   
   /////////////////////////////////
   //// Tests for floor method. ////
   /////////////////////////////////
   
   /**
    * Tests for illegal cases.
    */
   @Test
   public void floorIllegalTest()  {
      
      int[] a = new int[0];
      try   {
         Selector.floor(a, 5);
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
   public void floorIllegalTest2() {
   
      int[] a = null;
      try {
         Selector.floor(a, 3);
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
   public void floorIllegalTest3()   {
   
      int[] a = {8, 7, 6, 4};
      try   {
         Selector.floor(a, 0);
         Assert.fail("Did not throw IllegalArgumentException.");
      }
      catch (IllegalArgumentException e)  {
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
   public void floorNormTest()  {
      int[] a = {2, 8, 7, 3, 4};
      
      Assert.assertEquals(4, Selector.floor(a, 6));
   }

   @Test
   public void floorNormTest2()  {
      int[] a = {5, 9, 1, 7, 3};
      
      Assert.assertEquals(1, Selector.floor(a, 1));
   }
   
   @Test
   public void floorNormTest3()  {
      int[] a = {8, 7, 6, 5, 4};
      
      Assert.assertEquals(8, Selector.floor(a, 9));
   }
   

   /**
    * Tests for special cases.
    */
   @Test
   public void floorSpecialTest() {
      int[] a = {8, 2, 8, 7, 3, 3, 4};
      
      Assert.assertEquals(4, Selector.floor(a, 5));
   }         
}
