package Arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Algoritmos.BellmanFord;
import Graph.Graph;
import Graph.Vertex;

public class LerArquivo {

	public LerArquivo() {
	}

	public Graph geraGrafo(String path) throws IOException {
		Graph graph = new Graph();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = "";
		line = br.readLine();
		String[] vet = new String[2];
		vet = line.split("=");
		if (vet[1].equals("sim")) {
			graph.setDirected(true);
		} else {
			graph.setDirected(false);
		}
		line = br.readLine();
		vet = line.split("=");
		int vertices = Integer.parseInt(vet[1]);
		for (int i = 0; i < vertices; i++) {
			graph.addVertex(i);
		}
		vet = new String[4];
		if (graph.getDirected() == false) {
			while ((line = br.readLine()) != null) {
				vet = line.split("[(,):]+");
				graph.addEdge(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Integer.parseInt(vet[3]));
			}
		}
		else {
			while ((line = br.readLine()) != null) {
				vet = line.split("[(,):]+");
				graph.addEdgeDirected(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Integer.parseInt(vet[3]));
			}
		}

		return graph;
	}

	public static void main(String[] args) {
		LerArquivo la = new LerArquivo();
		try {
			Graph grafo = la.geraGrafo("fonte2.txt");
			Vertex vertice = grafo.getVertex(3);
			int size = grafo.getVertices().size();
			BellmanFord bel = new BellmanFord(size);
			bel.runAlgorithm(grafo, 1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
