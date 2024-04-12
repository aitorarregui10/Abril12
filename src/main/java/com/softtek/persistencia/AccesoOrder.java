package com.softtek.persistencia;

import com.softtek.modelo.OrderDetails;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AccesoOrder extends Conexion{
    public Statement sentencia;
    public ResultSet resultado;

    public List<OrderDetails> getOrdenMayor30() throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "SELECT * FROM order_details WHERE unit_price > 30";
        List<OrderDetails> orders = new ArrayList<>();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            orders.add(new OrderDetails(
                    resultado.getInt("order_id"),
                    resultado.getInt("product_id"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("quantity"),
                    resultado.getDouble("discount")
            ));
        }
        cerrarConexion();
        return orders;
    }

    public List<OrderDetails> getOrdenDesc() throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "SELECT * FROM order_details ORDER BY unit_price DESC";
        List<OrderDetails> orders = new ArrayList<>();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            orders.add(new OrderDetails(
                    resultado.getInt("order_id"),
                    resultado.getInt("product_id"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("quantity"),
                    resultado.getDouble("discount")
            ));
        }
        cerrarConexion();
        return orders;
    }

    public OrderDetails getOrdenMin() throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "SELECT * FROM order_details WHERE unit_price = (SELECT MIN(unit_price) FROM order_details)";
        OrderDetails ordenMin = null;
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        if (resultado.next()) {
            ordenMin = new OrderDetails(
                    resultado.getInt("order_id"),
                    resultado.getInt("product_id"),
                    resultado.getDouble("unit_price"),
                    resultado.getInt("quantity"),
                    resultado.getDouble("discount")
            );
        }
        cerrarConexion();
        return ordenMin;
    }

    public DoubleSummaryStatistics getEstadisticas() throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "SELECT quantity FROM order_details";
        DoubleSummaryStatistics estadisticas = new DoubleSummaryStatistics();
        sentencia = miConexion.createStatement();
        resultado = sentencia.executeQuery(sql);
        while (resultado.next()) {
            estadisticas.accept(resultado.getInt("quantity"));
        }
        cerrarConexion();
        return estadisticas;
    }
    public Map<Integer, Integer> getProductoYSuma() throws SQLException, ClassNotFoundException {
        abrirConexion();
        String sql = "SELECT product_id, SUM(quantity) AS total_quantity FROM order_details GROUP BY product_id";
        Map<Integer, Integer> productQuantitiesSum = new HashMap<>();
        PreparedStatement ps = miConexion.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int productId = rs.getInt("product_id");
            int totalQuantity = rs.getInt("total_quantity");
            productQuantitiesSum.put(productId, totalQuantity);
        }
        cerrarConexion();
        return productQuantitiesSum;
    }
}