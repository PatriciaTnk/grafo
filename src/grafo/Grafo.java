/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import javax.swing.JOptionPane;

/**
 *
 * @author hugo
 */
public class Grafo {

    private ArrayList<Vertice> vertices;

    public Grafo(int numVertices) {
        vertices = new ArrayList<Vertice>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            vertices.add(new Vertice("v" + Integer.toString(i)));
        }
    }

    public void addAresta(int origem, int dest, int peso) {
        Vertice s = vertices.get(origem);
        Aresta new_edge = new Aresta(vertices.get(dest), peso);
        s.adjacentes.add(new_edge);
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public Vertice getVertice(int vert) {
        return vertices.get(vert);
    }

    public String toString() {//
        String texto = "";//

        for (Vertice v : getVertices()) {//
            texto += v.nome + " ->";//
            for (Aresta a : v.adjacentes) {//
                texto += a.fim.nome + "|" + a.peso + ", ";//
            }
            texto += "\n";///
        }

        return texto;//

    }

    public String gerarStringDijkstra() {
        String texto = "";

        for (Vertice v : getVertices()) {
            texto += "Vertice - " + v + " , Dist - " + v.menDistancia + " , Caminho - ";
            for (Vertice caminhoVertice : v.caminho) {
                texto += caminhoVertice + " ";
            }

            texto += "" + v;
            texto += "\n";
        }
        return texto;
    }

    public void calcular(Vertice origem) {
        // Algo:
        // 1. Take the unvisited node with minimum peso.
        // 2. Visit all its adjacentes.
        // 3. Update the distances for all the adjacentes (In the Priority Queue).
        // Repeat the process till all the connected nodes are visited.

        origem.menDistancia = 0;
        PriorityQueue<Vertice> fila = new PriorityQueue<Vertice>();
        fila.add(origem);

        while (!fila.isEmpty()) {

            Vertice u = fila.poll();

            for (Aresta adjacente : u.adjacentes) {
                Double novaDist = u.menDistancia + adjacente.peso;

                if (adjacente.fim.menDistancia > novaDist) {
                    // Remove the node from the fila to update the distance value.
                    fila.remove(adjacente.fim);
                    adjacente.fim.menDistancia = novaDist;

                    // Take the caminho visited till now and add the new node.
                    adjacente.fim.caminho = new ArrayList<Vertice>(u.caminho);
                    adjacente.fim.caminho.add(u);

                    //Reenter the node with new distance.
                    fila.add(adjacente.fim);
                }
            }
        }
    }

    public double somaPeso(int vertEscolhido) {
        int soma = 200;
        double x = 0.0;

        for (int i = 0; i < this.vertices.size(); ++i) {
            System.out.println("Vertice");
            for (int j = 0; j < this.vertices.get(i).adjacentes.size(); ++i) {
                System.out.println("Adjacentes");
                if (this.vertices.get(i).adjacentes.get(j).fim.nome.equals("v" + Integer.toString(vertEscolhido))) {
                    System.out.println("QQQQQ");
                    x += this.vertices.get(i).adjacentes.get(j).peso;
                }
            }
        }

        soma = (int) x;

        return soma;
    }

    public int varreGrafo(int qtdArestas) {
        int resul = 0;
        for (Vertice igual : vertices) {
            int qtdApareceVertice = 0;
            System.out.println("Entrei no vertice");

            for (Aresta listaAdjacentes : igual.adjacentes) {
                System.out.println("Entrei na lista de adjacentes");

                for (Vertice vert : vertices) {
                    if (listaAdjacentes.fim.equals(vert)) {
                        System.out.println("Comparei se o fim é o vertice que eu estou");
                        qtdApareceVertice += 1;
                    }
                }
            }
            
            if (qtdApareceVertice == qtdArestas) {
                System.out.println("Agora vamo ver se nao entra");
                resul += 1;
            }
        }
        return resul;
    }
    
        public void mostraAdjacentes(int verificVert) {

        List<Vertice> listaAdjacentes = new ArrayList<>();
        
        //essa parte para correr todas as listas de adjacentes de cada vertice do grafo
        for (Vertice igual : vertices) {

            for (Aresta arestaList : igual.adjacentes) {
                
                    if (arestaList.fim.nome.equals("v" + verificVert)){
                        listaAdjacentes.add(igual);
                    }
                    
                }
            
            }
        
        JOptionPane.showMessageDialog(null, "\nVertices adjacentes: " + listaAdjacentes.toString());

    }

}
