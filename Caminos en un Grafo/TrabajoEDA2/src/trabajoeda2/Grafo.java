/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajoeda2;

/**
 *
 * @author Computadora
 */
public class Grafo {
    NodoP first; //nodo inicial
    NodoP last; //nodo final
    int n; //longitud maxima de un camino
    int m; //cantidad de nodos en el grafo
    NodoP [] lista; //arreglo de nodos

    public Grafo(int a)// "a" es el numero de nodos que soporta el grafo 
    {
        n=0;
        m=0;
        lista=new NodoP[a];
    }
    public void enlazar(int a, int b) // enlaza dos nodos
    {
        lista[a].InsertarNodoH(lista[b]);
    }
    public void calcN() //calcula la longitud maxima de un camino
    {
        n=1;
        NodoP temp = new NodoP(0);
        temp = first;
        while(temp!=null){
            n=n+temp.n;
            temp=temp.next;
        }
    }
    public void insert(int a) //crea e inserta un nuevo nodo
    {
        NodoP nodo = new NodoP(a);
        if (first==null){
            first=nodo;
            last=nodo;
            lista[m]=nodo;
            m=m+1;
        }
        else if (first==last){
            first.next=nodo;
            last=nodo;
            lista[m]=nodo;
            m=m+1;
        }
        else{
            last.next=nodo;
            last=nodo;
            lista[m]=nodo;
            m=m+1;
        }
    }
    
}
