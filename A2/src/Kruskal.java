import java.util.*;

public class Kruskal{

    public static WGraph kruskal(WGraph g){

        /* Fill this method (The statement return null is here only to compile) */
        
    	//build up an empty result graph
    	WGraph result = new WGraph();
    	ArrayList<Edge> increasing = g.listOfEdgesSorted();
    	DisjointSets components = new DisjointSets(g.getNbNodes());
    	for(int i = 0; i < increasing.size(); i ++) {
    		Edge e = increasing.get(i);
    		if(IsSafe(components, e)) {
    			int node1 = e.nodes[0];
    			int node2 = e.nodes[1];
    			components.union(node1, node2);
    			result.addEdge(e);
    		}
    	}
    	
    	return result;
    }

    public static Boolean IsSafe(DisjointSets p, Edge e){

        /* Fill this method (The statement return 0 is here only to compile) */
        int node1 = e.nodes[0];
        int node2 = e.nodes[1];
        return (p.find(node1) != p.find(node2));
    
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        WGraph t = kruskal(g);
        System.out.println(t);

   } 
}
