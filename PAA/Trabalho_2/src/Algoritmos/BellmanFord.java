package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Vertice;

public class BellmanFord {
	private ArrayList<Vertice> marcados;
	private ArrayList<Vertice> fila;

	public BellmanFord() {
		this.marcados = new ArrayList<Vertice>();
		this.fila = new ArrayList<Vertice>();
	}

	public void runAlgorithm(Vertice inicio, Grafo g) {
//		Vertice atual = inicio;
//		if (inicio.getDado() != destiny) {
//			marcados.add(inicio);
//			System.out.print(inicio.getDado() + " ");
//			for (int i = 0; i < inicio.getArestasSaida().size(); i++) {
//
//				Vertice proximo = inicio.getArestasSaida().get(i).getFim();
//				if (!marcados.contains(proximo)) {
//					distance += inicio.getArestasSaida().get(i).getPeso();
//					runAlgorithm(proximo, destiny, distance);
//				}
//			}
//		}
		int vertex = g.getVertices().size();
		int edges = g.getArestas().size();
		int[] dist = new int[vertex];
		
		for(int i=0; i<vertex; ++i) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		dist[inicio.getDado()] = 0;
		
		for(int i=1; i<vertex; ++i) {
			for(int j=0; j<edges; ++j) {
				int u = grafo.
			}
		}
	}

	public static void main(String[] args) {
		Grafo grafo = new Grafo(true);

		for (int i = 0; i < 5; i++) {
			grafo.adicionaVertice(i);
		}

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
		bf.runAlgorithm(inicio, 0, 0);

	}
}
