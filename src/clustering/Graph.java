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
    
 

    public List<Edge> getEdges() {
        return _edges;
    }

    public List<Integer> getNodes() {
        return _nodes;
    }

    public int getNumOfNodes() {
        return this._nodes.size();
    }

    public int getNumOfEdges() {
        return this._edges.size();
    }
    
 

    public Graph() {
        this._edges = new ArrayList();
        this._nodes = new ArrayList();
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
     * @param  n 
     * @return void
     */
    private void _registerNode(int n)
    {
        if (!this._nodes.contains(n)){
            this._nodes.add(n);
        }
    }
    
    /**
     * Insert edge into _edges preserving its order
     * @param e 
     */
    private void _insertEdge(Edge e)
    {
        System.out.println("Graph content: " + this.toString());
        if (this.getNumOfEdges() == 0){
           System.out.println("Graph has no edges, so let's just add the edge " + e.toString());
           this._edges.add(e);
           return;
        }
        if (this.getNumOfEdges() == 1) {
            System.out.println("Graph has one edges");
            if (e.compareTo(this.getEdge(0)) > 0){
                System.out.println("Appending edge " + e.toString() + " to the end.");
                this._edges.add(e);
            } else {
                System.out.println("Inserting edge " + e.toString() + " to the beginning.");
                this._edges.add(0, e);
            }
            return;
        }
        int l = 0, pos,
            r = this._edges.size() - 1,
            m, comp, counter = 0;
        Edge em;
        while(r - l > 1){
            m = (l + r) / 2;
            System.out.println("counter: " + counter + ": l = " + l + ", r = " + r + ", m = " + m);
            counter++;
            em = this.getEdge(m);
            comp = em.compareTo(e);
            if (comp > 0){
                r = m;
            } else if (comp < 0){
                l = m;
            } else {
                l = m;
                r = m;
                System.out.println("exiting while loop");
                break;
            }
        }
        if (r == l || r == l + 1) {
            pos = (e.compareTo(this.getEdge(l)) < 0) ? l : ((e.compareTo(this.getEdge(r)) > 0) ? r + 1 : r );
            this._edges.add(pos, e);
        } else {
            throw new IllegalArgumentException("Somehow left and rigth pointers "
                    + "have unexpected values: l=" + l + ", r=" + r + 
                    "\nGraph: " + this.toString() );
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
    
    public String toString()
    {
        String output = "";
        for(Edge e : this._edges){
            output += e.toString() + " ";
        }
        return output;
    }
    

    
    public static void main(String[] args)
    {
    
    }
    
}
