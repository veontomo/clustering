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
public class BunchOfClustersTest {
    public Cluster c1, c2, c3;
    public BunchOfClusters b;
    
    public BunchOfClustersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        c1 = new Cluster();
        c2 = new Cluster();
        c3 = new Cluster();
        
        c1.insert(1);
        c1.insert(4);
        c1.insert(3);
        
        c2.insert(0);
        c2.insert(10);
        c2.insert(5);
        c2.insert(2);
        c2.insert(6);

        c3.insert(7);
        c3.insert(9);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getCluster method, of class BunchOfClusters.
     */
    @Test
    public void testGetClusterNotExist() {
        System.out.println("get cluster that is not present");
        assertTrue(b.getCluster(1) == null);
    }
    
    /**
     * Test of getCluster method, of class BunchOfClusters.
     */
    @Test
    public void testGetClusterSingleCluster() {
        System.out.println("get cluster from the bunch that contains just one cluster.");
        b.insert(c1);
        assertTrue(c1.getLeader() == 1);
        Cluster c = b.getCluster(1);
        assertTrue(b.getCluster(1) == null);
    }

    /**
     * Test of find method, of class BunchOfClusters.
     */
    @Test
    public void testFind() {
        System.out.println("find");
        int n = 0;
        BunchOfClusters instance = new BunchOfClusters();
        Integer expResult = null;
        Integer result = instance.find(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of union method, of class BunchOfClusters.
     */
    @Test
    public void testUnion() {
        System.out.println("union");
        int n1 = 0;
        int n2 = 0;
        BunchOfClusters instance = new BunchOfClusters();
        instance.union(n1, n2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
