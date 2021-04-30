/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Include.Producto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ModeloProductos extends Conexion {

    public boolean crear_producto(Producto p) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "call insertProducto(?,?,?,?,?,?)";
            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getId());
            pst.setString(2, p.getDescripcion());
            pst.setInt(3, p.getStock());
            pst.setString(4, p.getCategoria());
            pst.setInt(5, p.getPrecio());
            pst.setString(6, p.getImagen());

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

    public ArrayList<Producto> getAllProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "call selectAllproductos()";
            pst = getConnection().prepareCall(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                productos.add(new Producto(rs.getString("idProducto"), rs.getString("descripcion"), rs.getInt("stock"), rs.getString("categoria"), rs.getInt("precio"), rs.getString("imagen")));
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

    public Producto getProducto(String idProducto) {
        Producto producto = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            String sql = "select * from productos where idProducto = ?";
            pst = getConnection().prepareCall(sql);
            pst.setString(1, idProducto);
            rs = pst.executeQuery();
            while (rs.next()) {
                producto = (new Producto(rs.getString("idProducto"), rs.getString("descripcion"), rs.getInt("stock"), rs.getString("categoria"), rs.getInt("precio"), rs.getString("imagen")));
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

        return producto;
    }

    public boolean deleteProducto(String idProducto) {

        boolean flag = false;
        PreparedStatement pst = null;
        try {
            String sql = "call deleteProducto(?)";
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

    public boolean update_producto(Producto p) {
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            String sql = "call updateProducto(?,?,?,?,?)";

            pst = getConnection().prepareStatement(sql);
            pst.setString(1, p.getId());
            pst.setString(2, p.getDescripcion());
            pst.setInt(3, p.getStock());
            pst.setString(4, p.getCategoria());
            pst.setInt(5, p.getPrecio());

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

//    public static void main(String[] args) {
//        ModeloProductos mp = new ModeloProductos();
////AGREGAR
////        System.out.println( mp.crear_producto(new Producto("jab", "jabon", 3, "Aseo", 1300,"imgUpload/productos/tomat.jpg")));
//
////MOSTRAR
////        for (Producto pd : mp.getAllProductos()) {
////            System.out.println(pd.getId());
////        }
//    }
}
