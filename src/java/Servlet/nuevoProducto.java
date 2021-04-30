/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.ControladorProductos;
import Include.Producto;
import com.google.gson.Gson;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Esteban
 */
public class nuevoProducto extends HttpServlet {

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

        FileItemFactory file_factory = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(file_factory);

        ArrayList<String> campos = new ArrayList<>();
        String imgs = "";
        List items = null;
//        RECIBIENDO ARCHIVOS
        try {
            items = sfu.parseRequest(request);

            for (int i = 0; i < items.size(); i++) {
                FileItem item = (FileItem) items.get(i);

//                SI NO ES UN CAMPO DE FORMULARIO (para archivos)
                if (!item.isFormField()) {
                    File archivo = new File("C:\\Users\\hp\\OneDrive\\Documentos\\NetBeansProjects\\JavaWeb\\web\\imgUploads\\productos\\" + item.getName());
                    item.write(archivo);
                    imgs = "imgUploads\\productos\\" + item.getName();
                } else {
                    campos.add(item.getString());
                }
            }

        } catch (Exception ex) {

        }
        
//        response.getWriter().println("Producto l: "+campos.toString());

        
        Producto p = new Producto(campos.get(0), campos.get(1), Integer.parseInt(campos.get(2)), campos.get(3), Integer.parseInt(campos.get(4)), imgs);
        ControladorProductos cp = new ControladorProductos();
        
        if (cp.crearProducto(p)) {
            response.getWriter().println("Producto Creado Exitosamente");
        } else {
            response.getWriter().println("ERROR al crear producto");
        }
        
//        out.println(new Gson().toJson(true));
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
