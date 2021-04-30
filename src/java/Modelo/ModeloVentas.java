/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Include.Venta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ModeloVentas extends Conexion{
    
     public boolean crear_venta(Venta p) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "call insertVenta(?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getIdCliente());
            pst.setString(2, p.getCliente());
            pst.setString(3, p.getProducto());
            pst.setString(4, p.getCantidad());
            pst.setString(5, p.getTotal());
            pst.setString(6, p.getFecha());

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

    public ArrayList<Venta> getAllProductos() {

ArrayList<Venta> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllventas()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(new Venta(rs.getInt("idVenta"), rs.getString("idCliente"), rs.getString("cliente"), rs.getString("producto"), rs.getString("cantidad"),rs.getString("total"),rs.getString("fecha")));
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

    public boolean deleteCliente(String idProducto) {
        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call deleteVenta(?)";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, idProducto);
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
