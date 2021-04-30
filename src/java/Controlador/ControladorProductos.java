/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Include.Producto;
import Modelo.ModeloProductos;
import java.util.ArrayList;

/**
 *
 * @author Esteban
 */
public class ControladorProductos {

    public boolean crearProducto(Producto p) {
        ModeloProductos modelop = new ModeloProductos();
        return modelop.crear_producto(p);
    }

//    public String getViewProductos() {
//        String htmlcode = "";
//        ModeloProductos modelop = new ModeloProductos();
//        int i = 0;
//        for (Producto p : modelop.getAllProductos()) {
//            
//            
////            PARA VINCULOS
//// <a href='buscarProducto.jsp?searchProducto="var"'></a>
//
//            htmlcode += "<tr> "
//                    + "     <td id='idProducto'>" + p.getId() + "</td>"
//                    + "     <td>" + p.getDescripcion() + "</td>"
//                    + "     <td>" + p.getStock() + "</td>"
//                    + "     <td>" + p.getCategoria() + "</td>"
//                    + "     <td>" + p.getPrecio() + "</td>"
//                    + "     <td>   <img src='" + p.getImagen() + "'  WIDTH=100 HEIGHT=100 class='img-fluid'> </td>"
//                    + "     <td>  <a id='btn-modificar'   href='ModificarProducto.jsp?idMod="+p.getId()+"'>Modificar</a>                    <a id='btn-eliminar'  href=''>eliminar</a>  </td>"
//                    + "  </tr> ";
//
//        }
//        System.out.println("html: " + htmlcode);
//        return htmlcode;
//    }
    
    
    
    public ArrayList<Producto> getViewProductos() {

        ModeloProductos modelop = new ModeloProductos();

        return modelop.getAllProductos();
    }

    public String getDetallesProductos(String idProducto) {

        String htmlcode = "";
        try {
            Producto pr = new ModeloProductos().getProducto(idProducto);

            htmlcode = "<h2>Id del prducto: " + pr.getId() + "</h2>"
                    + "<h2>Descripcion: " + pr.getDescripcion() + " </h2>"
                    + "<h2>Stock: " + pr.getStock() + " </h2>"
                    + "<h2>Categoria: " + pr.getPrecio() + " </h2>"
                    + "<h2>Precio: " + pr.getDescripcion() + " </h2>"
                    + "<h2>Imagen: <br> <img src='" + pr.getImagen() + "'  WIDTH=200 HEIGHT=200 class='img-fluid'></h2>";
            return htmlcode;

        } catch (Exception e) {
            return null;
        }

    }

    public boolean deleteProducto(String id) {
        ModeloProductos mp = new ModeloProductos();
        return mp.deleteProducto(id);
    }

    public String getEditViewProducto(String idProducto) {
        ModeloProductos mp = new ModeloProductos();
        Producto pr = mp.getProducto(idProducto);
        String htmlcode = "";
        htmlcode += " <div class=\"container\"> \n"
                + "\n"
                + "                                    <form  name=\"formMofificar\"  id=\"form_Mod\">\n"
                + "\n"
                + "\n"
                + "\n"
                + "                                        <div class=\"form-group row\">\n"
                + "                                            <label for=\"idProducto\" class=\"col-lg-2 col-form-label\">Id del producto:</label>\n"
                + "                                            <div class=\"col-lg-5\">\n"
                + "                                                <input type=\"text\" class=\"form-control\" id=\"idProducto\" name=\"idProducto\"\n"
                + "                                                       value='" + pr.getId() + "' readonly=\"\" >\n"
                + "                                            </div>\n"
                + "                                        </div>\n"
                + "\n"
                + "\n"
                + "                                        <div class=\"form-row\">\n"
                + "                                            <div class=\"form-group col-xl-6\">\n"
                + "                                                <label for=\"descripcion\">Descripción: </label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" id=\"descripcion\" name=\"descripcion\"\n"
                + "                                                       PATTERN=\"[A-Za-z]+\" onkeypress=\"return onlyAlpha(evt)\" value='" + pr.getDescripcion() + "' required>\n"
                + "                                            </div>\n"
                + "\n"
                + "                                            <div class=\"form-group col-xl-6\">\n"
                + "                                                <label for=\"stock\">Stock:</label>\n"
                + "                                                <input type=\"text\" class=\"form-control\" id=\"stock\" name=\"stock\"\n"
                + "                                                       pattern=\"[0-9]+\" min=\"0\" onkeypress=\"return onlyNums(evt)\" value='" + pr.getStock() + "' required>\n"
                + "                                            </div>\n"
                + "\n"
                + "                                        </div>\n"
                + "\n"
                + "\n"
                + "                                        <div class=\"form-row\">\n"
                + "                                            <div class=\"form-group col-xl-6\">\n"
                + "                                                <label for=\"categoria\">Categoria:</label>\n"
                + "                                                <select class=\"form-control\" id=\"categoria\" value='" + pr.getCategoria() + "' name=\"categoria\">\n"
                + "                                                    <option>Frutas y Verduras</option>\n"
                + "                                                    <option>Aseo</option>\n"
                + "                                                    <option>viveres</option>\n"
                + "                                                    <option>Otros</option>\n"
                + "\n"
                + "                                                </select>\n"
                + "                                            </div>\n"
                + "\n"
                + "                                            <div class=\"form-group col-xl-6\">\n"
                + "                                                <label for=\"precio\">Precio:</label>\n"
                + "                                                <input type=\"number\" class=\"form-control\" value='" + pr.getPrecio() + "' id=\"precio\" name=\"precio\"\n"
                + "                                                       min=\"200\" onkeypress=\"return onlyNums(evt)\" required>\n"
                + "                                            </div>\n"
                + "\n"
                + "                                        </div>\n"
                + "\n"
                + "\n"
                + "                                        <!-- pie del diálogo -->\n"
                + "                                         <hr style=\"color: white\">\n"
                + "<input type=\"submit\" value=\"Mod Producto\" id=\"btnMP\">"
                + "\n"
                + "\n"
                + "\n"
                + "                                    </form>\n"
                + "\n"
                + "                                </div>";

        return htmlcode;
    }

    public boolean updateProducto(Producto p) {
        ModeloProductos mp = new ModeloProductos();
        return mp.update_producto(p);
    }
}
