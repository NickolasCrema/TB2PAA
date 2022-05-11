package Grafo;

import java.util.ArrayList;

public class Grafo {

	private ArrayList<Vertice> vertices;
	private ArrayList<Aresta> arestas;
	private Boolean orientado;

	public Grafo() {
		this.vertices = new ArrayList<Vertice>();
		this.arestas = new ArrayList<Aresta>();
	}

	public void adicionaVertice(Integer dado) {
		Vertice vertice = this.getVertice(dado);
		if (vertice == null) {
			Vertice novoVertice = new Vertice(dado);
			this.vertices.add(novoVertice);
		}
	}
	
	public Integer vertexCount() {
		return this.vertices.size();
	}

	public void adicionaAresta(Integer dadoInicio, Integer dadoFim, Integer peso) {
		if (!orientado) {
			Vertice inicio = this.getVertice(dadoInicio);
			Vertice fim = this.getVertice(dadoFim);
			if (inicio != null && fim != null) {
				Aresta aresta = new Aresta(inicio, fim, peso);
				Aresta arestaInversa = new Aresta(fim, inicio, peso);
				this.arestas.add(aresta);
				this.arestas.add(arestaInversa);
				inicio.adicionaArestaSaida(aresta);
				inicio.adicionaArestaSaida(arestaInversa);
				fim.adicionaArestaSaida(aresta);
				fim.adicionaArestaSaida(arestaInversa);
			}
		} 
		else {
			System.out.println("Error #000");
		}
	}

	public void adicionaArestaOrientado(Integer dadoInicio, Integer dadoFim, Integer peso) {
		if (orientado) {
			Vertice inicio = this.getVertice(dadoInicio);
			Vertice fim = this.getVertice(dadoFim);
			if (inicio != null && fim != null) {
				Aresta aresta = new Aresta(inicio, fim, peso);
				this.arestas.add(aresta);
				inicio.adicionaArestaSaida(aresta);
				fim.adicionaArestaEntrada(aresta);
			}
		}
		else {
			System.out.println("Error #000");
		}
	}

	public Vertice getVertice(Integer dado) {
		for (Vertice vertice : vertices) {
			if (vertice.getDado() == dado) {
				return vertice;
			}
		}
		return null;
	}

	public ArrayList<Vertice> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertice> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Aresta> getArestas() {
		return arestas;
	}

	public void setArestas(ArrayList<Aresta> arestas) {
		this.arestas = arestas;
	}

	public Boolean getOrientado() {
		return orientado;
	}

	public void setOrientado(Boolean orientado) {
		this.orientado = orientado;
	}
}
