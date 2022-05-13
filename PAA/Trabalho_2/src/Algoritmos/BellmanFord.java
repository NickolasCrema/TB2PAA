package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Vertice;

public class BellmanFord {

	ArrayList<Vertice> tagged;
	
	public BellmanFord() {
		this.tagged = new ArrayList<Vertice>();
	}
	
	void run(Grafo graph, int src)
    {
        int V = graph.getVertices().size(), E = graph.getArestas().size();
        int dist[] = new int[V];
 
        // Step 1: Initialize distances from src to all other
        // vertices as INFINITE
        for (int i = 0; i < V; ++i)
            dist[i] = Integer.MAX_VALUE;
        dist[src] = 0;
 
        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = graph.getArestas().get(j).getInicio().getDado();
                int v = graph.getArestas().get(j).getFim().getDado();
                int weight = graph.getArestas().get(j).getPeso();
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    tagged.add(graph.getArestas().get(j).getInicio());
                }
            }
        }
 
        // Step 3: check for negative-weight cycles. The above
        // step guarantees shortest distances if graph doesn't
        // contain negative weight cycle. If we get a shorter
        // path, then there is a cycle.
        for (int j = 0; j < E; ++j) {
            int u = graph.getArestas().get(j).getInicio().getDado();
            int v = graph.getArestas().get(j).getFim().getDado();
            int weight = graph.getArestas().get(j).getPeso();
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Graph contains negative weight cycle");
                return;
            }
        }
        printArr(dist, V);
    }
	
	 void printArr(int dist[], int V)
	    {
	        System.out.println("Vertex Distance from Source");
	        for (int i = 0; i < V; ++i)
	            System.out.println(i + "\t\t" + dist[i]);
	    }

//	public void runAlgorithm(Vertice inicio, Grafo g) {
////		Vertice atual = inicio;
////		if (inicio.getDado() != destiny) {
////			marcados.add(inicio);
////			System.out.print(inicio.getDado() + " ");
////			for (int i = 0; i < inicio.getArestasSaida().size(); i++) {
////
////				Vertice proximo = inicio.getArestasSaida().get(i).getFim();
////				if (!marcados.contains(proximo)) {
////					distance += inicio.getArestasSaida().get(i).getPeso();
////					runAlgorithm(proximo, destiny, distance);
////				}
////			}
////		}
//		int vertex = g.getVertices().size();
//		int edges = g.getArestas().size();
//		int[] dist = new int[vertex];
//		
//		for(int i=0; i<vertex; ++i) {
//			dist[i] = Integer.MAX_VALUE;
//		}
//		
//		dist[inicio.getDado()] = 0;
//		
//		for(int i=1; i<vertex; ++i) {
//			for(int j=0; j<edges; ++j) {
////				int u = grafo.
//			}
//		}
//	}
	
	

	public static void main(String[] args) {
		Grafo grafo = new Grafo();

		for (int i = 0; i < 5; i++) {
			grafo.adicionaVertice(i);
		}
		
		grafo.setOrientado(true);

		grafo.adicionaArestaOrientado(0, 1, 11);
		grafo.adicionaArestaOrientado(0, 2, -4);
		grafo.adicionaArestaOrientado(1, 3, -5);
		grafo.adicionaArestaOrientado(2, 4, 7);
		grafo.adicionaArestaOrientado(3, 0, 2);
		grafo.adicionaArestaOrientado(3, 2, 8);
		grafo.adicionaArestaOrientado(4, 2, 19);

		Vertice inicio = grafo.getVertice(1);
		Integer vertexCount = grafo.vertexCount();
		BellmanFord bf = new BellmanFord();
//		bf.runAlgorithm(inicio, 0, 0);
		bf.run(grafo, 1);

	}
}
