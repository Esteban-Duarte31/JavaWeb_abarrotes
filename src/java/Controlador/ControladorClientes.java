/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Include.Cliente;
import Modelo.ModeloClientes;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ControladorClientes {

    public boolean crearCliente(Cliente c) {
        ModeloClientes modelop = new ModeloClientes();
        return modelop.crear_producto(c);
    }

    public ArrayList<Cliente> getViewClientes() {
        ModeloClientes modeloc = new ModeloClientes();
        return modeloc.getAllProductos();
    }

    public boolean deleteProducto(String id) {
        ModeloClientes mp = new ModeloClientes();
        return mp.deleteCliente(id);
    }

}
