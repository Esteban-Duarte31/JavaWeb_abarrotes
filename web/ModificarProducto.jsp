<%-- 
    Document   : ModificarProducto
    Created on : 30/09/2020, 11:39:40 PM
    Author     : Esteban
--%>

<%@page import="Controlador.ControladorProductos"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>Modificar Producto</title>
    </head>
    <body>


        <div class="container">
            <div class="jumbotron" style="background-color: ">


                <div class="col-md">        
                    <div class="card  text-center ">
                        <div class="card-header p-3 mb-2 bg-dark text-white">
                            <h1>Modificar Producto</h1>
                        </div>
                        <div class="card-body  p-3 mb-2 bg-dark text-white ">

                            <%
                                ControladorProductos cp = new ControladorProductos();
                                String idProducto = request.getParameter("idMod");
                            %>

                            <%--<%= idProducto%>--%>
                            <%=  cp.getEditViewProducto(idProducto)%>
                        </div>

                        <hr style="color: white">
                        <div class="card-footer text-center">
                            GENIAL!
                        </div>


                    </div>          
                </div>

            </div>

        </div>

        <!-- Si utilizamos componentes de Bootstrap que requieran Javascript agregar estos archivos -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


        <!--CLASES .JS-->
        <script id="manejo" src="script\newjavascript.js"></script>
    </body>
</html>
