/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clustering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Andrea
 */
public class Clustering {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("loading graph");
        BufferedReader br = null;
        Graph g = new Graph();
        String fileName = "c:\\Users\\Andrea\\Documents\\courses\\algo2\\homework2\\clustering1.txt";
        try {
            Integer counter = 0;
            Integer first, second, cost;
            String sCurrentLine;
            String[] data;
            Edge e;
            br = new BufferedReader(new FileReader(fileName));
            sCurrentLine = br.readLine();
            while ((sCurrentLine = br.readLine()) != null) {
                counter++;
                data = sCurrentLine.trim().split(" ");
                if (data.length != 3){
                    throw new IllegalArgumentException("Line must contain exactly three numbers!");
                }
                first = Integer.parseInt(data[0]);
                second = Integer.parseInt(data[1]);
                cost = Integer.parseInt(data[2]);
                e = new Edge(first, second, cost);
                g.addEdge(e);
//                if (counter % 10000 == 0){
//                    System.out.println("" + counter + ": " + g.maxNodeNum() );
//                }
                
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Graph is loaded with " + g.getNumOfNodes() + " nodes and " + + g.getNumOfEdges() + " edges.");
//        System.out.println(g.toString());
        g.clusterify(200);
        System.out.println("#clusters = " + g.getNumOfClusters());
//        System.out.println("Clusterized:\n" + g.getClusters().info());
        System.out.println("spacing: " + g.getSpacing());
//        System.out.println("Ordering graph");
//        g.dfsOrder();
//        System.out.println("Graph is ordered");
////        g.flushVisits();
//        System.out.println("Fragmentizing graph");
//        g.fragmentize();
//        System.out.println("Fragmetizing is over");
//        System.out.println(g.show());
//        System.out.println(g.getLeaderInfo());
//        System.out.println(g.show());
        
//        System.out.println(g.showAnswer());
    
    }

    
}
