/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafo;

/**
 *
 * @author hugo
 */
public class Aresta {

    public final Vertice fim;
    public final double peso;

    public Aresta(Vertice fim, double peso) {
        this.fim = fim;
        this.peso = peso;
    }
}