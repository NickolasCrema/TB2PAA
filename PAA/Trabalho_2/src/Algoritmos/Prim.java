package Algoritmos;

import java.util.ArrayList;

import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;

public class Prim {

	private Integer edgeWeight[];
	private Integer edge[];
	private Integer destVertex[];
	private ArrayList<Integer> queue;
	private Integer srcVertex[] = new Integer[7];

	public Prim(Graph graph) {
		int size = graph.getVertices().size();
		this.edge = new Integer[size];
		this.edgeWeight = new Integer[size];
		this.destVertex = new Integer[size];
		this.queue = new ArrayList<Integer>();
	}

	private Integer min() {
		int min = -1;
		int minValue = Integer.MAX_VALUE;

		for (Integer value : this.queue) {
			if (minValue > this.edgeWeight[value]) {
				minValue = this.edgeWeight[value];
				min = value;
			}
		}
		return min;
	}

	public void runAlgorithm(Graph graph, int src) {

		for (int i = 0; i < graph.getVertices().size(); i++) {
			this.queue.add(graph.getVertex(i).getData());
			this.edgeWeight[i] = Integer.MAX_VALUE;
		}
		this.edge[src] = -1;
		this.edgeWeight[src] = 0;

		while (!this.queue.isEmpty()) {
			Integer minWeight = this.min();
			this.queue.remove(minWeight);
			int i=0;
			for (Edge edge : graph.getVertex(minWeight).getOutgoingEdge()) {
				int dest = edge.getEnd().getData();
				int source = edge.getStart().getData();
				int weight = edge.getWeight();
				if (weight < this.edgeWeight[dest] && this.queue.contains(dest)) {
					this.edge[dest] = minWeight;
					this.edgeWeight[dest] = weight;
					this.destVertex[dest] = dest;
					this.srcVertex[dest] = source;
				}
			}
			i++;
		}

		this.printArr(src);
	}

	private void printArr(int src) {
		System.out.println("Origem: " + src);
		int totalWeight = 0;
		System.out.print("Arestas: ");
		for (int i = 0; i < this.edge.length; i++) {
			if (this.edge[i] != -1) {
				System.out.print("(" + this.srcVertex[i] + "," + this.destVertex[i] + ") ");
				totalWeight += this.edgeWeight[i];
			}
		}
		System.out.println();
		System.out.println("Peso total: " + totalWeight);
	}

	public static void main(String[] args) {
		Graph grafo = new Graph();

		grafo.setDirected(false);
		for (int i = 0; i < 7; i++) {
			grafo.addVertex(i);
		}

		grafo.addEdge(0, 2, 8);
		grafo.addEdge(0, 3, 5);
		grafo.addEdge(0, 5, 11);
		grafo.addEdge(1, 3, 2);
		grafo.addEdge(1, 4, 18);
		grafo.addEdge(2, 3, 7);
		grafo.addEdge(2, 5, 4);
		grafo.addEdge(2, 4, 3);
		grafo.addEdge(4, 5, -1);
		grafo.addEdge(4, 6, 5);
		grafo.addEdge(5, 6, 17);
		int size = grafo.getVertices().size();
		Vertex inicio = grafo.getVertex(1);
		Integer vertexCount = grafo.vertexCount();
		Prim prim = new Prim(grafo);
//		bf.runAlgorithm(inicio, 0, 0);
		prim.runAlgorithm(grafo, 2);
	}
}
