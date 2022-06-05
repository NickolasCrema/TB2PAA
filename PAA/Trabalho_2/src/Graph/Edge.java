package Graph;

public class Edge implements Comparable<Edge>{
	private Integer weight;
	private Vertex src;
	private Vertex dest;
	
	public Edge() {}
	
	public Edge(Vertex start, Vertex end, Integer weight) {
		this.src = start;
		this.dest = end;
		this.weight = weight;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer peso) {
		this.weight = peso;
	}

	public Vertex getStart() {
		return src;
	}

	public void setStart(Vertex inicio) {
		this.src = inicio;
	}

	public Vertex getEnd() {
		return dest;
	}

	public void setEnd(Vertex fim) {
		this.dest = fim;
	}
	
	public int compareTo(Edge other) {
		return this.weight - other.weight;
	}
}
