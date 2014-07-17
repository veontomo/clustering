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
        
        b = new BunchOfClusters();
    }
    
    @After
    public void tearDown() {
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInsertEmptyCluster()
    {
        System.out.println("throws exception when inserting empty cluster.");
        b.insert(new Cluster());
    }
    

    @Test
    public void testSizeOfEmpty() 
    {
        System.out.println("returns 0 for the size of empty bunch.");
        assertTrue(b.size() == 0);
    }

    @Test
    public void testSizeOneElem() 
    {
        System.out.println("returns 1 for the size of bunch with single cluster.");
        b.insert(c1);
        assertTrue(b.size() == 1);
    }

    @Test
    public void testSizeThreeElem() 
    {
        System.out.println("returns 0 for the size of empty bunch");
        b.insert(c1);
        b.insert(c2);
        b.insert(c3);
        assertTrue(b.size() == 3);
    }

    @Test(expected=IllegalArgumentException.class)
    public void testInsertClusterIsAlreadyPresent()
    {
        System.out.println("throws exception if the bunch already contains "
                + "cluster with that leader");
        b.insert(c1);
        b.insert(c1);
    }
    
    /**
     * Test of getClusterByLeader method, of class BunchOfClusters.
     */
    @Test
    public void testGetClusterNotExist() {
        System.out.println("get cluster that is not present");
        assertTrue(b.getClusterByLeader(1) == null);
    }
    
    /**
     * Test of getClusterByLeader method, of class BunchOfClusters.
     */
    @Test
    public void testGetClusterSingleCluster() {
        System.out.println("get cluster from the bunch that contains just one cluster.");
        b.insert(c1);
        assertTrue(b.getClusterByLeader(1).isEqualTo(c1));
    }
    
    /**
     * Test of getClusterByLeader method, of class BunchOfClusters.
     */
    @Test
    public void testGetClusterThreeClusters() {
        System.out.println("get cluster from the bunch that contains three cluster.");
        b.insert(c1);
        b.insert(c3);
        b.insert(c2);
        assertTrue(b.getClusterByLeader(7).isEqualTo(c3));
    }


    /**
     * Test of find method, of class BunchOfClusters.
     */
    @Test
    public void testFind() {
        System.out.println("Returns leader of cluster which the element belongs to.");
        b.insert(c1);
        b.insert(c3);
        b.insert(c2);
        assertTrue(b.find(2) == 0);
    }
    
    /**
     * Test of find method, of class BunchOfClusters.
     */
    @Test
    public void testFindNotExist() {
        System.out.println("Returns leader of cluster which the element belongs to.");
        b.insert(c1);
        b.insert(c3);
        b.insert(c2);
        assertTrue(b.find(20) == null);
    }


    /**
     * Test of union method, of class BunchOfClusters.
     */
//    @Test
//    public void testUnion() {
//        System.out.println("union");
//        int n1 = 0;
//        int n2 = 0;
//        BunchOfClusters instance = new BunchOfClusters();
//        instance.union(n1, n2);
//        // TODO review the generated test code and remove the default call to fail.
////        fail("The test case is a prototype.");
//    }
    
}
