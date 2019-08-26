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
public class NodoH {
    NodoP orig; //puntero al nodo original (NodoP)
    NodoH next; //puntero al siguiente nodo (camino paralelo)
    int state; //indica si ya se recorrio este camino (0 indica que no)

    public NodoH(NodoP orig) {
        this.orig = orig;
        this.state = 0;
    }
}
