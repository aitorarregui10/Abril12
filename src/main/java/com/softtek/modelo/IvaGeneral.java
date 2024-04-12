package com.softtek.modelo;
import com.softtek.modelo.Producto;

public class IvaGeneral implements IImpuesto {

    @Override
    public double calcularImpuesto(Producto p1) {
        double impuesto = p1.getPrecio()+(p1.getPrecio() * 0.21);
        return impuesto;
    }

}
