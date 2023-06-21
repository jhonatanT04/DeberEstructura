/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ec.edu.ups.deberestructuraproductos;

import ec.edu.ups.deberestructuraproductos.controlador.Controlador;
import ec.edu.ups.deberestructuraproductos.modelo.HistorialVentas;
import ec.edu.ups.deberestructuraproductos.modelo.Inventario;
import ec.edu.ups.deberestructuraproductos.modelo.Nodo;
import ec.edu.ups.deberestructuraproductos.modelo.Producto;
import ec.edu.ups.deberestructuraproductos.modelo.Venta;
import ec.edu.ups.deberestructuraproductos.vista.Vista;
import java.util.Scanner;

/**
 *
 * @author venot
 */
public class DeberEstructuraProductos {

    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        HistorialVentas historialVentas = new HistorialVentas();
        Controlador controlador = new Controlador(inventario, historialVentas);
        Vista vista = new Vista(controlador);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            vista.mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine();
        switch (opcion) {
                case 1:
                    Producto nuevoProducto = vista.ingresarNuevoProducto();
                    controlador.registrarNuevoProducto(nuevoProducto);
                    break;
                case 2:
                    Venta venta = vista.ingresarVenta();
                    controlador.realizarVenta(venta);
                    break;
                case 3:
                    System.out.println("-------------------------");
                    Nodo<Producto> inventarioActual = controlador.consultarInventario();
                    vista.mostrarInventario(inventarioActual);
                    break;
                case 4:
                    
                    if (historialVentas != null) {
                        System.out.println("-------------------------");
                        vista.mostrarHistorialVentas(historialVentas);
                    } else {
                        System.out.println("No hay ventas registradas en el historial.");
                    }
                    break;
            }
        } while (opcion != 0);
    }
}
