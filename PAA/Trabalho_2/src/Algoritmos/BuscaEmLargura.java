package Algoritmos;

import java.util.ArrayList;

import Grafo.Grafo;
import Grafo.Vertice;

public class BuscaEmLargura {
	private ArrayList<Vertice> marcados;
	private ArrayList<Vertice> fila;
	private Vertice atual;
	
	public BuscaEmLargura(Vertice inicio) {
		this.atual = inicio;
		this.marcados = new ArrayList<Vertice>();
		this.fila = new ArrayList<Vertice>();
	}
	
	public void runAlgorithm() {
		marcados.add(atual);
		System.out.print(atual.getDado());
		fila.add(atual);
		while(fila.size() > 0) {
			Vertice visitado = fila.get(0);
			for(int i=0; i < visitado.getArestasSaida().size(); i++) {
				Vertice proximo = visitado.getArestasSaida().get(i).getFim();
				if(!marcados.contains(proximo)) {
					marcados.add(proximo);
					System.out.print(" -> " + proximo.getDado());
					fila.add(proximo);
				}
			}
			fila.remove(0);
		}
	}
	
	public static void main(String[] args) {
		Grafo grafo = new Grafo();
		grafo.adicionaVertice(0);
		grafo.adicionaVertice(1);
		grafo.adicionaVertice(2);
		grafo.adicionaVertice(3);
		grafo.adicionaVertice(4);
		grafo.adicionaVertice(5);
		grafo.adicionaVertice(6);
		
		grafo.adicionaArestaOrientado(0, 3, 5);
		grafo.adicionaArestaOrientado(0, 5, 11);
		grafo.adicionaArestaOrientado(0, 2, 8);
		grafo.adicionaArestaOrientado(1, 3, 2);
		grafo.adicionaArestaOrientado(1, 4, 18);
		grafo.adicionaArestaOrientado(2, 3, 7);
		grafo.adicionaArestaOrientado(2, 5, 4);
		grafo.adicionaArestaOrientado(2, 4, 3);
		grafo.adicionaArestaOrientado(4, 5, -1);
		grafo.adicionaArestaOrientado(4, 6, 5);
		grafo.adicionaArestaOrientado(5, 6, 17);
		
		Vertice inicio = grafo.getVertice(2);
		
		BuscaEmLargura busca = new BuscaEmLargura(inicio);
		busca.runAlgorithm();
	}
}
