package com.softtek.presentacion;

import com.softtek.modelo.IImpuesto;
import com.softtek.modelo.IvaGeneral;
import com.softtek.modelo.IvaSuperReducido;
import com.softtek.modelo.Producto;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de productos
        Producto producto1 = new Producto("Camisa", 50.0);
        Producto producto2 = new Producto("Pantalón", 30.0);

        // Crear instancias de impuestos
        IImpuesto ivaGeneral = new IvaGeneral();
        IImpuesto ivaSuperReducido = new IvaSuperReducido();

        // Ejemplo de uso
        double impuestoProducto1 = ivaGeneral.calcularImpuesto(producto1);
        double impuestoProducto2 = ivaSuperReducido.calcularImpuesto(producto2);

        // Imprimir resultados
        System.out.println("Impuesto de producto 1 (IVA General): " + impuestoProducto1);
        System.out.println("Impuesto de producto 2 (IVA Super Reducido): " + impuestoProducto2);
    }
}
