package Arquivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Algoritmos.BuscaEmProfundidade;
import Grafo.Grafo;
import Grafo.Vertice;

public class LerArquivo {
	
	public LerArquivo() {}

	
	public Grafo geraGrafo(String path) throws IOException {
		Grafo grafo = new Grafo();
		BufferedReader br = new BufferedReader(new FileReader(path));
		String linha = "";
		linha = br.readLine();
		String[] vet = new String[2];
		vet = linha.split("=");
		if(vet[1]=="sim") {
			grafo.setOrientado(true);
		}
		else {
			grafo.setOrientado(false);
		}
		linha = br.readLine();
		vet = linha.split("=");
		int vertices = Integer.parseInt(vet[1]);
		for(int i=0; i<vertices; i++) {
			grafo.adicionaVertice(i);
		}
		vet = new String[4];
		while((linha = br.readLine()) != null) {
			vet = linha.split("[(,):]+");
			grafo.adicionaAresta(Integer.parseInt(vet[1]), Integer.parseInt(vet[2]), Integer.parseInt(vet[3]));
		}
		
		return grafo;
	}
	
	public static void main(String[] args) {
		LerArquivo la = new LerArquivo();
		try {
			Grafo grafo = la.geraGrafo("fonte1.txt.txt");
			Vertice vertice = grafo.getVertice(3);
			BuscaEmProfundidade bel = new BuscaEmProfundidade();
			bel.runAlgorithm(vertice);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
