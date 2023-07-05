/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo; 

import java.util.ArrayList;
import java.util.ArrayList;

/**
 *
 * @author hugo
 */
public class Vertice implements Comparable<Vertice> {

    public final String nome;
    public ArrayList<Aresta> adjacentes; //Lista de Aresta
    public ArrayList<Vertice> caminho; //Lista Adjacente
    public double menDistancia = Double.POSITIVE_INFINITY;

    public int compareTo(Vertice other) {
        return Double.compare(menDistancia, other.menDistancia);
    }

    public Vertice(String nome) {
        this.nome = nome;
        adjacentes = new ArrayList<Aresta>();
        caminho = new ArrayList<Vertice>();
    }

    public String toString() {
        return nome;
    }
}