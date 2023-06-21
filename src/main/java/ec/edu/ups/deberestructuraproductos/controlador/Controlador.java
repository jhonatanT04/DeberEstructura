/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.deberestructuraproductos.controlador;

import ec.edu.ups.deberestructuraproductos.modelo.HistorialVentas;
import ec.edu.ups.deberestructuraproductos.modelo.Inventario;
import ec.edu.ups.deberestructuraproductos.modelo.Nodo;
import ec.edu.ups.deberestructuraproductos.modelo.Producto;
import ec.edu.ups.deberestructuraproductos.modelo.Venta;

/**
 *
 * @author venot
 */
public class Controlador {
    private Inventario inventario;
    private HistorialVentas historialVentas;

    public Controlador(Inventario inventario, HistorialVentas historialVentas) {
        this.inventario = inventario;
        this.historialVentas = historialVentas;
    }

    public void registrarNuevoProducto(Producto producto) {
        inventario.agregarProducto(producto);
        System.out.println("Producto registrado correctamente.");
    }

    public void realizarVenta(Venta venta) {
        String codigoProducto = venta.getCodigoProducto();
        int cantidad = venta.getCantidad();
        Producto producto = buscarProducto(codigoProducto);
        if (producto != null) {
            if (producto.getCantidadDisponible() >= cantidad) {
                producto.setCantidadDisponible(producto.getCantidadDisponible() - cantidad);
                historialVentas.agregarVenta(venta);
                System.out.println("Venta realizada correctamente.");
            } else {
                System.out.println("No hay stock disponible suficiente.");
            }
        } else {
            System.out.println("Producto no encontrado.");
        }
    }
    public Nodo<Producto> consultarInventario() {
        return inventario.getPrimerNodo();
    }

    //public Venta eliminarVenta() {
      //  return historialVentas.eliminarVenta();
    //}

    private Producto buscarProducto(String codigoProducto) {
        Nodo<Producto> nodoActual = inventario.getPrimerNodo();
        while (nodoActual != null) {
            Producto producto = nodoActual.getValor();
            if (producto.getCodigo().equals(codigoProducto)) {
                return producto;
            }
            nodoActual = nodoActual.getSiguiente();
        }
        return null;
    }
    
}
