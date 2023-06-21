/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.deberestructuraproductos.modelo;

import java.util.Stack;

/**
 *
 * @author venot
 */
public class HistorialVentas {
    private Stack<Venta> pilaVentas;

    public HistorialVentas() {
        pilaVentas = new Stack<>();
    }

    public void agregarVenta(Venta venta) {
        pilaVentas.push(venta);
    }

    /*public Venta eliminarVenta() {
        if (!pilaVentas.isEmpty()) {
            return pilaVentas.pop();
        }
        return null;
    }*/

    public Stack<Venta> getPilaVentas() {
        return pilaVentas;
    }

    public void setPilaVentas(Stack<Venta> pilaVentas) {
        this.pilaVentas = pilaVentas;
    }
    
}
