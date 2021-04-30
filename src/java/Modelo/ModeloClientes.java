/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Include.Cliente;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ModeloClientes extends Conexion{
    
     public boolean crear_producto(Cliente p) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "call insertCliente(?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getIdCliente());
            pst.setString(2, p.getNombres());
            pst.setInt(3, p.getEdad());
            pst.setString(4, p.getTelefono());
            pst.setString(5, p.getDireccion());

//            si es igual a uno se ejecuto correctamente
            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {
            }
        }
        return flag;
    }
    
     
     
     
     public ArrayList<Cliente> getAllProductos() {
        ArrayList<Cliente> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllClientes()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(new Cliente(rs.getString("idCliente"), rs.getString("nombres"), rs.getInt("edad"), rs.getString("telefono"), rs.getString("direccion")));
            }

        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {

            }
        }

        return productos;
    }
     
     
     
     
     
     public boolean deleteCliente(String idCliente) {

        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call deleteCliente(?)";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, idCliente);
            if (pst.executeUpdate() == 1) {
                flag = true;
            }
        } catch (Exception e) {
        } finally {
            try {
                if (getConnection() != null) {
                    getConnection().close();
                }
                if (pst != null) {
                    pst.close();
                }
            } catch (Exception e) {

            }
        }
        return flag;
    }
     
     
     
     
}
