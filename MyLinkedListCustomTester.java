/**
 * Name: Sahil Gathe	
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * Sources used: Tutors, Zybooks, and Lecture Slides
 * 
 * This files is a set of test to test the MyLinkedList file          
 */

import static org.junit.Assert.*;

import javax.swing.event.TableModelListener;

import org.junit.*;


public class MyLinkedListCustomTester {

    /**
     * This sets up the test fixture. JUnit invokes this method before
     * every testXXX method. The @Before tag tells JUnit to run this method
     * before each test.
     */
    MyLinkedList<Integer> emptyIntList;

    @Before
    public void setUp() {
        emptyIntList = new MyLinkedList<>();
    }

    /**
     * Test the add method when [adding a null data point]
     */
    @Test
    public void testAdd() {
        emptyIntList.add(2);
        assertEquals("Checks the previous ",Integer.valueOf(2), emptyIntList.tail.prev.data);
        assertEquals("Chekcs the next",Integer.valueOf(2), emptyIntList.head.next.data);
        emptyIntList.add(3);
        assertEquals("Checks the previous",Integer.valueOf(3), emptyIntList.tail.prev.data);
        boolean errors = false;
        try{
            emptyIntList.add(null);
        }
        catch(NullPointerException bad){
            errors = true;
        }
        assertEquals("chekcs if null is an input",true, errors);
    }

    /**
     * Test the add with index method when [added to overide another add function in a poplusted list]
     */
    @Test
    public void testAddWithIndexTestOne() {
        emptyIntList.add(0, 2);
        assertEquals("Checks basic add empty list",Integer.valueOf(2), emptyIntList.head.next.data);
        emptyIntList.add(0,3);
        assertEquals("Adding to overide another add",Integer.valueOf(3), emptyIntList.head.next.data);
        emptyIntList.add(1,4);
        assertEquals(Integer.valueOf(4),emptyIntList.get(1));
        emptyIntList.add(5);
        emptyIntList.add(6);
        emptyIntList.add(3,10);
        emptyIntList.add(3,11);
        emptyIntList.add(2,13);
        assertEquals(Integer.valueOf(13), emptyIntList.get(2));

    }

    /**
     * Test the add with index method when [Test for the IndexOutofBounds and NullPointer Exeptions]
     */	
    @Test
    public void testAddWithIndexTestTwo() {
        boolean error1 = false;
        try{
            emptyIntList.add(0, 1);
            emptyIntList.add(0,null);
        }catch(NullPointerException bad){
            error1 = true;
        }
        assertEquals("checks if NullPointer was caugth",true, error1);

        boolean error2 = false;
        try{
            emptyIntList.add(0,2);
            emptyIntList.add(3,3);
        }catch(IndexOutOfBoundsException bad){
            error2 = true;
        }
        assertEquals("checks if Index out of bounds was caugth",true, error2);
    }

    /**
     * Test the get method when [getting from an empty list]
     */
    @Test
    public void testGet() {
       emptyIntList.add(2);
       assertEquals("test if get works normally",Integer.valueOf(2), emptyIntList.get(0));
       emptyIntList.add(3);
       emptyIntList.remove(0);
       assertEquals("tests if get works if the node is removed",Integer.valueOf(3), emptyIntList.get(0));
       emptyIntList.add(4);
       emptyIntList.add(5);
       emptyIntList.add(2,0);
       assertEquals(Integer.valueOf(0), emptyIntList.get(2));

    }

    /**
     * Test the getNth method when [Checking Index out of bounds error]
     */
    @Test
    public void testGetNth() {
        emptyIntList.add(1);
        emptyIntList.add(2);
        emptyIntList.add(3);
        boolean error = false;
        try{
            emptyIntList.get(5);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertEquals("catches the index out of bounds",true, error);
    }

    /**
     * Test the set method when [Checking index out of bound error]
     */
    @Test
    public void testSet() {
        emptyIntList.add(1);
        emptyIntList.add(2);
        boolean error = false;
        try{
            emptyIntList.set(5, 1);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertEquals("check if index out bounds error is caught",true, error);
    }

    /**
     * Test the remove method when [Index out of bounds]
     */
    @Test
    public void testRemoveTestOne() {
        emptyIntList.add(1);
        emptyIntList.add(2);
        emptyIntList.add(4);
        boolean error = false;
        try{
            emptyIntList.remove(5);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertEquals("check if index out bounds error is caught",true, error);
        assertEquals(Integer.valueOf(4), emptyIntList.remove(2));
    }
    
    /**
     * Test the remove method when [Index out of bound bacused list is empty]
     */
    @Test
    public void testRemoveTestTwo() {
        boolean error = false;
        try{
            emptyIntList.remove(0);
        }catch(IndexOutOfBoundsException bad){
            error = true;
        }
        assertEquals("Checks if index out of bounds",true, error); 
    }

    /**
     * Test the clear method when [clear if list is empty]
     */
    @Test
    public void testClear() {
        emptyIntList.add(1);
        emptyIntList.add(1);
        emptyIntList.add(1);
        emptyIntList.clear();
        assertEquals(null, emptyIntList.head.next.data);
    }

    /**
     * Test the size method when [size after list is added and removed  ]
     */
    @Test
    public void testSize() {
        emptyIntList.add(1);
        emptyIntList.add(2);
        emptyIntList.add(3);
        emptyIntList.remove(0);
        int test = emptyIntList.size(); 
        assertEquals(test, 2);
    }
}