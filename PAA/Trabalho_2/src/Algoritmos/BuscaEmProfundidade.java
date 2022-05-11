package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Vertice;

public class BuscaEmProfundidade {

	private ArrayList<Vertice> marcados;
	
	public BuscaEmProfundidade() {
		this.marcados = new ArrayList<Vertice>();
	}
	
	public void runAlgorithm(Vertice prox) {
		marcados.add(prox);
		System.out.print(prox.getDado() + " ");
		for(int i=0; i<prox.getArestasSaida().size(); i++) {
			Vertice proximo = prox.getArestasSaida().get(i).getFim();
			if(!marcados.contains(proximo)) {
				runAlgorithm(proximo);
			}
		}
		
	}
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo(true);
		grafo.adicionaVertice(0);
		grafo.adicionaVertice(1);
		grafo.adicionaVertice(2);
		grafo.adicionaVertice(3);
		grafo.adicionaVertice(4);
		grafo.adicionaVertice(5);
		grafo.adicionaVertice(6);
		
		grafo.adicionaAresta(0, 3, 5);
		grafo.adicionaAresta(0, 5, 11);
		grafo.adicionaAresta(0, 2, 8);
		grafo.adicionaAresta(1, 3, 2);
		grafo.adicionaAresta(1, 4, 18);
		grafo.adicionaAresta(2, 3, 7);
		grafo.adicionaAresta(2, 5, 4);
		grafo.adicionaAresta(2, 4, 3);
		grafo.adicionaAresta(4, 5, -1);
		grafo.adicionaAresta(4, 6, 5);
		grafo.adicionaAresta(5, 6, 17);
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
		
		Vertice inicio = grafo.getVertice(2);
		
		BuscaEmProfundidade bep = new BuscaEmProfundidade();
		bep.runAlgorithm(inicio);
	}
}
