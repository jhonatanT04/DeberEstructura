/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.deberestructuraproductos.modelo;

/**
 *
 * @author venot
 */
public class Inventario {
    private Nodo<Producto> primerNodo;

    public void agregarProducto(Producto producto) {
        Nodo<Producto> nuevoNodo = new Nodo<>(producto);
        if (primerNodo == null) {
            primerNodo = nuevoNodo;
        } else {
            Nodo<Producto> nodoActual = primerNodo;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
    }

    public void eliminarProducto(String codigoProducto) {
        if (primerNodo == null) {
            return;
        }

        if (primerNodo.getValor().getCodigo().equals(codigoProducto)) {
            primerNodo = primerNodo.getSiguiente();
        } else {
            Nodo<Producto> nodoActual = primerNodo;
            while (nodoActual.getSiguiente() != null) {
                if (nodoActual.getSiguiente().getValor().getCodigo().equals(codigoProducto)) {
                    nodoActual.setSiguiente(nodoActual.getSiguiente().getSiguiente());
                    break;
                }
                nodoActual = nodoActual.getSiguiente();
            }
        }
    }
    
    
    public Nodo<Producto> getPrimerNodo() {
        return primerNodo;
    }
}
