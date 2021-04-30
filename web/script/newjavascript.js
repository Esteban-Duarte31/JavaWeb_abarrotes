/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var arraycarrito = [];
function inicio() {
    mostrarClientes();
    document.getElementById('formCliente').addEventListener('submit', agregarCliente, false);
    document.getElementById('mostrarClientes').addEventListener('click', mostrarClientes, false);
    document.getElementById('formVentas').addEventListener('submit', venta, false);
//    document.getElementById('form_Agregar').addEventListener('submit', getAllProductos(), false);
    getAllProductos();
}

var tot;






function cargarDataVentas(){
     xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoVentas?option=1", true);
    xhr.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {
            clientes_json = JSON.parse(xhr.responseText);
//            alert(xhr.responseText);
            let res = document.querySelector('#tablaVentas');
            res.innerHTML = '';
            for (let moto of clientes_json) {
                res.innerHTML += `
                            <tr>
                            <td id='id_Venta'>${moto.id}</td>
                            <td>${moto.cliente}</td>
                            <td>${moto.idCliente}</td>
                            <td>${moto.producto}</td>
                            <td>${moto.cantidad}</td>
                            <td>${moto.total}</td>
                            <td>${moto.fecha}</td>
                            <td><button type="button"  class="btn btn-danger" onclick="deleteVenta(${moto.id})" id="btn" name='btnCl' >Eliminar</button> </td>
            
                            </tr>
                            `;
            }
        }

    };

    xhr.send(null);
    
}


function deleteVenta(idv){
    var option = confirm("Desea eliminar el cliente?");
    if (option) {
        var idVenta = idv;
        var data = {id_Venta: idVenta};

        $.post("ManejoVentas?option=2", data, function (res, est, jqXHR) {
            alert(res);
        });
    }
    
}





function venta() {


    event.preventDefault();

    var selectProducto = document.getElementById("selectProducto").value;


    xhr2 = new XMLHttpRequest();
    xhr2.open("GET", "ManejoProductos", true);
    xhr2.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            Productos_json = JSON.parse(xhr2.responseText);
            var o = parseInt(1);
            for (let producto of Productos_json) {
                if (producto.descripcion === selectProducto) {


                    var nS = parseInt(producto.stock) - parseInt(document.getElementById("cantidad").value);
                    var s = nS + "";

//                    alert(producto.precio+"  llll "+document.getElementById('cantidad').value);

                    var total = parseInt(document.getElementById('cantidad').value) * parseInt(producto.precio);
                    tot=total+"";
//                    alert("total:"+total)



                    document.getElementById('total').value = total + "";
                     agregarVenta();
//                    alert("precio"producto.precio);



                    xhr = new XMLHttpRequest();
                    xhr.open("GET", "ModificarProducto?idProducto=" + producto.id + "&descripcion=" + producto.descripcion + "&stock=" + s + "&categoria=" + producto.categoria + "&precio=" + producto.precio, true);
                    xhr.onreadystatechange = function () {
                        //alert(xhr.status);
                        if (xhr.readyState === 4 && xhr.status === 200) {
//                            alert(xhr.responseText);
                        }

                    };

                    xhr.send(null);



                }
            }
        }

    };

    xhr2.send(null);
    
   
    

}





function agregarVenta() {

    var idCliente = document.getElementById("documento").value;
    var cliente = document.getElementById("nombresCV").value;
    var producto = document.getElementById("selectProducto").value;
    var cantidad = document.getElementById("cantidad").value;
    var total = document.getElementById("total").value;
//    alert("hola");
    var fecha = document.getElementById("fecha").innerHTML;
//    var fecha ="hey";
    
    
    
//    alert(fecha);
//    alert("option=0&idCliente=" + idCliente + "&cliente=" + cliente + "&producto=" + producto + "&cantidad" + cantidad + "&total=" + tot+ "&fecha=" + fecha);



    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoVentas?option=0&idCliente=" + idCliente + "&cliente=" + cliente + "&producto=" + producto + "&cantidad=" + cantidad + "&total=" + tot+ "&fecha=" + fecha, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
            if (xhr.responseText !== false) {
                alert("venta agregada con exito");
            } else {
                alert(xhr.responseText);
            }

        }
    };
    xhr.send(null);

}



function eliminarCliente(is) {

    var option = confirm("Desea eliminar el cliente?");
    if (option) {
        var idCliente = is;
        var data = {id_cliente: idCliente};

        $.post("ManejoClientes?option=2", data, function (res, est, jqXHR) {
            alert(res);
        });
    }

}


function eliminarProducto(idPro) {

    var option = confirm("Desea eliminar el Producto?");
    if (option) {
        var idCliente = idPro;
        var data = {id_producto: idCliente};

        $.post("EliminarProducto", data, function (res, est, jqXHR) {
            alert(res);
//            getAllProductos();
        });
    }

}

function agregarCliente() {
    const idCliente = document.getElementById('idCliente').value;
    const nombres = document.getElementById('nombres').value;
    const edad = document.getElementById('edad').value;
    const telefono = document.getElementById('telefono').value;
    const direccion = document.getElementById('direccion').value;

    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoClientes?option=0&idCliente=" + idCliente + "&nombres=" + nombres + "&edad=" + edad + "&telefono=" + telefono + "&direccion=" + direccion, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) {
//            alert("upa: "+xhr.responseText);
            if (xhr.responseText !== false) {
                alert("Cliente agregado exitosamente");
            } else {
                alert(xhr.responseText);
            }


        }
    };
    xhr.send(null);
    event.preventDefault();
}





