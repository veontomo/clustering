/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.util.HashMap;
import java.util.Set;

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
     * Number of elements in _clusters
     */
    private int _size;
    
    /**
     * Returns the cluster which leader is n
     * @param n
     * @return Cluster
     */
    public Cluster getClusterByLeader(int n)
    {
        if (this._clusters.containsKey(n)){
            return this._clusters.get(n);
        }
        return null;
    }

    /**
     * _size getter
     * @return int
     */
    public int size()
    {
        return _size;
    }
    
    public BunchOfClusters()
    {
        this._clusters = new HashMap();
        this._size = 0;
    }
    
    /**
     * Returns the leader of the cluster which the node belongs to.
     * @param n
     * @return Integer
     */
    public Integer find(int n)
    {
        Set<Integer> leaders = this._clusters.keySet();
        // if requested node is among leaders, return it 
        if (leaders.contains(n)){
            return n;
        }
        for (Integer i : leaders){
            if (this._clusters.get(i).contains(n)){
                return i;
            }
        }
        return null;
    }
    
    /**
     * Unions the cluster to which nodes n1 and n2 belongs to and returns 
     * number of the leader of the resulting cluster.
     * @param n1
     * @param n2 
     */
    public int union(int n1, int  n2)
    {
        System.out.print("Joining " + n1 + " and " + n2);
        Integer l1 = this.find(n1),
            l2 = this.find(n2);
        System.out.print(" Their parents: " + l1 + " and " + l2);
        if (l1 == null || l2 == null){
            throw new IllegalArgumentException("Element(s) is not found! Can not unify!");
        }
        if (l1.equals(l2)){
            return l1;
        }
        Cluster c1 = this.getClusterByLeader(l1);
        Cluster c2 = this.getClusterByLeader(l2);
        int leader, 
            s1 = c1.size(), 
            s2 = c2.size();
        if (s1 > s2){
            c1.join(c2);
            leader = l1;
            this._clusters.remove(l2);
        } else {
            c2.join(c1);
            leader = l2;
            this._clusters.remove(l1);
        }
        System.out.println(" -> " + leader);
        this._size--;
        return leader;
    }
    
    public void insert(Cluster c)
    {
        if (c.size() == 0){
            throw new IllegalArgumentException("Can not insert empty cluster!");
        }
        int leader = c.getLeader();
        if (this._clusters.containsKey(leader)){
            throw new IllegalArgumentException("Cluster with given leader (" + 
                    leader + ") is already present!");
        }
        this._clusters.put(leader, c);
        this._size++;
    }
    
    public String info()
    {
        String res = "";
        for (Integer n : this._clusters.keySet()) {
            res += this.getClusterByLeader(n).toString() + "\n";
        }
        return res;

    }
    
    /**
     * Returns true if there exists cluster with leader n.
     * @param n
     * @return  boolean
     */
    public boolean leaderExists(int n)
    {
        return this._clusters.containsKey(n);
    }
    
}
