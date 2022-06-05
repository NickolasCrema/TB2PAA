package Graph;

import java.util.ArrayList;

public class Vertex {
	private Integer data;
	private ArrayList<Edge> incomingEdge;
	private ArrayList<Edge> outgoingEdge;
	
	public Vertex() {}
	
	public Vertex(Integer data) {
		this.data = data;
		this.incomingEdge = new ArrayList<Edge>();
		this.outgoingEdge = new ArrayList<Edge>();
	}
	
	public void addIncomingEdge(Edge edge) {
		this.incomingEdge.add(edge);
	}
	
	public void addOutgoingEdge(Edge edge) {
		this.outgoingEdge.add(edge);
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public ArrayList<Edge> getIncomingEdge() {
		return incomingEdge;
	}

	public void setIncomingEdge(ArrayList<Edge> incomingEdge) {
		this.incomingEdge = incomingEdge;
	}

	public ArrayList<Edge> getOutgoingEdge() {
		return outgoingEdge;
	}

	public void setOutgoingEdge(ArrayList<Edge> outgoingEdge) {
		this.outgoingEdge = outgoingEdge;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "vertex data: " + this.getData();
	}
}
