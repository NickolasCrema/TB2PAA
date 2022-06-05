package Algoritmos;

import java.util.Collections;
import java.util.Comparator;

import Graph.Edge;
import Graph.Graph;

public class Kruskal {
	
	public Kruskal() {};

	class subset {
		int parent, rank;
	};

	int find(subset subsets[], int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	void Union(subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		if (subsets[xroot].rank < subsets[yroot].rank)
			subsets[xroot].parent = yroot;
		else if (subsets[xroot].rank > subsets[yroot].rank)
			subsets[yroot].parent = xroot;
		else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	public void runAlgorithm(Graph graph) {
		int vertices = graph.vertexCount();
		int weight = 0;
		Edge result[] = new Edge[vertices];
		int e = 0;
		int i = 0;
		for (i = 0; i < vertices; ++i)
			result[i] = new Edge();

		Collections.sort(graph.getEdges(), Comparator.comparingInt(Edge::getWeight));
		subset subsets[] = new subset[vertices];
		for (i = 0; i < vertices; ++i)
			subsets[i] = new subset();

		for (int v = 0; v < vertices; ++v) {
			subsets[v].parent = v;
			subsets[v].rank = 0;
		}
		i = 0;
		while (e < vertices - 1) {
			Edge nextEdge = new Edge();
			nextEdge = graph.getEdges().get(i++);
			int x = find(subsets, nextEdge.getStart().getData());
			int y = find(subsets, nextEdge.getEnd().getData());
			if (x != y) {
				weight += nextEdge.getWeight();
				result[e++] = nextEdge;
				Union(subsets, x, y);
			}
		}
		System.out.println("Weight: " + weight);
		System.out.print("Edges: ");
		for (i = 0; i < e; ++i)
			System.out.print("(" + result[i].getStart().getData() + "," + result[i].getEnd().getData() + ") ");
	}
	
	
	public static void main(String[] args) {
		Graph grafo = new Graph();
		grafo.setDirected(false);
		grafo.addVertex(0);
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);
		grafo.addVertex(6);
		
		grafo.addEdge(0, 3, 5);
		grafo.addEdge(0, 5, 11);
		grafo.addEdge(0, 2, 8);
		grafo.addEdge(1, 3, 2);
		grafo.addEdge(1, 4, 18);
		grafo.addEdge(2, 3, 7);
		grafo.addEdge(2, 5, 4);
		grafo.addEdge(2, 4, 3);
		grafo.addEdge(4, 5, -1);
		grafo.addEdge(4, 6, 5);
		grafo.addEdge(5, 6, 17);
		
		Kruskal krusk = new Kruskal();
		krusk.runAlgorithm(grafo);
	}
}
