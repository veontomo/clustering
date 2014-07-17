/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.util.HashMap;

/**
 *
 * @author Andrea
 */
public class BunchOfClusters {
    
    /**
     * hash of clusters. Hash keys are clusters' leaders.
     */
    private HashMap<Integer, Cluster> _clusters;
    
    /**
     * Returns the cluster which leader is n
     * @param n
     * @return Cluster
     */
    public Cluster getCluster(int n)
    {
        /// !!!stub
        return new Cluster();
    }
    
    /**
     * Returns the leader of the cluster which the node belongs to.
     * @param n
     * @return Integer
     */
    public Integer find(int n)
    {
        return 1;
    }
    
    /**
     * Unions the cluster to which nodes n1 and n2 belongs to.
     * @param n1
     * @param n2 
     */
    public void union(int n1, int  n2)
    {
        /// !!!stub
    }
    
    public void insert(Cluster c)
    {
        /// !!!stub
    }
    
}
