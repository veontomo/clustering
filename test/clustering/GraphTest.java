/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.util.List;
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
public class GraphTest {
    public Edge e1, e2, e3, e4, e5, e6;
    public Graph g;
    public GraphTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        e1 = new Edge(1, 2, 3);
        e2 = new Edge(2, 4, 2);
        e3 = new Edge(4, 3, 1);
        e4 = new Edge(3, 1, 2);
        e5 = new Edge(1, 4, 1);
        e6 = new Edge(3, 2, 3);
        g = new Graph();
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
    }
    
    @After
    public void tearDown() {
    }
    
    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesToEmpty() {
        System.out.println("adding edge into an empty graph");
        Graph g = new Graph();
        Edge e = new Edge(1, 2, 5);
        g.addEdge(e);
        Edge e2 = g.getEdge(0);
        assertEquals(true, e2.equals(e));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testAddEdgeIfExists()
    {
        System.out.println("throws exception if edge already exists.");
        Graph g = new Graph();
        Edge e = new Edge(1, 2, 5);
        Edge e2 = new Edge(1, 2, 3);
        g.addEdge(e);
        g.addEdge(e2);
    }
    
    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesNodeNumber() {
        System.out.println("increases by two if an edge is added to empty graph.");
        Graph g = new Graph();
        Edge e = new Edge(1, 2, 5);
        g.addEdge(e);
        assertEquals(2, g.getNumOfNodes());
    }

    
    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesNodeNumber2() {
        System.out.println("gives 3 if first two edges have one common node");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        g.addEdge(new Edge(1, 3, 5));
        assertEquals(3, g.getNumOfNodes());
    }

    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesNodeNumber3() {
        System.out.println("gives 4 if first two edges have no nodes in common.");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        g.addEdge(new Edge(4, 7, 2));
        assertEquals(4, g.getNumOfNodes());
    }
    
    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesNodeNumber4() {
        System.out.println("gives 7 if edges have some nodes in common.");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        g.addEdge(new Edge(4, 7, 2));
        g.addEdge(new Edge(1, 4, 5));
        g.addEdge(new Edge(7, 8, 3));
        g.addEdge(new Edge(2, 7, 5));
        g.addEdge(new Edge(6, 4, 2));
        g.addEdge(new Edge(4, 9, 2));
        assertEquals(7, g.getNumOfNodes());
    }
    
    
    /**
     * Test of getEdges method, of class Graph.
     */
    @Test
    public void testAddEdgesToEmptyEdgeNumber() {
        System.out.println("gives 1 if graph is initially empty.");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        assertEquals(1, g.getNumOfEdges());
    }

    
    @Test
    public void testAddEdgesToEmptyEdgeNumber2() {
        System.out.println("gives 2 if adding two edges with one node in common.");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        g.addEdge(new Edge(3, 2, 1));
        assertEquals(2, g.getNumOfEdges());
    }

    @Test
    public void testAddEdgesToOneEdgeGraph() {
        System.out.println("gives 2 if adding two edges with no nodes in common.");
        Graph g = new Graph();
        g.addEdge(new Edge(5, 7, 5));
        g.addEdge(new Edge(3, 2, 1));
        assertEquals(2, g.getNumOfEdges());
    }

    
    @Test
    public void testAddEdges2() {
        System.out.println("gives 5 if five edges are added.");
        Graph g = new Graph();
        g.addEdge(new Edge(1, 2, 5));
        g.addEdge(new Edge(2, 5, 1));
        g.addEdge(new Edge(3, 1, 1));
        g.addEdge(new Edge(3, 10, 4));
        g.addEdge(new Edge(5, 12, 6));
        assertEquals(5, g.getNumOfEdges());
    }

    
    @Test
    public void testAddCheaperEdgeToOneEdgeGraph() {
        System.out.println("adding cheaper edge to one-edge graph");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 8);
        Edge e2 = new Edge(3, 2, 5);
        g.addEdge(e1);
        g.addEdge(e2);
        Edge b1 = g.getEdge(0);
        Edge b2 = g.getEdge(1);
        assertEquals(true, b1.equals(e2));
        assertEquals(true, b2.equals(e1));
    }

    
    @Test
    public void testAddExpensiveEdgeToOneEdgeGraph() {
        System.out.println("adding more expensive edge to one-edge graph");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 4);
        Edge e2 = new Edge(3, 2, 10);
        g.addEdge(e1);
        g.addEdge(e2);
        Edge b1 = g.getEdge(0);
        Edge b2 = g.getEdge(1);
        assertTrue(b1.equals(e1));
        assertTrue(b2.equals(e2));
    }
    
    @Test
    public void testAddEdge3IncreasingOrder() {
        System.out.println("adding three edges in increasing order.");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 2);
        Edge e2 = new Edge(3, 2, 5);
        Edge e3 = new Edge(1, 2, 6);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        assertTrue(g.getEdge(0).equals(e1));
        assertTrue(g.getEdge(1).equals(e2));
        assertTrue(g.getEdge(2).equals(e3));
    }
    
    @Test
    public void testAddEdge3DecreasingOrder() {
        System.out.println("adding three edges in increasing order.");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 6);
        Edge e2 = new Edge(3, 2, 5);
        Edge e3 = new Edge(1, 2, 4);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        assertTrue(g.getEdge(0).equals(e3));
        assertTrue(g.getEdge(1).equals(e2));
        assertTrue(g.getEdge(2).equals(e1));
    }
    
    @Test
    public void testAddEdge3MixedOrder() {
        System.out.println("adding three edges in increasing order.");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 2);
        Edge e2 = new Edge(3, 2, 6);
        Edge e3 = new Edge(1, 2, 5);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        System.out.println(g.toString());
        assertTrue(g.getEdge(0).equals(e1));
        assertTrue(g.getEdge(1).equals(e3));
        assertTrue(g.getEdge(2).equals(e2));
    }
    
    @Test
    public void testAddEdge6MixedOrder() {
        System.out.println("adding three edges in increasing order.");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 7);
        Edge e2 = new Edge(3, 2, 5);
        Edge e3 = new Edge(1, 2, 1);
        Edge e4 = new Edge(3, 4, 4);
        Edge e5 = new Edge(4, 2, 2);
        Edge e6 = new Edge(2, 5, 3);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        assertTrue(g.getEdge(0).equals(e3));
        assertTrue(g.getEdge(1).equals(e5));
        assertTrue(g.getEdge(2).equals(e6));
        assertTrue(g.getEdge(3).equals(e4));
        assertTrue(g.getEdge(4).equals(e2));
        assertTrue(g.getEdge(5).equals(e1));
    }
    
    @Test
    public void testAddEdge4TheSameCost() {
        System.out.println("adding four edges of the same cost.");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 7);
        Edge e2 = new Edge(3, 2, 7);
        Edge e3 = new Edge(1, 2, 7);
        Edge e4 = new Edge(3, 4, 7);
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        assertTrue(g.getNumOfEdges() == 4);
    }

    /**
     * Test of edgeExists method, of class Graph.
     */
    @Test
    public void testConnectedByEdgeFalseInEmptyGraph() {
        System.out.println("returns false if graph is empty");
        Edge e = new Edge(1, 2, 3);
        Graph g = new Graph();
        assertFalse(g.connectedByEdge(1, 2));
    }

    @Test
    public void testConnectedByEdgeNotConnected() {
        System.out.println("returns false if nodes are not connected directly");
        Edge e1 = new Edge(1, 2, 3);
        Edge e2 = new Edge(1, 5, 4);
        Graph g = new Graph();
        g.addEdge(e1);
        g.addEdge(e2);
        assertFalse(g.connectedByEdge(2, 5));
        assertFalse(g.connectedByEdge(5, 2));
    }
  

    @Test
    public void testConnectedByEdgeConnected() {
        System.out.println("returns false if nodes are not connected directly");
        Edge e1 = new Edge(1, 2, 3);
        Edge e2 = new Edge(1, 5, 4);
        Graph g = new Graph();
        g.addEdge(e1);
        g.addEdge(e2);
        assertTrue(g.connectedByEdge(2, 1));
        assertTrue(g.connectedByEdge(1, 2));
    }
    
    @Test 
    public void testInitializeClusters()
    {
        System.out.println("Initialize clusters with exisiting nodes");
        Edge e1 = new Edge(1, 4, 7);
        Edge e2 = new Edge(3, 2, 5);
        Edge e3 = new Edge(1, 2, 1);
        Edge e4 = new Edge(3, 4, 4);
        Edge e5 = new Edge(4, 2, 2);
        Edge e6 = new Edge(2, 5, 3);
        Graph g = new Graph();
        g.addEdge(e1);
        g.addEdge(e2);
        g.addEdge(e3);
        g.addEdge(e4);
        g.addEdge(e5);
        g.addEdge(e6);
        g.initializeClusters();
        BunchOfClusters b = g.getClusters();
        assertTrue(b.size() == 5);
    }
    
    
    @Test
    public void testClusterifyTooDetailed() {
        System.out.println("It leaves 4-node graph unchanged if asked"
                + " to split it in 5 clusters.");
        g.clusterify(5);
        assertTrue(g.getNumOfClusters() == 4);
        assertTrue(g.getSpacing() == 1);
    }
            
    @Test
    public void testClusterifyReady() {
        System.out.println("It leaves 4-node graph unchanged if asked"
                + " to split it in 4 clusters.");
        g.clusterify(4);
        assertTrue(g.getNumOfClusters() == 4);
        assertTrue(g.getSpacing() == 1);
    }
    
    @Test
    public void testClusterifySingleMerge() {
        System.out.println("It merges the nearest nodes.");
        g.clusterify(3);
        assertTrue(g.getNumOfClusters() == 3);
        assertTrue(g.getSpacing() == 1);
    }
    
    @Test
    public void testClusterifyMergeTwice() {
        System.out.println("It merges the two nearest nodes.");
        g.clusterify(2);
        assertTrue(g.getNumOfClusters() == 2);
        assertTrue(g.getSpacing() == 2);
    }

    
    

    




}
