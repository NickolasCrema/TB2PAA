package Algoritmos;

import java.util.ArrayList;

import Graph.Edge;
import Graph.Graph;
import Graph.Vertex;
//import sun.java2d.loops.DrawGlyphListAA;

public class BellmanFord {

	private Integer dist[];
	private Integer path[];
	
	public BellmanFord(int size) {
		this.dist = new Integer[size];
		this.path = new Integer[size];
	}
	
	public void runAlgorithm(Graph graph, int src) {
		if(graph.getDirected() == false) {
			System.out.print("ERRO - O grafo selecionado nao eh orientado");
			return;
		}
		
		for(int i=0; i<graph.getVertices().size(); i++) {
			this.dist[i] = Integer.MAX_VALUE;
			this.path[i] = -1;
		}
		dist[src] = 0;
		
		for(int i = 1; i < graph.getVertices().size(); ++i) {
			for(Vertex vertex : graph.getVertices()) {
				for(Edge edge : vertex.getOutgoingEdge()) {
					int v = edge.getEnd().getData();
					int u = vertex.getData();
					int w = edge.getWeight();
					if(this.dist[u] != Integer.MAX_VALUE && this.dist[v] > (this.dist[u] + w)) {
						this.dist[v] = this.dist[u] + w;
						this.path[v] = u;
					}
				}
			}
		}
		for(Vertex vertex : graph.getVertices()) {
			for(Edge edge : vertex.getOutgoingEdge()) {
				int x = edge.getEnd().getData();
				int y = vertex.getData();
				int w = edge.getWeight();
				if(this.dist[x] > this.dist[y] + w) {
					System.out.println("O grafo contem ciclo com peso negativo");
					return;
				}
			}
		}
		this.printArr(graph.getVertices(), src);
	}
	private void printEdge(int src, int dest) {
		if(src != dest) {
			printEdge(src, this.path[dest]);
			System.out.print(" - " + dest);
		}
	}
	
	private void printArr(ArrayList<Vertex> vertices, int src) {
		System.out.println("Origem: " + src);
		for(Vertex vertex : vertices) {
			System.out.print("Destino: " + vertex.getData() + "\t");
			System.out.print("Dist.: " + this.dist[vertex.getData()] + "\t");
			System.out.print("Caminho: " + src + " ");
			this.printEdge(src, vertex.getData());
			System.out.println();
		}
	}
//	ArrayList<Vertex> tagged;
//	
//	public BellmanFord() {
//		this.tagged = new ArrayList<Vertex>();
//	}
//	
//	public void runAlgorithm(Graph graph, int src)
//    {
//		if(graph.getDirected() == false) {
//			System.out.print("ERRO - O grafo selecionado nao eh orientado");
//			return;
//		}
//        int V = graph.getVertices().size();
//        int E = graph.getEdges().size();
//        
// 
//        // Step 1: Initialize distances from src to all other
//        // vertices as INFINITE
//        for (int i = 0; i < V; ++i) {
//            this.dist[i] = Integer.MAX_VALUE;
//            this.path[i] = -1;
//        }
//        this.dist[src] = 0;
//        ArrayList<ArrayList<Vertex>> lista = new ArrayList<ArrayList<Vertex>>();
//        // Step 2: Relax all edges |V| - 1 times. A simple
//        // shortest path from src to any other vertex can
//        // have at-most |V| - 1 edges
//        for (int i = 1; i < V; ++i) {
//            for (int j = 0; j < E; ++j) {
//                int x = graph.getEdges().get(j).getStart().getData();
//                int y = graph.getEdges().get(j).getEnd().getData();
//                int weight = graph.getEdges().get(j).getWeight();
//                if (this.dist[x] != Integer.MAX_VALUE && this.dist[x] + weight < this.dist[y]) {
//                	this.dist[y] = this.dist[x] + weight;
//                	this.path[x] = y;
//                }
//            }
//        }
// 
//        // Step 3: check for negative-weight cycles. The above
//        // step guarantees shortest distances if graph doesn't
//        // contain negative weight cycle. If we get a shorter
//        // path, then there is a cycle.
//        for (int j = 0; j < E; ++j) {
//            int u = graph.getEdges().get(j).getStart().getData();
//            int v = graph.getEdges().get(j).getEnd().getData();
//            int weight = graph.getEdges().get(j).getWeight();
//            if (this.dist[u] != Integer.MAX_VALUE && this.dist[u] + weight < this.dist[v]) {
//                System.out.println("Graph contains negative weight cycle");
//                return;
//            }
//        }
//        this.printArr(graph.getVertices(), src);
//    }
//	
//	 void printArr(int dist[], int V)
//	    {
//	        System.out.println("Vertex Distance from Source");
//	        for (int i = 0; i < V; ++i)
//	            System.out.println(i + "\t\t" + dist[i]);
//	    }
//
////	public void runAlgorithm(Vertice inicio, Grafo g) {
//////		Vertice atual = inicio;
//////		if (inicio.getDado() != destiny) {
//////			marcados.add(inicio);
//////			System.out.print(inicio.getDado() + " ");
//////			for (int i = 0; i < inicio.getArestasSaida().size(); i++) {
//////
//////				Vertice proximo = inicio.getArestasSaida().get(i).getFim();
//////				if (!marcados.contains(proximo)) {
//////					distance += inicio.getArestasSaida().get(i).getPeso();
//////					runAlgorithm(proximo, destiny, distance);
//////				}
//////			}
//////		}
////		int vertex = g.getVertices().size();
////		int edges = g.getArestas().size();
////		int[] dist = new int[vertex];
////		
////		for(int i=0; i<vertex; ++i) {
////			dist[i] = Integer.MAX_VALUE;
////		}
////		
////		dist[inicio.getDado()] = 0;
////		
////		for(int i=1; i<vertex; ++i) {
////			for(int j=0; j<edges; ++j) {
//////				int u = grafo.
////			}
////		}
////	}
//	
//	
//
	public static void main(String[] args) {
		Graph grafo = new Graph();

		for (int i = 0; i < 5; i++) {
			grafo.addVertex(i);
		}
		
		grafo.setDirected(true);

		grafo.addEdgeDirected(0, 1, 11);
		grafo.addEdgeDirected(0, 2, -4);
		grafo.addEdgeDirected(1, 3, -5);
		grafo.addEdgeDirected(2, 4, 7);
		grafo.addEdgeDirected(3, 0, 2);
		grafo.addEdgeDirected(3, 2, 8);
		grafo.addEdgeDirected(4, 2, 19);
		int size = grafo.getVertices().size();
		Vertex inicio = grafo.getVertex(1);
		Integer vertexCount = grafo.vertexCount();
		BellmanFord bf = new BellmanFord(size);
//		bf.runAlgorithm(inicio, 0, 0);
		bf.runAlgorithm(grafo, 1);

	}
}
