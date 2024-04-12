package com.softtek.presentacion;


import java.sql.SQLException;
import java.util.*;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import com.softtek.persistencia.AccesoOrder;
import com.softtek.modelo.OrderDetails;

public class ProbarOrder {
    public static void main(String[] args) {

        //Precio unitario Mayor que 30
        try {
            AccesoOrder accesoOrder = new AccesoOrder();
            List<OrderDetails> allOrders = accesoOrder.getOrdenMayor30();
            System.out.println("Detalles de órdenes:");
            for (OrderDetails order : allOrders) {
                System.out.println(order);
            }
            List<OrderDetails> ordenMayor30 = accesoOrder.getOrdenMayor30();
            System.out.println("\nDetalles de órdenes con precio unitario mayor que 30:");
            for (OrderDetails order : ordenMayor30) {
                System.out.println(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Ordenados de forma descendente por unit_price
        try {
            AccesoOrder accesoOrder = new AccesoOrder();
            List<OrderDetails> ordenDesc = accesoOrder.getOrdenDesc();
            System.out.println("Detalles de órdenes ordenados de forma descendente por precio unitario:");
            for (OrderDetails order : ordenDesc) {
                System.out.println(order);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Ordenar el detalle de órdenes con precio mínimo
        try {
            AccesoOrder accesoOrder = new AccesoOrder();
            OrderDetails orderWithMinPrice = accesoOrder.getOrdenMin();
            if (orderWithMinPrice != null) {
                System.out.println("Detalle de la orden con precio mínimo:");
                System.out.println(orderWithMinPrice);
            } else {
                System.out.println("No se encontró ninguna orden con precio mínimo.");
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Obtener estadísticas
        try {
            AccesoOrder accesoOrder = new AccesoOrder();
            DoubleSummaryStatistics estadisiticas = accesoOrder.getEstadisticas();

            System.out.println("Las estadísticas son: ");
            System.out.println("Cantidad: " + estadisiticas.getCount());
            System.out.println("Suma de todo: " + estadisiticas.getSum());
            System.out.println("Media: " + estadisiticas.getAverage());
            System.out.println("Max: " + estadisiticas.getMax());
            System.out.println("Min: " + estadisiticas.getMin());

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        //Obtener productos y suma de cantidades
        try {
            AccesoOrder accesoOrder = new AccesoOrder();
            Map<Integer, Integer> productQuantitiesSum = accesoOrder.getProductoYSuma();
            System.out.println("Productos y la suma de sus cantidades:");
            for (Map.Entry<Integer, Integer> entry : productQuantitiesSum.entrySet()) {
                System.out.println("Producto ID: " + entry.getKey() + ", Suma de Cantidades: " + entry.getValue());
            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}