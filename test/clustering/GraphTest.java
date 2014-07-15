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
    public void testAddExpesiveEdgeToOneEdgeGraph() {
        System.out.println("adding more expensive edge to one-edge graph");
        Graph g = new Graph();
        Edge e1 = new Edge(1, 4, 4);
        Edge e2 = new Edge(3, 2, 10);
        g.addEdge(e1);
        g.addEdge(e2);
        Edge b1 = g.getEdge(0);
        Edge b2 = g.getEdge(1);
        assertEquals(true, b1.equals(e1));
        assertEquals(true, b2.equals(e2));
    }

}
