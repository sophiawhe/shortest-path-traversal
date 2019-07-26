package a5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import a5.Heap;
import common.NotImplementedError;
import graph.Edge;
import graph.Node;
import graph.LabeledEdge;

/** We've provided depth-first search as an example; you need to implement Dijkstra's algorithm.
 */
public class GraphAlgorithms  {
	/** Return the Nodes reachable from start in depth-first-search order */
	public static <N extends Node<N,E>, E extends Edge<N,E>>
	List<N> dfs(N start) {
		
		Stack<N> worklist = new Stack<N>();
		worklist.add(start);
		
		Set<N>   visited  = new HashSet<N>();
		List<N>  result   = new ArrayList<N>();
		while (!worklist.isEmpty()) {
			// invariants:
			//    - everything in visited has a path from start to it
			//    - everything in worklist has a path from start to it
			//      that only traverses visited nodes
			//    - nothing in the worklist is visited
			N next = worklist.pop();
			visited.add(next);
			result.add(next);
			for (N neighbor : next.outgoing().keySet())
				if (!visited.contains(neighbor))
					worklist.add(neighbor);
		}
		return result;
	}
	
	/**
	 * Return a minimal path from start to end.  This method should return as
	 * soon as the shortest path to end is known; it should not continue to search
	 * the graph after that. 
	 * 
	 * @param <N> The type of nodes in the graph
	 * @param <E> The type of edges in the graph; the weights are given by e.label()
	 * @param start The node to search from
	 * @param end   The node to find
	 */
	public static <N extends Node<N,E>, E extends LabeledEdge<N,E,Integer>>
	List<N> shortestPath(N start, N end) {
	
		
		Heap<N,Integer> worklist = new Heap<N,Integer>(c);
		worklist.add(start, 0);
		Set<N>   visited  = new HashSet<N>();
		
		while (worklist.size() > 0) {
			N next = worklist.poll();
			visited.add(next);
			for (N neighbor : next.outgoing().keySet()) {
				// Here we need a way to tell if neighbor is in worklist
				// (or if neighbor is in some set of unreached nodes,
				// therefore not in worklist.
				
				/* if neighbor is in worklist {
				 * 		update distance of neighbor from start;
				 * } else  {
				 * 		add neighbor to worklist with its distance;
				 * }
				 */
			}
		}
		
		throw new NotImplementedError();
	}
	
	static Comparator<Integer> c = (int1, int2) -> {return int2 - int1;};
	
	//Make class with node, distance, and previous node
	/**
	 * NDP is a representation of a node in relation to the shortest path
	 * algorithm that includes its distance from the start and the NDP prior
	 * along its path.
	 * 
	 * @param <N>
	 */
	public class NDP<N> {
		int distance;
		N previous;
		boolean b;
	}
	
}
