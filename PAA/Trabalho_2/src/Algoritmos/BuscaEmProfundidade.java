package Algoritmos;

import java.util.ArrayList;

import Graph.Graph;
import Graph.Vertex;

public class BuscaEmProfundidade {

	private ArrayList<Vertex> marcados;
	
	public BuscaEmProfundidade() {
		this.marcados = new ArrayList<Vertex>();
	}
	
	public void runAlgorithm(Vertex prox) {
		marcados.add(prox);
		System.out.print(prox.getData() + " ");
		for(int i=0; i<prox.getOutgoingEdge().size(); i++) {
			Vertex proximo = prox.getOutgoingEdge().get(i).getEnd();
			if(!marcados.contains(proximo)) {
				runAlgorithm(proximo);
			}
		}
		
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
//		grafo.adicionaArestaOrientado(0, 3, 5);
//		grafo.adicionaArestaOrientado(0, 5, 11);
//		grafo.adicionaArestaOrientado(0, 2, 8);
//		grafo.adicionaArestaOrientado(1, 3, 2);
//		grafo.adicionaArestaOrientado(1, 4, 18);
//		grafo.adicionaArestaOrientado(2, 3, 7);
//		grafo.adicionaArestaOrientado(2, 5, 4);
//		grafo.adicionaArestaOrientado(2, 4, 3);
//		grafo.adicionaArestaOrientado(4, 5, -1);
//		grafo.adicionaArestaOrientado(4, 6, 5);
//		grafo.adicionaArestaOrientado(5, 6, 17);
		
		Vertex inicio = grafo.getVertex(3);
		
		BuscaEmProfundidade bep = new BuscaEmProfundidade();
		bep.runAlgorithm(inicio);
	}
}
