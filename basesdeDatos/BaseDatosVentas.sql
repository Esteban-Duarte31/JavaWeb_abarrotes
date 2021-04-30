/*use DataBaseproducts;


CREATE TABLE IF NOT EXISTS ventas (
    idVenta int auto_increment PRIMARY KEY ,
    idCliente VARCHAR(200) NOT NULL,
    cliente VARCHAR(200) NOT NULL,
    producto VARCHAR(200) NOT NULL,
    cantidad VARCHAR(200) NOT NULL,
    total VARCHAR(200) NOT NULL,
    fecha VARCHAR(200) NOT NULL
);


DELIMITER //
CREATE PROCEDURE insertVenta(
	in	    _idCliente varchar(200),
			_cliente varchar(200),
			_producto varchar(200),
			_cantidad varchar(200) ,
			_total varchar(200) ,
			_fecha varchar(200)

)begin

insert into clientes (idCliente,cliente,producto,cantidad,total,fecha) values(_idCliente, _cliente,  _producto, _cantidad, _total, _fecha);

END

//DELIMITER ;

*/

