<%-- 
    Document   : index
    Created on : 27/09/2020, 05:13:59 PM
    Author     : Esteban
--%>

<%@page import="Controlador.ControladorClientes"%>
<%@page import="Controlador.ControladorProductos"%>
<%@page import="java.sql.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <!--<meta charset="utf-8">-->
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>index</title>



    </head>
    <body  background="imgUploads\\fondo.gif">

        <!-- Si utilizamos componentes de Bootstrap que requieran Javascript agregar estos archivos -->
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>


        <!--CLASES .JS-->
        <script id="manejo" src="script\newjavascript.js"></script>
        <script> addEventListener('DOMContentLoaded', inicio, false);</script>





        <div class="container" >
            <div class="jumbotron" style="background-color: slategrey">


                <h1>TIENDA JD</h1>
                <hr>



                <nav>
                    <div class="nav nav-pills navbar-dark bg-dark" id="nav-tab" role="tablist">

                        <a class="nav-item nav-link col-md" id="nav-home-tab" onclick="fechaActual()" data-toggle="tab" href="#sale" role="tab" aria-controls="sale" aria-selected="true">

                            <div class="card border-success">
                                <div class="card-body">
                                    <img class="card-img-top" src="https://www.pmh.cl/wp-content/uploads/2014/01/venta-online.png">
                                    <br>

                                    <hr>
                                    <h4 class="card-title text-center">VENTAS</h4>
                                </div>
                            </div>          

                        </a>





                        <a class="nav-item nav-link col-md" id="nav-profile-tab" data-toggle="tab" href="#nav-profile" role="tab" aria-controls="nav-profile" aria-selected="false">

                            <div class="card border-warning">
                                <div class="card-body">
                                    <img class="card-img-top" src="https://image.freepik.com/vector-gratis/coleccion-diferentes-tipos-snacks_23-2147927928.jpg">

                                    <hr>
                                    <h4 class="card-title text-center">PRODUCTOS</h4>

                                </div>
                            </div>          


                        </a>




                        <a class="nav-item nav-link col-md" id="nav-contact-tab" data-toggle="tab" href="#nav-contact" role="tab" aria-controls="nav-contact" aria-selected="false">

                            <div class="card border-danger">
                                <div class="card-body">
                                    <img class="card-img-top" src="https://giitic.com/img/serviciocliente/soporteinterno1.png?pfdrid_c=true">

                                    <hr>

                                    <h4 class="card-title text-center" >CLIENTES</h4>


                                </div>
                            </div>          

                        </a>
                    </div>
                </nav>



                <br>
                <hr>
                <br>
                <br> 








                <!--TAB CONTENT-->
                <div class="tab-content" id="nav-tabContent">


                    <!--VENTAS-->
                    <div class="tab-pane fade" id="sale" role="tabpanel"  aria-labelledby="sale-tab">

                        <h2>VENTAS</h2>
                        <ul class="nav nav-tabs mt-3 bg-dark navbar-light">
                            <li class="nav-item">                               
                                <a class="nav-link active"  data-toggle="tab" href="#opcion1"  >VENTAS</a>

                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  data-toggle="tab" onclick="cargarDataVentas()" href="#opcion2">HISTORIAL VENTAS</a>
                            </li>

                        </ul>

                        <div class="tab-content bg-light" >
                            <div class="tab-pane fade show active" id="opcion1">

                                <br>
                                <div class="container">


                                    <div class="col-md">        
                                        <div class="card  text-center ">
                                            <div class="card-header p-3 mb-2 bg-dark text-white">
                                                <h1>Agregar Venta</h1>
                                            </div>
                                            <div class="card-body  p-3 mb-2 bg-dark text-white ">






                                                <form id="formVentas" >


                                                    <div class="form-group row ">

                                                        <label for="fecha" class="col-lg-2 col-form-label">Fecha:</label>
                                                        <label for="fecha2" class="col-lg-2 col-form-label" id="fecha"></label>

                                                    </div>

                                                    <br>



                                                    <div class="form-row align-items-center">

                                                        <div class="form-group col-xl-6">
                                                            <label for="selectProducto" >Seleccione un producto: </label> 
                                                            <select class="form-control" id="selectProducto" onchange="selectproducto()" name="selectProducto"> 
                                                                <option>productos</option> 

                                                            </select> 
                                                        </div>


                                                        <div class="form-group col-xl-3">
                                                            <label for="cantidad">Cantidad: </label>
                                                            <input type="number" class="form-control"  value="0" id="cantidad" name="cantidad"
                                                                   min="1" title="no hay suficientes productos" required>

                                                        </div>





                                                    </div>

                                                    <br>
                                                    <br>



                                                    <div class="form-row">
                                                        <div class="form-group col-xl-6">
                                                            <label for="nombresCV">Cliente: </label>


                                                            <select class="form-control" id="nombresCV" onchange="documentCliente()" name="nombresCV"> 
                                                                <option>Seleccione un Cliente...</option>
                                                            </select> 

                                                        </div>

                                                        <div class="form-group col-xl-6">
                                                            <label for="documento">Documento:</label>
                                                            <input type="text" class="form-control" id="documento" name="documento" readonly="">
                                                        </div>

                                                    </div>


                                                    <br>
                                                    <br>



                                                    <div class="form-row">


                                                        <div class="form-group col-xl-6">
                                                        </div>

                                                        <div class="form-group col-xl-6">
                                                            <label for="total">TOTAL:  </label>
                                                            <input type="text" class="form-control" id="total"  style="background-color: turquoise" name="total" readonly="" >
                                                        </div>



                                                    </div>

                                                    <br>
                                                    <br>
                                                    <br>
                                                    <br>







                                                    <!-- pie del diálogo -->
                                                    <hr>

                                                    <button type="submit" class="btn btn-success" id="btncrearcliente">Agregar Venta</button>



                                                </form>


                                            </div>

                                            <hr style="color: white">
                                            <div class="card-footer text-center">
                                                GENIAL!
                                            </div>


                                        </div>          
                                    </div>



                                </div>


                            </div>


                            <div class="tab-pane fade" id="opcion2" >

                                <br>
                                <div class="form-group row">

                                    <label for="buscarvp" class="col-lg-2 col-form-label">BUSQUEDA:</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" id="buscarvp" name="buscarvp"  >
                                    </div>
                                </div>

                                <table class="table table-striped table-dark table-hover table-responsive-xl" id="tablaV">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>id </th>
                                            <th>Cliente</th>
                                            <th>idCliente</th>
                                            <th>Producto</th>
                                            <th>cantidad</th>
                                            <th>total</th>
                                            <th>fecha</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tablaVentas">



                                    </tbody>




                                </table>




                            </div>



                        </div>

                    </div>










                    <!--PRODUCTOS-->
                    <div class="tab-pane fade" id="nav-profile" role="tabpanel" aria-labelledby="nav-profile-tab">

                        <h2>PRODUCTOS</h2>    


                        <ul class="nav nav-tabs mt-3 bg-warning navbar-light">
                            <li class="nav-item">
                                <a class="nav-link active"  data-toggle="tab" href="#gestion" >GESTIÓN</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"  data-toggle="tab" onclick="getAllProductos()" href="#agregados">Agregados</a>
                            </li>

                        </ul>


                        <div class="tab-content bg-light" >

                            <!--GESTION PRODUCTOS-->
                            <div class="tab-pane fade show active" id="gestion">

                                <!--AGREGAR PRODUCTOS-->

                                <div class="container"> 

                                    <form action="nuevoProducto" name="formAgregar" method="POST" enctype="multipart/form-data" id="form_Agregar">



                                        <div class="form-group row">.
                                            <label for="idProducto" class="col-lg-2 col-form-label">Id del producto:</label>
                                            <div class="col-lg-5">
                                                <input type="text" class="form-control" id="idProducto" name="idProducto"
                                                       pattern="[A-Za-z0-9]+" placeholder="ace01" maxlength="10" required>
                                            </div>
                                        </div>


                                        <div class="form-row">
                                            <div class="form-group col-xl-6">
                                                <label for="descripcion">Descripción: </label>
                                                <input type="text" class="form-control" id="descripcion" name="descripcion"
                                                       PATTERN="[A-Za-z ]+" onkeypress="return onlyAlpha(evt)" placeholder="aceite" required>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="stock">Stock:</label>
                                                <input type="text" class="form-control" id="stock" name="stock"
                                                       pattern="[0-9]+" min="0" onkeypress="return onlyNums(evt)" required>
                                            </div>

                                        </div>


                                        <div class="form-row">
                                            <div class="form-group col-xl-6">
                                                <label for="categoria">Categoria:</label>
                                                <select class="form-control" id="categoria"  name="categoria">
                                                    <option>Frutas y Verduras</option>
                                                    <option>Aseo</option>
                                                    <option>viveres</option>
                                                    <option>Otros</option>

                                                </select>
                                            </div>

                                            <div class="form-group col-xl-6">
                                                <label for="precio">Precio:</label>
                                                <input type="number" class="form-control" id="precio" name="precio"
                                                       min="200" onkeypress="return onlyNums(evt)" required>
                                            </div>

                                        </div>

                                        <div class="form-group">
                                            <label for="archivo1">Seleccione una imagen para el producto:</label>
                                            <input type="file" class="form-control-file" id="archivo1" name="archivo1">
                                        </div>

                                        <div id="estado">

                                        </div>
                                        <!-- pie del diálogo -->
                                        <hr>

                                        <button type="submit" class="btn btn-warning" id="btncrearproducto">Agregar
                                        </button>


                                    </form>

                                </div>

                            </div>




                            <!--AGREGADOS-->
                            <div class="tab-pane fade" id="agregados" >
                                <br>

                                <form name="formBuscar" action="buscarProducto" method="post" >




                                    <div class="form-group row justify-content-end">
                                        <div class="col-lg-6">
                                            <input class="form-control " type="search" placeholder="Search" aria-label="Search" name="searchProducto" id="inputId"
                                                   required>
                                        </div>
                                        <button class="btn btn-outline-success col-lg-2" type="submit"  name="btnbuscarProducto" id="btnbuscarProducto">Search</button>
                                    </div>





                                </form>







                                <table class="table table-striped table-dark table-hover table-responsive-xl" id="tablaProductos">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>id de producto</th>
                                            <th>Descripción</th>
                                            <th>Stock</th>
                                            <th>Categoria</th>
                                            <th>Precio</th>
                                            <th>imagen</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tablaP">



                                    </tbody>




                                </table>





                            </div>







                        </div>



                    </div>







                    <!--CLIENTES-->
                    <div class="tab-pane fade" id="nav-contact" role="tabpanel" aria-labelledby="nav-contact-tab">

                        <h2>CLIENTES</h2>

                        <ul class="nav nav-tabs mt-3 bg-danger navbar-light">
                            <li class="nav-item">
                                <a class="nav-link active"  data-toggle="tab" href="#gestionClientes" >GESTIÓN ClIENTES</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" id="mostrarClientes" data-toggle="tab" href="#agregadosC">Agregados</a>
                            </li>

                        </ul>


                        <div class="tab-content bg-dark text-white" >
                            <div class="tab-pane fade show active" id="gestionClientes">
                                <br>
                                <form  id="formCliente">


                                    <div class="form-group row">.
                                        <label for="idCliente" class="col-lg-2 col-form-label">Cedula:</label>
                                        <div class="col-lg-5">
                                            <input type="text" class="form-control" id="idCliente" name="idCliente"
                                                   placeholder="28939232" maxlength="100" required>
                                        </div>
                                    </div>


                                    <div class="form-row">
                                        <div class="form-group col-xl-6">
                                            <label for="nombres">Nombres: </label>
                                            <input type="text" class="form-control" id="nombres" name="nombres"
                                                   PATTERN="[A-Za-z ]+" onkeypress="return onlyAlpha(evt)" placeholder="JD" required>
                                        </div>

                                        <div class="form-group col-xl-6">
                                            <label for="edad">Edad:</label>
                                            <input type="text" class="form-control" id="edad" name="edad"
                                                   pattern="[0-9]+" min="18" onkeypress="return onlyNums(evt)" required>
                                        </div>

                                    </div>


                                    <div class="form-row">


                                        <div class="form-group col-xl-6">
                                            <label for="telefono">Telefono: </label>
                                            <input type="tel" class="form-control" id="telefono" name="telefono"
                                                   PATTERN="[0-9]+"  placeholder="(399) 999 999" required>
                                        </div>
                                        <div class="form-group col-xl-6">
                                            <label for="direccion">Direccion: </label>
                                            <input type="text" class="form-control" id="direccion" name="direccion"
                                                   onkeypress="return onlyAlpha(evt)" placeholder="calle.... 89-23" required>
                                        </div>



                                    </div>



                                    <!-- pie del diálogo -->
                                    <hr>

                                    <button type="submit"  class="btn btn-success" id="btncrearcliente">Agregar Cliente
                                    </button>



                                </form>


                            </div>



                            <div class="tab-pane fade" id="agregadosC" >
                                <!--                                TABLA CLIENTES-->
                                <br>
                                <div class="form-group row">.
                                    <label for="buscaC" class="col-lg-2 col-form-label">BUSQUEDA:</label>
                                    <div class="col-lg-5">
                                        <input type="text" class="form-control" id="buscaC" name="buscaC"  >
                                    </div>
                                </div>

                                <table class="table table-striped table-dark table-hover table-responsive-xl" id="tablaClientes">
                                    <thead class="thead-light">
                                        <tr>
                                            <th>id del Cliente</th>
                                            <th>nombres</th>
                                            <th>edad</th>
                                            <th>telefono</th>
                                            <th>direccion</th>
                                        </tr>
                                    </thead>
                                    <tbody id="tblBody">




                                    </tbody>




                                </table>


                            </div>

                        </div>




                    </div>
                </div>






            </div>
        </div>






        <!--para filtar en tabla productos-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
        <script>
                                                       // Write on keyup event of keyword input element
                                                       $(document).ready(function () {
                                                           $("#inputId").keyup(function () {
                                                               _this = this;
                                                               // Show only matching TR, hide rest of them
                                                               $.each($("#tablaProductos tbody tr"), function () {
                                                                   if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                                                                       $(this).hide();
                                                                   else
                                                                       $(this).show();
                                                               });
                                                           });
                                                       });
        </script>








        <script>
            // Write on keyup event of keyword input element
            $(document).ready(function () {
                $("#buscarvp").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#tablaV tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });
        </script>





        <script>
            // Write on keyup event of keyword input element
            $(document).ready(function () {
                $("#buscaC").keyup(function () {
                    _this = this;
                    // Show only matching TR, hide rest of them
                    $.each($("#tablaClientes tbody tr"), function () {
                        if ($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                            $(this).hide();
                        else
                            $(this).show();
                    });
                });
            });
        </script>





    </body>
</html>












