/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Include.Venta;
import Modelo.ModeloVentas;

/**
 *
 * @author Esteban
 */
public class ControladorVenta {
    
    
     public boolean crearVenta(Venta c) {
         ModeloVentas modelop = new ModeloVentas();
        return modelop.crear_venta(c);
    }

    public Object getViewVentas() {
         ModeloVentas modeloc = new ModeloVentas();
        return modeloc.getAllProductos();
    }

    public boolean deleteProducto(String idProducto) {

 ModeloVentas mp = new ModeloVentas();
        return mp.deleteCliente(idProducto);
    }
    
}
