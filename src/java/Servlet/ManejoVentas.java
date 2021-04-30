/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorVenta;
import Include.Venta;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Esteban
 */
public class ManejoVentas extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String option = request.getParameter("option");

        switch (option) {
            case "0":
                String idCliente = request.getParameter("idCliente");
                String cliente = request.getParameter("cliente");
                String producto = request.getParameter("producto");
                String cantidad = request.getParameter("cantidad");
                String total = request.getParameter("total");
                String fecha = request.getParameter("fecha");
                Venta c = new Venta(idCliente, cliente, producto, cantidad, total, fecha);
                ControladorVenta cp = new ControladorVenta();

                if (cp.crearVenta(c)) {
//            response.getWriter().println("Cliente Creado Exitosamente");
                    response.getWriter().println(true);
                } else {
//            response.getWriter().println("ERROR al crear Cliente");
                    response.getWriter().println(false);
                }

                break;

            case "1":
                ControladorVenta cp2 = new ControladorVenta();

                response.getWriter().println(new Gson().toJson(cp2.getViewVentas()));
                break;

            case "2":
                String idProducto = request.getParameter("id_Venta");
                ControladorVenta cp3 = new ControladorVenta();
                if (cp3.deleteProducto(idProducto)) {
                    response.getWriter().println("Venta eliminada exitosamente");
                } else {
                    response.getWriter().println("ERROR al eliminar la Venta");
                }
                break;

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
