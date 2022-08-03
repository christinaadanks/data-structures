import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Christina L (czl0144@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

   //////////////////////////////////////////////////////////
   // Do not change the following three fields in any way. //
   //////////////////////////////////////////////////////////

   /** References to the first and last node of the list. */
   Node front;
   Node rear;

   /** The number of nodes in the list. */
   int size;

   /////////////////////////////////////////////////////////
   // Do not change the following constructor in any way. //
   /////////////////////////////////////////////////////////

   /**
    * Instantiates an empty LinkedSet.
    */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }


   //////////////////////////////////////////////////
   // Public interface and class-specific methods. //
   //////////////////////////////////////////////////

   ///////////////////////////////////////
   // DO NOT CHANGE THE TOSTRING METHOD //
   ///////////////////////////////////////
   /**
    * Return a string representation of this LinkedSet.
    *
    * @return a string representation of this LinkedSet
    */
   @Override
   public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }
      


   ///////////////////////////////////
   // DO NOT CHANGE THE SIZE METHOD //
   ///////////////////////////////////
   /**
    * Returns the current size of this collection.
    *
    * @return  the number of elements in this collection.
    */
   public int size() {
      return size;
   }

   //////////////////////////////////////
   // DO NOT CHANGE THE ISEMPTY METHOD //
   //////////////////////////////////////
   /**
    * Tests to see if this collection is empty.
    *
    * @return  true if this collection contains no elements, false otherwise.
    */
   public boolean isEmpty() {
      return (size == 0);
   }


   /**
    * Ensures the collection contains the specified element. Neither duplicate
    * nor null values are allowed. This method ensures that the elements in the
    * linked list are maintained in ascending natural order.
    *
    * Time complexity: O(N)
    *
    * @param  element  The element whose presence is to be ensured.
    * @return true if collection is changed, false otherwise.
    */
   public boolean add(T element) {
      Node n = new Node(element);
      Node current = front;
      
      // null value
      if (element == null) {
         throw new NullPointerException("Element cannot be null.");
      }
      
      // duplicate value
      if (this.contains(element))   {
         return false;
      }
      
      // empty collection
      if (isEmpty()) {
         front = n;
         rear = n;
         rear.next = null;
         size++;
      }
      
      // add element to the front
      else if (front.element.compareTo(element) > 0) {
         n.next = front;
         front.prev = n;
         front = n;
         size++;
      }
      
      // add element to the rear
      else if (rear.element.compareTo(element) < 0)  {
         n.prev = rear;
         rear.next = n;
         rear = n;
         rear.next = null;
         size++;
      }
      
      // ascending order
      else  {
         Node m = fNode(element);
         m.next.prev = n;
         n.next = m.next;
         m.next = n;
         n.prev = m;
         size ++;      
      }
      return true;
   }
   
   /**
    * Ensures the collection does not contain the specified element.
    * If the specified element is present, this method removes it
    * from the collection. This method, consistent with add, ensures
    * that the elements in the linked lists are maintained in ascending
    * natural order.
    *
    * Time complexity: O(N)
    *
    * @param   element  The element to be removed.
    * @return  true if collection is changed, false otherwise.
    */
   public boolean remove(T element) {
      // null value
      if (element == null) {
         throw new NullPointerException("Element cannot be null.");
      }
      
      // empty set
      if (isEmpty()) {
         return false;
      }
      
      // removal check
      if (!this.contains(element))  {
         return false;
      }
      
      // size 1 collection
      if (size == 1) {
         front = null;
         rear = null;
         size = 0;
         return true;
      }
      
      // remove element
      Node n = front;
      while (n != null) {
         if (n.element.equals(element))   {
            
            // front
            if (n == front)   {
               front = front.next;
               front.prev = null;
            }
            
            else  {
               if (n.next != null)  {
                  n.prev.next = n.next;
                  n.next.prev = n.prev; 
               }
               else  {
                  n.prev.next = null;
                  rear = n.prev;
               }
            }
            size--;
            return true;
         }
         n = n.next;
      }
      return false;
   }


   /**
    * Searches for specified element in this collection.
    *
    * Time complexity: O(N)
    *
    * @param   element  The element whose presence in this collection is to be tested.
    * @return  true if this collection contains the specified element, false otherwise.
    */
   public boolean contains(T element) {
      
      // empty collection
      if (isEmpty()) {
         return false;
      }
      
      // find element
      Node n = front;
      while (n != null) {
         if (n.element.equals(element))   {
            return true;
         }
         n = n.next;
      } 
      return false;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * Time complexity: O(N)
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(Set<T> s) {
      Node n = front;
      
      if (this.size() == s.size())  {
         while (n != null) {
            if (!s.contains(n.element))   {
               return false;
            }
            n = n.next;
         }
      return true;
      }
      return false;
   }


   /**
    * Tests for equality between this set and the parameter set.
    * Returns true if this set contains exactly the same elements
    * as the parameter set, regardless of order.
    *
    * Time complexity: O(N)
    *
    * @return  true if this set contains exactly the same elements as
    *               the parameter set, false otherwise
    */
   public boolean equals(LinkedSet<T> s) {
      
      Node t = this.front;
      Node p = s.front;
      
      if (this.size() == s.size())  {
         while (t != null) {
            if (t.element.equals(p.element)) {
               t = t.next;
               p = p.next;
            }
            else  {
               return false;
            }
         }
      return true;
      }
      return false;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * Time complexity: O(N^2)
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(Set<T> s){
      // null set
      if (s == null) {
         throw new NullPointerException("Set cannot be null.");
      }
      
      Set<T> unionSet = new LinkedSet<T>();
      
      // add this set
      Iterator<T> itr1 = this.iterator();
      for (T element : this)  {
         unionSet.add(element);
      }
      
      // add parameter set
      Iterator<T> itr2 = s.iterator();
      for (T element : s)  {
         if (!unionSet.contains(element)) {
            unionSet.add(element);
         }
      } 
      return unionSet;
   }


   /**
    * Returns a set that is the union of this set and the parameter set.
    *
    * Time complexity: O(N)
    *
    * @return  a set that contains all the elements of this set and the parameter set
    */
   public Set<T> union(LinkedSet<T> s){
      Node t = this.front;
      Node p = s.front;
      
      LinkedSet<T> unionLinkedSet = new LinkedSet<T>();
      
      // null set
      if (s == null)  {
         throw new NullPointerException("Set cannot be null.");
      }
      
      // empty set
      if (s.isEmpty())  {
         while (p != null) {
            unionLinkedSet.constantAdd(p.element);
            p = p.next;
         }
      }
      
      if (this.isEmpty())  {
         while (t != null) {
            unionLinkedSet.constantAdd(t.element);
            t = t.next;
         }
      }
      
      // union set
      while (t != null && p != null)   {
         if (t.element.compareTo(p.element) > 0)   {
            unionLinkedSet.constantAdd(p.element);
            p = p.next;
         }
         else if (t.element.compareTo(p.element) < 0) {
            unionLinkedSet.constantAdd(t.element);
            t = t.next;
         }
         else if (t.element.compareTo(p.element) == 0)   {
            unionLinkedSet.constantAdd(t.element);
            t = t.next;
            p = p.next;
         }
      }
      
      // once one set ends
      if (t == null) {
         while (p != null) {
            unionLinkedSet.constantAdd(p.element);
            p = p.next;
         }
      }
      
      else if (p == null)  {
         while (t != null) {
            unionLinkedSet.constantAdd(t.element);
            t = t.next;
         }
      }  
      return unionLinkedSet;
   }


   /**
    * Returns a set that is the intersection of this set and the parameter set.
    *
    * Time complexity: O(N^2)
    *
    * @return  a set that contains elements that are in both this set and the parameter set
    */
   public Set<T> intersection(Set<T> s) {
      // null set
      if (s == null) {
         throw new NullPointerException("Set cannot be null.");
      }
      
      // intersection
      Set<T> intSet = new LinkedSet<T>();
      
      Iterator<T> itr = this.iterator();
      for (T element: this)   {
         if (s.contains(element))   {
            intSet.add(element);
         }
      }
      return intSet;
   }

   /**
    * Returns a set that is the intersection of this set and
    * the parameter set.
    *
    * Time complexity: O(N)
    *
    * @return  a set that contains elements that are in both
    *            this set and the parameter set
    */
   public Set<T> intersection(LinkedSet<T> s) {
      Node t = this.front;
      Node p = s.front;
      
      // null set
      if (s == null) {
         throw new NullPointerException("Set cannot be null.");
      }
      
      LinkedSet<T> intLinkedSet = new LinkedSet<T>();
      
      // empty set
      if (s.isEmpty() || this.isEmpty())  {
         return intLinkedSet;
      }
      
      // linked intersection
      while (t != null && p != null)   {
         if (t.element.compareTo(p.element) > 0)   {
            p = p.next;
         }
         else if (t.element.compareTo(p.element) < 0) {
            t = t.next;
         }
         else if (t.element.compareTo(p.element) == 0)   {
            intLinkedSet.constantAdd(t.element);
            t = t.next;
            p = p.next;
         }
      }
      return intLinkedSet;
   }


   /**
    * Returns a set that is the complement of this set and the parameter set.
    *
    * Time complexity: O(N^2)
    *
    * @return  a set that contains elements that are in this set but not the parameter set
    */
   public Set<T> complement(Set<T> s) {
      Iterator<T> itr = this.iterator();
      Set<T> compSet = new LinkedSet<T>();
      
      // empty set
      if (isEmpty()) {
         return compSet;
      }
      
      // complement set
      if (s == null) {
         for (T element : this)  {
            compSet.add(element);
         } 
      }
      
      for (T element : this)  {
         if (!s.contains(element))   {
            compSet.add(element);
         }
      }
      return compSet;
   }


   /**
    * Returns a set that is the complement of this set and
    * the parameter set.
    *
    * Time complexity: O(N)
    *
    * @return  a set that contains elements that are in this
    *            set but not the parameter set
    */
   public Set<T> complement(LinkedSet<T> s) {
      // null set
      if (s == null) {
         throw new NullPointerException("Set cannot be null.");
      }
      
      // set not in parameter set
      LinkedSet<T> compSet = new LinkedSet<T>();
      Node t = this.front;
      Node p = s.front;
      
      // empty set
      if (this.isEmpty()) {
         return compSet;
      }
      
      if (s.isEmpty()) {
         while (t != null) {
            compSet.constantAdd(t.element);
            t = t.next;
         }
      }
      
      // complement linked set
      while (t != null && p != null)   {
         if (t.element.compareTo(p.element) > 0)   {
            p = p.next;
         }
         else if (t.element.compareTo(p.element) < 0) {
            compSet.constantAdd(t.element);
            t = t.next;
         }
         else if (t.element.compareTo(p.element) == 0)   {
            t = t.next;
            p = p.next;
         }
      }
      
      if (p == null) {
         while (t != null) {
            compSet.constantAdd(t.element);
            t = t.next;
         }
      }
      return compSet;
   }


   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in ascending natural order.
    *
    * Time complexity: O(1)
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> iterator() {
      return new LinkedIterator();
   }
   
   /**
    * Returns an iterator over the elements in this LinkedSet.
    * Elements are returned in descending natural order.
    *
    * Time complexity: O(1)
    *
    * @return  an iterator over the elements in this LinkedSet
    */
   public Iterator<T> descendingIterator() {
      return new LinkedDescendingIterator(rear);
   }
   
   /**
    * Returns an iterator over the members of the power set
    * of this LinkedSet. No specific order can be assumed.
    *
    * @return  an iterator over members of the power set
    */
   public Iterator<Set<T>> powerSetIterator() {
      return new PowerIterator(size);
   }



   //////////////////////////////
   // Private utility methods. //
   //////////////////////////////

   private Node fNode(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.compareTo(element) > 0)  {
            return n.prev;
         }
         n = n.next;
      }
      return n;
   }

   private boolean constantAdd(T element) {
      Node n = new Node(element);
      
      // null value
      if (element == null)   {
         throw new NullPointerException("Element cannot be null.");
      }
      
      // empty collection
      if (isEmpty()) {
         front = n;
         rear = n;
         size++;
         return true;
      }
      
      // add element to the front
      else if (front.element.compareTo(element) > 0) {
         n.next = front;
         front.prev = n;
         front = n;
         size++;
         return true;
      }
      
      // add element to the rear
      else if (front.element.compareTo(element) < 0)  {
         n.prev = rear;
         rear.next = n;
         rear = n;
         size++;
         return true;
      }
      return false;      
   }
   
   ////////////////////
   // Nested classes //
   ////////////////////
   
   
   // iterator class
   private class LinkedIterator implements Iterator<T>   {
      private Node n = front;
      
      public boolean hasNext()   {
         return n != null;
      }
      public T next()   {
         if (!hasNext())   {
            throw new NoSuchElementException();
         }
         T result = n.element;
         n = n.next;
         return result;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   // descending iterator class
   private class LinkedDescendingIterator implements Iterator<T>  {
      Node n;
      
      public LinkedDescendingIterator(Node rear)   {
         n = rear;
      }
      
      public boolean hasNext()   {
         return n != null && n.element != null;
      }
      
      public T next()   {
         if (n != null) {
            T result = n.element;
            n = n.prev;
            return result;
         }
         return null;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   // power iterator class
   private class PowerIterator implements Iterator<Set<T>> {
      Node n;
      int current;
      int c;
      int powerSet;
      
      public PowerIterator(int size)  {
         n = front;
         c = size;
         powerSet = (int) Math.pow(2, c);
         current = 0;
      }
      
      public boolean hasNext()   {
         return current < powerSet;
      }
      
      public Set<T> next() {
         Set<T> power = new LinkedSet<T>();
         String binStr = Integer.toBinaryString(current);
         while (binStr.length() < c)  {
            binStr = "0" + binStr;
         }
         
         for (int i = 0; i < c; i++)  {
            if (binStr.charAt(i) == '1')  {
               T element = n.element;
               power.add(element);
            }
            n = n.next;
         }
         n = front;
         current++;
         return power;
      }
      public void remove() {
         throw new UnsupportedOperationException();
      }   
   }
   

   //////////////////////////////////////////////
   // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
   //////////////////////////////////////////////

   /**
    * Defines a node class for a doubly-linked list.
    */
   class Node {
      /** the value stored in this node. */
      T element;
      /** a reference to the node after this node. */
      Node next;
      /** a reference to the node before this node. */
      Node prev;

      /**
       * Instantiate an empty node.
       */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }

      /**
       * Instantiate a node that containts element
       * and with no node before or after it.
       */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }
}
