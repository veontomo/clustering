/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrea
 */
public class Cluster {
    
    /**
     * List containing elements
     */
    private List<Integer> _elems;
    
    /**
     * Leader element.
     */
    private int _leader;
    
    /**
     * Number of elements in _elems
     */
    private int _size;
    
    
    public Cluster()
    {
        this._size = 0;
        this._elems = new ArrayList();
    }
            
    
    /**
     * _size getter
     * @return int
     */
    public int size()
    {
        return _size;
    }
    
    /**
     * Inserts element into the _leader if it is not there.
     * @param n 
     */
    public void insert(int n)
    {
        if (this._size == 0){
            this._leader = n;
        }
        
        if (this.contains(n)){
            throw new IllegalArgumentException("Element is already present!");
        }
        
        this._elems.add(n);
        this._size++;
    }
    
    /**
     * Returns element at position n inside _elems
     * @param n
     * @return 
     */
    public int getElem(int n){
        return this._elems.get(n);
    }
    
    /**
     * return _leader
     * @return 
     */
    public Integer getLeader()
    {
        return _leader;
    }
    
    /**
     * Returns true if n is among elements and false otherwise
     * @param n
     * @return 
     */
    public boolean contains(int n)
    {
        return this._elems.contains(n);
    }
    
    /**
     * Appends cluster
     * @param c 
     */
    public void join(Cluster c)
    {
        int len = c.size(),
            i;
        if (this.size() == 0 && c.size() != 0){
            this._leader = c.getLeader();
        }
        for (i = 0; i < len; i++){
            this.insert(c.getElem(i));
        }
        
    }
    
    
    
}
