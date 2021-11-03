import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.*;


public class LinkedSetTest {

   LinkedSet<Integer> a = new LinkedSet<Integer>();
   LinkedSet<Integer> s = new LinkedSet<Integer>();
   
   ///////////////
   ///// ADD /////
   ///////////////
   
   @Test public void addTest()   {

   }
   
   //////////////////
   ///// REMOVE /////
   //////////////////
   
   @Test public void removeTest()   {
      a.add(4);
      a.add(1);
      a.add(5);
      a.add(3);
      a.add(1);
      a.add(2);
      System.out.println("List before removal: " + a);
      a.remove(5);
      a.remove(2);
      a.remove(8);
      System.out.println("List after removal: " + a);
   }
   
   /////////////////////////
   ///// EQUALS SET<T> /////
   /////////////////////////
   
   ///////////////////////////////
   ///// EQUALS LINKEDSET<T> /////
   ///////////////////////////////
   
   
   ////////////////////////
   ///// UNION SET<T> /////
   ////////////////////////
   
   @Test public void unionTestEmpty() {
      LinkedSet s = new LinkedSet();
      Set s2 = new LinkedSet();
      
      System.out.println(s.union(s2));
   }
      
   @Test public void unionTest1()   {
      LinkedSet s = new LinkedSet();
      s.add(1);
      s.add(2);
      s.add(5);
      
      Set s2 = new LinkedSet();
      s2.add(1);
      s2.add(0);
      s2.add(6);
      s2.add(5);
      
      System.out.println(s.union(s2));
   }
      
   //////////////////////////////
   ///// UNION LINKEDSET<T> /////
   //////////////////////////////
   
   @Test public void unionLinkedTest() {
      LinkedSet s = new LinkedSet();
      s.add(7);
      s.add(4);
      s.add(1);
      s.add(2);
      s.add(5);      
      
      LinkedSet s2 = new LinkedSet();
      s2.add(2);
      s2.add(9);
      s2.add(4);
      
      System.out.println(s.union(s2));
   }     
   
   ///////////////////////////////
   ///// INTERSECTION SET<T> /////
   ///////////////////////////////
   

   /////////////////////////////////////
   ///// INTERSECTION LINKEDSET<T> /////
   /////////////////////////////////////

   
   ///////////////////////
   ///// COMP SET<T> /////
   ///////////////////////
   
   
   /////////////////////////////
   ///// COMP LINKEDSET<T> /////
   /////////////////////////////
   
   
   ////////////////////
   ///// ITERATOR /////
   ////////////////////
   
   @Test public void itrTest()   {
      Set<Integer> s = new LinkedSet<Integer>();
      s.add(1);
      s.remove(1);
      Iterator itr = s.iterator();
      while (itr.hasNext())   {
         System.out.println(itr.next());
      }
   }
   
   /////////////////////////
   ///// DESC ITERATOR /////
   /////////////////////////
   
   @Test public void itrTest2()   {
      s.add(1);
      s.add(5);
      s.add(3);
      Iterator itr2 = s.descendingIterator();
      while (itr2.hasNext())   {
         System.out.println(itr2.next());
      }   
   }
   
   ////////////////////
   ///// POWERSET /////
   ////////////////////
   
   @Test public void powerTest1()   {
      LinkedSet<String> k = new LinkedSet<String>();
      k.add("A");
      k.add("B");
      k.add("C");
      Iterator<Set<String>>itr2 = k.powerSetIterator();
      while (itr2.hasNext())   {
         System.out.println(itr2.next());
      }
   }
   ////////////////////
   ///// VOCAREUM /////
   ////////////////////
   
   @Test public void test1()  {
      Set<Integer> test = new LinkedSet<Integer>();
      
      test.add(1);
      test.remove(2);
      test.remove(1);
      
      System.out.println(test);
   }  
   
   @Test public void test2()  {
      LinkedSet<Integer> t = new LinkedSet<Integer>();
      
      t.add(1);
      t.remove(2);
      t.remove(1);
      
      System.out.println(t);
   }
   

}
