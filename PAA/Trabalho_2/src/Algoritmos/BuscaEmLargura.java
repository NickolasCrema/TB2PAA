package Algoritmos;

import java.util.ArrayList;

import Graph.Graph;
import Graph.Vertex;

public class BuscaEmLargura {
	private ArrayList<Vertex> tagged;
	private ArrayList<Vertex> queue;
	private Vertex current;
	
	public BuscaEmLargura(Vertex src) {
		this.current = src;
		this.tagged = new ArrayList<Vertex>();
		this.queue = new ArrayList<Vertex>();
	}
	
	public void runAlgorithm() {
		tagged.add(current);
		System.out.print(current.getData());
		queue.add(current);
		while(queue.size() > 0) {
			Vertex visited = queue.get(0);
			for(int i=0; i < visited.getOutgoingEdge().size(); i++) {
				Vertex next = visited.getOutgoingEdge().get(i).getEnd();
				if(!tagged.contains(next)) {
					tagged.add(next);
					System.out.print(" -> " + next.getData());
					queue.add(next);
				}
			}
			queue.remove(0);
		}
	}
	
	public static void main(String[] args) {
		Graph grafo = new Graph();
		grafo.addVertex(0);
		grafo.addVertex(1);
		grafo.addVertex(2);
		grafo.addVertex(3);
		grafo.addVertex(4);
		grafo.addVertex(5);
		grafo.addVertex(6);
		
		grafo.addEdgeDirected(0, 3, 5);
		grafo.addEdgeDirected(0, 5, 11);
		grafo.addEdgeDirected(0, 2, 8);
		grafo.addEdgeDirected(1, 3, 2);
		grafo.addEdgeDirected(1, 4, 18);
		grafo.addEdgeDirected(2, 3, 7);
		grafo.addEdgeDirected(2, 5, 4);
		grafo.addEdgeDirected(2, 4, 3);
		grafo.addEdgeDirected(4, 5, -1);
		grafo.addEdgeDirected(4, 6, 5);
		grafo.addEdgeDirected(5, 6, 17);
		
		Vertex inicio = grafo.getVertex(2);
		
		BuscaEmLargura busca = new BuscaEmLargura(inicio);
		busca.runAlgorithm();
	}
}
