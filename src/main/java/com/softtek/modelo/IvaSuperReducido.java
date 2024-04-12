package com.softtek.modelo;

public class IvaSuperReducido implements IImpuesto{
    @Override
    public double calcularImpuesto(Producto p1) {
        double impuesto = p1.getPrecio()+(p1.getPrecio() * 0.04);
        return impuesto;
    }
}
