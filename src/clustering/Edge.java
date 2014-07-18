/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

/**
 *
 * @author Andrea
 */
public class Edge implements Comparable<Edge>{
    /**
     * Number of first end. It is supposed that _end1 is less that _end2.
     */
    private int _end1;

    /**
     * Number of second end. It is supposed that _end2 is greater that _end1.
     */
    private int _end2;

    /**
     * Edge cost.
     */
    private int _cost;

    /**
     * Cost getter
     *
     * @return
     */
    public int cost() {
        return _cost;
    }

    /**
     * weight setter
     *
     * @return void
     */
    public void setCost(int _cost) {
        this._cost = _cost;
    }

    /**
     * Creates undirected edge connecting nodes _end1 and _end2
     *
     * @param _first
     * @param _second
     * @param _weight
     */
    public Edge(int _first, int _second, int _weight) {
        if (_first > _second) {
            this._end1 = _second;
            this._end2 = _first;
        } else {
            this._end1 = _first;
            this._end2 = _second;
        }
        this._cost = _weight;
    }

    /**
     * _end1 getter
     *
     * @return int
     */
    public int firstEnd() {
        return this._end1;
    }

    /**
     * _end2 getter
     *
     * @return int
     */
    public int secondEnd() {
        return this._end2;
    }

    /**
     * Returns 2-element array containing numbers of the ends in increasing order.
     *
     * @return Integer[]
     */
    public int[] getEnds() {
        int[] ends = new int[2];
        ends[0] = this._end1;
        ends[1] = this._end2;
        return ends;
    }

    /**
     * Returns true if the edge connects given nodes, false otherwise.
     *
     * @param end1
     * @param end2
     * @return boolean
     */
    public boolean connects(int end1, int end2) {
        if (end1 > end2){
            return this._end1 == end2 && this._end2 == end1;
        }
        else {
            return this._end1 == end1 && this._end2 == end2;
        }
    }
    
    /**
     * Returns true if two edges have all parameters equal and false otherwise.
     * @param e
     * @return  boolean
     */
    public boolean equals(Edge e)
    {
        return this._end1 == e.firstEnd() && this._end2 == e.secondEnd() && this._cost == e.cost();
    }

    /**
     * Returns -1, if current edge has less cost than that of the argument, 0 if
     * they are equal, +1 if it is greater.
     * @param e
     * @return -1, 0, 1
     */
    @Override
    public int compareTo(Edge e) {
        int diff = this._cost - e.cost();
        if (diff > 0){
            return 1;
        }
        if (diff < 0){
            return -1;
        }
        return 0;
    }
    
    public String toString()
    {
        return "" + this._end1 + "-" + this._end2 + ": " + this._cost;
    }

}
