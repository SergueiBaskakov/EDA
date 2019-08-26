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
public class NodoP {
    int data; //valor del nodo
    NodoP next; //puntero hacia el siguiente nodo
    NodoH nodoh; //puntero al primer sub-nodo(enlace)
    NodoH ultimo; //puntero al ultimo sub nodo(enlace)
    int n; //numero de caminos
    

    public NodoP(int data) {
        this.data=data;
        n=0;
    }

    public void InsertarNodoH(NodoP p) // enlaza este nodo con otro
    {
        NodoH nodo = new NodoH(p);
        if (n==0){ 
            nodoh=nodo;
            ultimo=nodo;
            n=n+1;
        }
        else if (n==1){
            nodoh.next=nodo;
            ultimo=nodo;
            n=n+1;
        }
        else{
            ultimo.next=nodo;
            ultimo=nodo;
            n=n+1;
        }
    }

}