function mostrarClientes() {
//    alert("mostar");
    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoClientes?option=1", true);
    xhr.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {
            clientes_json = JSON.parse(xhr.responseText);
//            alert(xhr.responseText);
            let res = document.querySelector('#tblBody');
            res.innerHTML = '';
            for (let moto of clientes_json) {
                res.innerHTML += `
                            <tr>
                            <td id='id_Cliente'>${moto.idCliente}</td>
                            <td>${moto.nombres}</td>
                            <td>${moto.edad}</td>
                            <td>${moto.telefono}</td>
                            <td>${moto.direccion}</td>
                            <td> <button type="button"  class="btn btn-danger" onclick="eliminarCliente(${moto.idCliente})" id="btn" name='btnCl' >Eliminar</button> </td>
            
                            </tr>
                            `;
            }
        }

    };

    xhr.send(null);
}



function fechaActual() {

    var meses = new Array("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre");
    var f = new Date();
    var date = f.getDate() + " / " + meses[f.getMonth()] + " / " + f.getFullYear();

    document.getElementById("fecha").innerHTML = date;
    cargarDatos();


}

function cargarDatos() {

    var select = document.getElementById("nombresCV");


    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoClientes?option=1", true);
    xhr.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {
            clientes_json = JSON.parse(xhr.responseText);
            var i = parseInt(1);
            for (let moto of clientes_json) {
                select.options[i] = new Option(moto.nombres, moto.nombres);
                i++;
            }
        }

    };

    xhr.send(null);




//CARGAR SELECT PRODUCTOS

    var selectProducto = document.getElementById("selectProducto");


    xhr2 = new XMLHttpRequest();
    xhr2.open("GET", "ManejoProductos", true);
    xhr2.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            Productos_json = JSON.parse(xhr2.responseText);
            var o = parseInt(1);
            for (let producto of Productos_json) {
                selectProducto.options[o] = new Option(producto.descripcion, producto.descripcion);
                o++;
            }
        }

    };

    xhr2.send(null);



}

function selectproducto() {
    var sel = document.getElementById("selectProducto").value;
    xhr2 = new XMLHttpRequest();
    xhr2.open("GET", "ManejoProductos", true);
    xhr2.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr2.readyState === 4 && xhr2.status === 200) {
            Productos_json = JSON.parse(xhr2.responseText);
            var cantidad = document.getElementById("cantidad");
            for (let producto of Productos_json) {
                if (sel === producto.descripcion) {

                    cantidad.max = producto.stock;
                    cantidad.value = producto.stock;
                }
            }
        }

    };

    xhr2.send(null);

}






function documentCliente() {
    var select = document.getElementById("nombresCV").value;

    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoClientes?option=1", true);
    xhr.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {
            clientes_json = JSON.parse(xhr.responseText);

            for (let moto of clientes_json) {
                if (moto.nombres === select) {
                    document.getElementById("documento").value = moto.idCliente;
                }

            }
        }

    };

    xhr.send(null);
}


function getAllProductos() {
//    event.preventDefault();
    xhr = new XMLHttpRequest();
    xhr.open("GET", "ManejoProductos?option=0", true);
    xhr.onreadystatechange = function () {
        //alert(xhr.status);
        if (xhr.readyState === 4 && xhr.status === 200) {
            productos_json = JSON.parse(xhr.responseText);
//            alert(xhr.responseText);
            let res = document.querySelector('#tablaP');
            res.innerHTML = '';
            var id;

            for (let producto of productos_json) {
                id = producto.id;
                res.innerHTML += `
                            <tr>
                            <td id='idProducto'>${producto.id}</td>
                            <td>${producto.descripcion}</td>
                            <td>${producto.stock}</td>
                            <td>${producto.categoria}</td>
                            <td>$${producto.precio}</td>
                            <td><img src='${producto.imagen}'  WIDTH=100 HEIGHT=100 class='img-fluid'></td>
                            <td> <a id='btn-modificar'   href='ModificarProducto.jsp?idMod=${producto.id}'>Modificar</a>             <button type="button"  class="btn btn-danger" onclick="eliminarProducto('${producto.id}')" id="btnP" name='btnP' >Eliminar</button>   </td>
            
                            </tr>
                            `;
            }
        }

    };

    xhr.send(null);

}








$(function () {








    $('#btnMP').click(function (e) {
        e.preventDefault();
//        alert("hy");
        var data = $('#form_Mod').serialize();
        console.log(data);
        $.post("ModificarProducto", data, function (res, est, jqXHR) {
            alert(res);
        });
    });
});


function onlyNums(e) {
    const code = window.event ? e.which : e.keyCode;

    return !(code < 48 || code > 57);
}


function onlyAlpha(evt) {
    const code = window.event ? evt.which : evt.keyCode;

    return !(code < 65 || code > 90) || !(code < 97 || code > 122) || !(code === ' ');

}