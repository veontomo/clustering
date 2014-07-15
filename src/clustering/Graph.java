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
public class Graph {
    
    /**
     * List of edges ordered by edge cost.
     */
    private List<Edge> _edges;
    
    /**
     * List of nodes
     */
    private List<Integer> _nodes;
    
    /**
     * Number of nodes in the graph
     */
    private int _numOfNodes;

    public List<Edge> getEdges() {
        return _edges;
    }

    public List<Integer> getNodes() {
        return _nodes;
    }

    public int getNumOfNodes() {
        return _numOfNodes;
    }

    public int getNumOfEdges() {
        return _numOfEdges;
    }
    
    /**
     * Number of edges in the graph
     */
    private int _numOfEdges;

    public Graph() {
        this._edges = new ArrayList();
        this._nodes = new ArrayList();
        this._numOfNodes = 0;
        this._numOfEdges = 0;
    }
    
    /**
     * register edge in such a way that it gets inserted into _edges leaving it
     * sorted in increasing order by edge cost.
     * Registers as well edge nodes if they are not present in the graph.
     * @param e 
     */
    public void addEdge(Edge e)
    {
        int end1 = e.firstEnd();
        int end2 = e.secondEnd();
        this._registerNode(end1);
        this._registerNode(end2);
        this._insertEdge(e);
    }
    
    /**
     * If the node does not exist among _nodes, then inserts it into _nodes
 and augments _numOfNodes.
     * @param  n 
     * @return void
     */
    private void _registerNode(int n)
    {
        if (!this._nodes.contains(n)){
            this._nodes.add(n);
            this._numOfNodes++;
        }
    }
    
    /**
     * Insert edge into _edges preserving its order and augments the _numOfEdges 
     * @param e 
     */
    private void _insertEdge(Edge e)
    {
       if (this._numOfEdges == 0){
           this._edges.add(e);
           this._numOfEdges++;
       }
    }
    
    /**
     * returns edge stored in _edges under the number n. If it does not exist,
     * null is returned.
     * @param n
     * @return Edge|Null
     */
    public Edge getEdge(int n)
    {
        return _edges.get(n);
    }
    
    

    
    public static void main(String[] args)
    {
    
    }
    
}
