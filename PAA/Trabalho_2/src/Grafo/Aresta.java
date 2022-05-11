package Grafo;

public class Aresta {
	private Integer peso;
	private Vertice inicio;
	private Vertice fim;
	
	public Aresta(Vertice inicio, Vertice fim, Integer peso) {
		this.inicio = inicio;
		this.fim = fim;
		this.peso = peso;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Vertice getInicio() {
		return inicio;
	}

	public void setInicio(Vertice inicio) {
		this.inicio = inicio;
	}

	public Vertice getFim() {
		return fim;
	}

	public void setFim(Vertice fim) {
		this.fim = fim;
	}
}
