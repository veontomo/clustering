/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Andrea
 */
public class ClusterTest {
    
    public ClusterTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   @Test
   public void testSizeOfEmpty()
   {
       System.out.println("Returns 0 as size of empty cluster");
       Cluster c = new Cluster();
       assertTrue(c.size() == 0);
   }
   
    @Test
    public void testSize3Elem() {
        System.out.println("Returns 0 as size of empty cluster");
        Cluster c = new Cluster();
        c.insert(1);
        c.insert(4);
        c.insert(10);
        assertTrue(c.size() == 3);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNoDuplicates(){
        System.out.println("Throws exception if trying to add existing element.");
        Cluster c = new Cluster();
        c.insert(1);
        c.insert(4);
        c.insert(1);
    }
    
    @Test
    public void testElemFirst() {
        System.out.println("Returns firstly inserted element");
        Cluster c = new Cluster();
        c.insert(1);
        c.insert(4);
        c.insert(10);
        assertTrue(c.getElem(0) == 1);
    }

    @Test
    public void testElemMiddle() {
        System.out.println("Returns middle element");
        Cluster c = new Cluster();
        c.insert(1);
        c.insert(4);
        c.insert(10);
        c.insert(2);
        c.insert(-5);
        c.insert(3);
        assertTrue(c.getElem(2) == 10);
    }


    @Test
    public void testElemLast() {
        System.out.println("Returns last element");
        Cluster c = new Cluster();
        c.insert(1);
        c.insert(4);
        c.insert(10);
        c.insert(2);
        c.insert(-5);
        c.insert(3);
        assertTrue(c.getElem(5) == 3);
    }
    
    @Test
    public void testGetLeaderSingleElem() {
        System.out.println("Returns number of the first element");
        Cluster c = new Cluster();
        c.insert(1);
        assertTrue(c.getLeader() == 1);
    }
    
    
    @Test
    public void testGetLeaderTwoElems() {
        System.out.println("Returns number of the first element when "
                + "there are 2 elements");
        Cluster c = new Cluster();
        c.insert(8);
        c.insert(3);
        assertTrue(c.getLeader() == 8);
    }
    
    @Test
    public void testGetLeaderFiveElems() {
        System.out.println("Returns number of the first element when "
                + "there are 5 elements");
        Cluster c = new Cluster();
        c.insert(5);
        c.insert(8);
        c.insert(6);
        c.insert(1);
        c.insert(3);
        assertTrue(c.getLeader() == 5);
    }
    
    @Test
    public void testContainsIfEmpty()
    {
        System.out.println("Returns false if cluster is empty");
        Cluster c = new Cluster();
        assertFalse(c.contains(4));
    }
    
    @Test
    public void testContainsTrue() {
        System.out.println("Returns true if cluster contains element");
        Cluster c = new Cluster();
        c.insert(3);
        c.insert(2);
        c.insert(4);
        assertTrue(c.contains(2));
    }
    
    @Test
    public void testContainsFalse() {
        System.out.println("Returns false if cluster does not contain element");
        Cluster c = new Cluster();
        c.insert(3);
        c.insert(2);
        c.insert(4);
        assertFalse(c.contains(5));
    }
    
    
    @Test
    public void testJoinTwoEmpty()
    {
        System.out.println("Joins two empty clusters");
        Cluster c1 = new Cluster();
        Cluster c2 = new Cluster();
        c1.join(c2);
        assertTrue(c1.size() == 0);
    }
    
    @Test
    public void testJoinWithEmpty() {
        System.out.println("Joins two empty clusters");
        Cluster c1 = new Cluster();
        c1.insert(3);
        c1.insert(6);
        c1.insert(4);
        Cluster c2 = new Cluster();
        c1.join(c2);
        assertTrue(c1.size() == 3);
        assertTrue(c1.getLeader() == 3);
        assertTrue(c1.getElem(0) == 3);
        assertTrue(c1.getElem(1) == 6);
        assertTrue(c1.getElem(2) == 4);
    }
    
    @Test
    public void testJoinEmptyWithNonEmpty() {
        System.out.println("Joins two empty clusters");
        Cluster c1 = new Cluster();
        Cluster c2 = new Cluster();
        c2.insert(1);
        c2.insert(6);
        c2.insert(4);
        c2.insert(5);
        c1.join(c2);
        assertTrue(c1.size() == 4);
        assertTrue(c1.getLeader() == 1);
        assertTrue(c1.getElem(0) == 1);
        assertTrue(c1.getElem(1) == 6);
        assertTrue(c1.getElem(2) == 4);
        assertTrue(c1.getElem(3) == 5);
    }
    
    @Test
    public void testJoinTwoNonEmpty() {
        System.out.println("Joins two empty clusters");
        Cluster c1 = new Cluster();
        Cluster c2 = new Cluster();
        c1.insert(3);
        c1.insert(2);
        c2.insert(1);
        c2.insert(6);
        c2.insert(4);
 
        c1.join(c2);
        assertTrue(c1.size() == 5);
        assertTrue(c1.getLeader() == 3);
        assertTrue(c1.getElem(0) == 3);
        assertTrue(c1.getElem(1) == 2);
        assertTrue(c1.getElem(2) == 1);
        assertTrue(c1.getElem(3) == 6);
        assertTrue(c1.getElem(4) == 4);
    }


    
}
