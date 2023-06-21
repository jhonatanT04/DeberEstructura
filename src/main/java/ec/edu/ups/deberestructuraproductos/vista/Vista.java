/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.deberestructuraproductos.vista;

import ec.edu.ups.deberestructuraproductos.controlador.Controlador;
import ec.edu.ups.deberestructuraproductos.modelo.HistorialVentas;
import ec.edu.ups.deberestructuraproductos.modelo.Nodo;
import ec.edu.ups.deberestructuraproductos.modelo.Producto;
import ec.edu.ups.deberestructuraproductos.modelo.Venta;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author venot
 */
public class Vista {
    private Controlador controlador;

    public Vista(Controlador controlador) {
        this.controlador = controlador;
    }

    public void mostrarMenu() {
        System.out.println("\n********Sistema de Gestión de Tienda********");
        System.out.println("1. Registrar nuevo producto");
        System.out.println("2. Realizar venta");
        System.out.println("3. Consultar inventario");
        System.out.println("4. Consultar historial de ventas");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opción: ");
    }

    public Producto ingresarNuevoProducto() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRegistrar nuevo producto");
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese la cantidad disponible: ");
        int cantidadDisponible = scanner.nextInt();

        return new Producto(nombre, codigo, precio, cantidadDisponible);
    }
    public Venta ingresarVenta() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nRealizar venta");
        System.out.print("Ingrese el código del producto: ");
        String codigoProducto = scanner.nextLine();
        System.out.print("Ingrese la cantidad a vender: ");
        int cantidad = scanner.nextInt();

        return new Venta(codigoProducto, cantidad);
    }

    public void mostrarInventario(Nodo<Producto> primerNodo) {
        System.out.println("\nInventario:");
        Nodo<Producto> nodoActual = primerNodo;
        while (nodoActual != null) {
            Producto producto = nodoActual.getValor();
            System.out.println("Nombre: " + producto.getNombre());
            System.out.println("Código: " + producto.getCodigo());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Cantidad Disponible: " + producto.getCantidadDisponible());
            System.out.println("-------------------------");
            nodoActual = nodoActual.getSiguiente();
        }
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
    public void mostrarHistorialVentas(HistorialVentas historialVentas) {
        System.out.println("\nHistorial de Ventas:");
        Stack<Venta> pilaVentas = historialVentas.getPilaVentas();
        for (Venta venta : pilaVentas) {
            System.out.println("Código Producto: " + venta.getCodigoProducto());
            System.out.println("Cantidad: " + venta.getCantidad());
            System.out.println("-------------------------");
        }
    }
}
