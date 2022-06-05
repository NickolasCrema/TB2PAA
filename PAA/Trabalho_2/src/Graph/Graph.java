package Graph;

import java.util.ArrayList;

public class Graph {

	private ArrayList<Vertex> vertices;
	private ArrayList<Edge> edges;
	private Boolean directed;

	public Graph() {
		this.vertices = new ArrayList<Vertex>();
		this.edges = new ArrayList<Edge>();
	}

	public void addVertex(Integer data) {
		Vertex vertex = this.getVertex(data);
		if (vertex == null) {
			Vertex newVertex = new Vertex(data);
			this.vertices.add(newVertex);
		}
	}
	
	public Integer vertexCount() {
		return this.vertices.size();
	}

	public void addEdge(Integer start, Integer end, Integer weight) {
		if (!directed) {
			Vertex src = this.getVertex(start);
			Vertex dest = this.getVertex(end);
			if (src != null && dest != null) {
				Edge edge = new Edge(src, dest, weight);
				Edge reverseEdge = new Edge(dest, src, weight);
				this.edges.add(edge);
				this.edges.add(reverseEdge);
				src.addOutgoingEdge(edge);
//				src.addOutgoingEdge(reverseEdge);
				dest.addOutgoingEdge(reverseEdge);
//				dest.addOutgoingEdge(reverseEdge);
			}
		} 
		else {
			System.out.println("Error #000");
		}
	}

	public void addEdgeDirected(Integer start, Integer end, Integer weight) {
		if (directed) {
			Vertex src = this.getVertex(start);
			Vertex dest = this.getVertex(end);
			if (src != null && dest != null) {
				Edge edge = new Edge(src, dest, weight);
				this.edges.add(edge);
				src.addOutgoingEdge(edge);
				dest.addIncomingEdge(edge);
			}
		}
		else {
			System.out.println("Error #000");
		}
	}

	public Vertex getVertex(Integer data) {
		for (Vertex vertex : vertices) {
			if (vertex.getData() == data) {
				return vertex;
			}
		}
		return null;
	}

	public ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<Edge> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Edge> edges) {
		this.edges = edges;
	}

	public Boolean getDirected() {
		return directed;
	}

	public void setDirected(Boolean directed) {
		this.directed = directed;
	}
}
