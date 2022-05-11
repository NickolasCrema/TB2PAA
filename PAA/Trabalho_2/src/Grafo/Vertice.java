package Grafo;

import java.util.ArrayList;

public class Vertice {
	private Integer dado;
	private ArrayList<Aresta> arestasEntrada;
	private ArrayList<Aresta> arestasSaida;
	
	public Vertice() {}
	
	public Vertice(Integer dado) {
		this.dado = dado;
		this.arestasEntrada = new ArrayList<Aresta>();
		this.arestasSaida = new ArrayList<Aresta>();
	}
	
	public void adicionaArestaEntrada(Aresta aresta) {
		this.arestasEntrada.add(aresta);
	}
	
	public void adicionaArestaSaida(Aresta aresta) {
		this.arestasSaida.add(aresta);
	}

	public Integer getDado() {
		return dado;
	}

	public void setDado(Integer dado) {
		this.dado = dado;
	}

	public ArrayList<Aresta> getArestasEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(ArrayList<Aresta> arestasEntrada) {
		this.arestasEntrada = arestasEntrada;
	}

	public ArrayList<Aresta> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestasSaida(ArrayList<Aresta> arestasSaida) {
		this.arestasSaida = arestasSaida;
	}
}
