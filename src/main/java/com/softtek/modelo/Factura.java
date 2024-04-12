package com.softtek.modelo;

import java.util.List;

public class Factura implements IImpuesto {

        private IImpuesto impuesto;
        private List<Producto> productos;

        public Factura(IImpuesto impuesto, List<Producto> productos) {
            this.impuesto = impuesto;
            this.productos = productos;
        }

        public double calcularTotalFactura() {
            double total = 0;
            for (Producto producto : productos) {
                total += producto.getPrecio();
            }
            // Aplicar impuesto
            total += impuesto.calcularImpuesto((Producto) productos);
            return total;
        }

    @Override
    public double calcularImpuesto(Producto p1) {
        return 0;
    }
}

