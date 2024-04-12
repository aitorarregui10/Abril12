package com.softtek.modelo;
import com.softtek.modelo.Producto;

public interface IImpuesto {
    //Atributos
    double impuesto = 1;

    double calcularImpuesto(Producto p1);
}
