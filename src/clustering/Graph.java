/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
     * clusters
     */
    private BunchOfClusters _clusters;
    
    /**
     * spacing - minimal value among all distances between separated clusters
     */
    private int _spacing;

  
    
    public List<Edge> getEdges() {
        return _edges;
    }

    public List<Integer> getNodes() {
        return _nodes;
    }
    
    public BunchOfClusters getClusters() {
        return _clusters;
    }


    public int getNumOfNodes() {
        return this._nodes.size();
    }

    public int getNumOfEdges() {
        return this._edges.size();
    }
    
    public int getNumOfClusters(){
        return this._clusters.size();
    }
    
    
    public int getSpacing() {
        return _spacing;
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
        if (this.connectedByEdge(e.firstEnd(), e.secondEnd())){
            throw new IllegalArgumentException("Nodes are already connected.");
        }
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
//        System.out.println("Graph content: " + this.toString());
        if (this.getNumOfEdges() == 0){
//           System.out.println("Graph has no edges, so let's just add the edge " + e.toString());
           this._edges.add(e);
           return;
        }
        if (this.getNumOfEdges() == 1) {
//            System.out.println("Graph has one edges");
            if (e.compareTo(this.getEdge(0)) > 0){
//                System.out.println("Appending edge " + e.toString() + " to the end.");
                this._edges.add(e);
            } else {
//                System.out.println("Inserting edge " + e.toString() + " to the beginning.");
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
//            System.out.println("counter: " + counter + ": l = " + l + ", r = " + r + ", m = " + m);
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
//                System.out.println("exiting while loop");
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
        int i = 0, period = 20;
        for(Edge e : this._edges){
            output += e.toString() + " ";
            if (i % period == 0){
                i = 0;
                output += "\n";
            }
            i++;
        }
        return output;
    }
    
    public String showClusters()
    {
        return this.getClusters().info();
    }
    
    /**
     * Returns true if nodes n1 and n2 are connected by an edge.
     * @param n1
     * @param n2
     * @return boolean
     */
    public boolean connectedByEdge(int n1, int n2)
    {
        // first see if the nodes are present in the node list
        if (!this._nodes.contains(n1) || !this._nodes.contains(n2)){
            return false;
        }
        for (Edge e : this.getEdges()){
            if (e.connects(n1, n2)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Initialize _clusters: creates clusters out of each node 
     * and inserts it into _clusters.
     */
    public void initializeClusters()
    {
        this._clusters = new BunchOfClusters();
        Cluster c;
        for (int n : this._nodes){
            c = new Cluster();
            c.insert(n);
            this._clusters.insert(c);
        }
    }
    
    /**
     * Returs true if edge nodes are located in different clusters
     * @param e
     * @return boolean
     */
    public boolean isCut(Edge e)
    {
        return this._clusters.find(e.firstEnd()) != this._clusters.find(e.secondEnd());
    }
    
    /**
     * Splits the graph in n parts. It starts merging the nodes until 
     * the total number of clusters reaches n.
     * @param n 
     */
    public void clusterify(int n){
        this.initializeClusters();
        if (n >= this.getNumOfNodes()){
            this._spacing = this._edges.get(0).cost();
            return;
        }
        int clusterNum = this.getNumOfNodes();
        int edgeNum = this.getNumOfEdges();
//        int edgeNum = 5;
        int counter = 0;
        Edge e;
        while (clusterNum > n){
            if (counter >= edgeNum){
                System.out.println("No more edges! Setting spacing to zero.");
                this._spacing = 0;
                return;
            }
            e = this.getEdge(counter);
            System.out.println("Merging on edge #" + counter + ": " + e.toString());
            this.getClusters().union(e.firstEnd(), e.secondEnd());
            clusterNum = this.getNumOfClusters();
            counter++;
        }
//        System.out.println("Number of clusters: " + clusterNum);
//        System.out.println("Establishing the spacing...");
//        System.out.println("Available edge number: " + counter);
        while(!this.isCut(this.getEdge(counter))){
//            System.out.println("Edge #" + counter + " is not cut. Passing to the next");
            counter++;
            if (counter >= edgeNum){
                this._spacing = 0;
            }
        }
        if (counter < edgeNum){
            this._spacing = this.getEdge(counter).cost();
        } else {
            this._spacing = 0;
        }
        
        
    
    }
    
    public static void main(String[] args) {

    }
    
}
