package com.srinu.graphs;

public class Dijikstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Let us create the example graph as adjacency matrix
		 * so in adjacency matrix an element [i][j] is a non-zero
		 *  represents that there exist a path between i and j nodes
		 *  and the non-zero value is the weight, if it is zero, then 
		 *  no path exists */
	       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
	                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
	                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
	                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
	                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
	                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
	                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
	                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
	                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}
	                                 };
	        ShortestPath t = new ShortestPath(graph.length);
	        t.dijkstra(graph, 0);
	}

}


class ShortestPath{
	
	int V;
	ShortestPath(int v){
		V=v;
	}
	
	
	//dijkstra algorithm for a graph represented using adjacency matrix
	void dijkstra(int graph[][], int src) {
		int dist[] = new int[V]; //this is the output array which has distances from srouce
		
		/*
		 * sptSet[i] will be true if vertex i is included in
		 * shortest path or this is equivalent to saying - 
		 * 'distance from source to i is finalized'
		 */
		Boolean sptSet[] = new Boolean[V]; //Boolean can be true, false, null unlike boolean only true or false
		
		//Step-1: initialize all distances as Infinite and stpSet[] as false
		for(int i=0; i<V; i++) {
			dist[i] = Integer.MAX_VALUE;
			sptSet[i] = false;
		}
		
		//distance of source vertex from itself is always set to zero
		dist[src] = 0;
		
		//find shortest path to all vertices
		for(int count =0; count<V-1; count++) {
			/*Step-2: pick the minimum distance vertex from the set of vertices not yet
			 * processed/visited. so since out of all the distances (infinites)
			 *  source vertex is the minimum with zero. so in the first iteration
			 *  u is always source
			 */
			
			int u = minDistance(dist, sptSet);
			
			//Step-3: mark the selected vertex as visited or processed
			sptSet[u] = true;
			
			//Step-4: update the distance values of the adjacent vertices of the 
			//selected vertex
			for(int v=0; v<V; v++) {
				/*update dist[v] only if is not visited i.e.
				 * not in sptSet, there is an edge from u to v, 
				 * and total weight of path from src to v through u is
				 * smaller than current value of dist[v]
				 */
				if(!sptSet[v] && graph[u][v]!=0 &&
						dist[u]!=Integer.MAX_VALUE &&
						dist[u]+graph[u][v]<dist[v]) {
					dist[v] = dist[u]+graph[u][v];
				}
			}
		}
		
		printSolution(dist,V, src);
	}
	
	//finding the minimum distance vertex which is not visited yet
	int minDistance(int dist[], Boolean sptSet[]) {
		int min = Integer.MAX_VALUE, min_index = -1;
		
		for(int v =0; v<V; v++) {
			if(sptSet[v]==false && dist[v]<=min) {
				min = dist[v];
				min_index=v;
			}
		}
		return min_index;
	}
	
	void printSolution(int dist[], int n, int src) {
		for(int i=0; i<V; i++) {
			System.out.println("Shortest path from " +src +" -> " + i + " :" + dist[i]);
		}
	}
	
}