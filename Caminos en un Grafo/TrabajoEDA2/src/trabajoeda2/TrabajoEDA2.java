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
import java.util.*;
public class TrabajoEDA2 {

    /**
     * @param args the command line arguments
     */
    public static void recorrido(int[] v, NodoP actual, NodoP llegada, int n)//funcion para imprimir todos los caminos
    {
        v[n]=actual.data;//"v" almacena los datos a imprimir y "actual.dato" es el dato del nodo
        if (actual != llegada && actual!=null){ // analiza el nodo para ver si se llego al destino
            if (actual.nodoh!=null){ // reviza si el nodo lleva a otros nodos
                NodoH temp = new NodoH(null); // se crea un nodo temporal
                temp = actual.nodoh;
                while (temp!=null){ //recorre todos los nodos a los que podria llevar el nodo actual
                    if (temp.state==0){ // revisa si ya se recorrio ese camino (0 indica que no)
                        temp.state=1; 
                        recorrido(v,temp.orig,llegada,n+1); // se recorren los sub-caminos volviendo a llamar a la funcion "recorrido"
                        temp.state=0;
                    }
                    temp = temp.next;
                }
            }
        }
        else if (actual == llegada){
            for (int i=0; i!=n; i++){// se imprime el camino
                System.out.print(v[i]+"-");
            }
            System.out.println(v[n]);
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        int a, n1, n2; // "a" es el numero de nodos en el grafo, "n1" es el nodo que inicia el enlace y "n2" es el nodo en el que finaliza el enlace
        Scanner scan = new Scanner(System.in);
        System.out.print("Ingresar el numero de nodos en el grafo: ");
        a=scan.nextInt();
        Grafo grafo = new Grafo(a); // se crea un grafo
        for (int i=1; i!=a+1; i++){ //se crea los nodos del grafo
            grafo.insert(i);
        }
        System.out.println("Ingrese los nodos a enlazar(nodo1-->nodo2) o '0 0' para finalizar: ");
        while (1==1){
            n1 = scan.nextInt();
            n2 = scan.nextInt();
            if (n1>0 && n2>0){
                grafo.enlazar(n1-1, n2-1);// se crea el enlace
            }
            else {
                break;
            }
        }
        System.out.println("Los caminos independientes son:");
        grafo.calcN(); // se calcula la longitud maxima de un camino
        int v[] = new int[grafo.n]; // se crea un vector que almacenara los caminos
        recorrido(v,grafo.first,grafo.last,0); // se hallan e imprimen todos los caminos
    }
    
}
