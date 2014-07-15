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
import clustering.Edge;

/**
 *
 * @author Andrea
 */
public class EdgeTest {
    
    public EdgeTest() {
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

    /**
     * Test of cost method, of class Edge.
     */
    @Test
    public void testCost() {
        System.out.println("gets cost of the edge");
        Edge e = new Edge(1, 2, 5);
        assertEquals(5, e.cost());
    }

    /**
     * Test of setCost method, of class Edge.
     */
    @Test
    public void testSetCost() {
        System.out.println("sets edge cost");
        Edge e = new Edge(4, 2, 7);
        e.setCost(4);
        assertEquals(4, e.cost());
    }

    /**
     * Test of firstEnd method, of class Edge.
     */
    @Test
    public void testFirstEnd() {
        System.out.println("sets first end number to 3 if edge numbers are 3 and 5.");
        Edge e = new Edge(3, 5, 0);
        assertEquals(3, e.firstEnd());
    }

    
    /**
     * Test of firstEnd method, of class Edge.
     */
    @Test
    public void testFirstEndMax() {
        System.out.println("sets first end number to 1 if edge numbers are 3 and 1.");
        Edge e = new Edge(3, 1, 0);
        assertEquals(1, e.firstEnd());
    }

    /**
     * Test of secondEnd method, of class Edge.
     */
    @Test
    public void testSecondEnd() {
        System.out.println("sets second end number to 5 if edge numbers are 3 and 5.");
        Edge e = new Edge(3, 5, 6);
        assertEquals(5, e.secondEnd());
    }
    
    /**
     * Test of secondEnd method, of class Edge.
     */
    @Test
    public void testSecondEndMax() {
        System.out.println("sets second end number to 7 if edge numbers are 7 and 3.");
        Edge e = new Edge(7, 3, 2);
        assertEquals(7, e.secondEnd());
    }


    /**
     * Test of getEnds method, of class Edge.
     */
    @Test
    public void testGetEndsIncreasing() {
        System.out.println("get ordered array of end numbers if nodes are in "
                + "increasing order.");
        Edge e = new Edge(1, 3, 1);
        int[] result = e.getEnds();
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
    }

    /**
     * Test of getEnds method, of class Edge.
     */
    @Test
    public void testGetEndsDecreasing() {
        System.out.println("get ordered array of end numbers if nodes are in "
                + "decreasing order.");
        Edge e = new Edge(4, 0, 10);
        int[] result = e.getEnds();
        assertEquals(0, result[0]);
        assertEquals(4, result[1]);
    }

    
    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsNoSuchNumbersIncreasing() {
        System.out.println("returns false if edge has no such node numbers");
        Edge e = new Edge(3, 4, 5);
        assertEquals(false, e.connects(2, 1));
        assertEquals(false, e.connects(1, 2));

    }

    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsNoSuchNumbersDecreasing() {
        System.out.println("returns false if edge has no such node numbers");
        Edge e = new Edge(4, 3, 5);
        assertEquals(false, e.connects(2, 1));
        assertEquals(false, e.connects(1, 2));

    }

    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsJustOneNumberDecreasing() {
        System.out.println("returns false if only one node is in common (dec)");
        Edge e = new Edge(4, 3, 5);
        assertEquals(false, e.connects(4, 1));
        assertEquals(false, e.connects(3, 2));

    }

    
    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsJustOneNumberIncreasing() {
        System.out.println("returns false if only one node is in common (inc)");
        Edge e = new Edge(2, 10, 5);
        assertEquals(false, e.connects(2, 1));
        assertEquals(false, e.connects(10, 4));
    }

    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsBothNumberIncreasing() {
        System.out.println("returns true if both nodes are in common (inc)");
        Edge e = new Edge(2, 10, 5);
        assertEquals(true, e.connects(2, 10));
        assertEquals(true, e.connects(10, 2));
    }

    /**
     * Test of connects method, of class Edge.
     */
    @Test
    public void testConnectsBothNumberDecreasing() {
        System.out.println("returns true if both nodes are in common (dec)");
        Edge e = new Edge(10, 2, 5);
        assertEquals(true, e.connects(2, 10));
        assertEquals(true, e.connects(10, 2));
    }


    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEqualsDiffCost() {
        System.out.println("return false if edges have different costs");
        Edge e1 = new Edge(1, 3, 0);
        Edge e2 = new Edge(1, 3, 10);
        assertEquals(false, e1.equals(e2));
    }

    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEqualsDiffFirst() {
        System.out.println("return false if edges have one end different");
        Edge e1 = new Edge(1, 3, 1);
        Edge e2 = new Edge(1, 2, 1);
        assertEquals(false, e1.equals(e2));
    }
    
    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEqualsInc() {
        System.out.println("return true if edges are equal");
        Edge e1 = new Edge(1, 3, 0);
        Edge e2 = new Edge(1, 3, 0);
        assertEquals(true, e1.equals(e2));
    }

    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEqualsOpposite() {
        System.out.println("return true if edges are equal but inserted in opposite ways.");
        Edge e1 = new Edge(1, 3, 5);
        Edge e2 = new Edge(3, 1, 5);
        assertEquals(true, e1.equals(e2));
    }
    

    /**
     * Test of equals method, of class Edge.
     */
    @Test
    public void testEqualsToItself() {
        System.out.println("return true if edges is compared to itself.");
        Edge e1 = new Edge(1, 3, 5);
        assertEquals(true, e1.equals(e1));
    }

}
