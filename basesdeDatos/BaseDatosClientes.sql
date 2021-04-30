

use DataBaseproducts;

CREATE TABLE IF NOT EXISTS clientes (
    idCliente VARCHAR(100) PRIMARY KEY NOT NULL,
    nombres VARCHAR(1000) NOT NULL,
    edad int NOT NULL,
    telefono VARCHAR(10) NOT NULL,
    direccion VARCHAR(1000) NOT NULL
);

DELIMITER //
CREATE PROCEDURE insertCliente(
	in	    _idCliente varchar(100),
			_nombres varchar(1000),
			_edad int,
			_telefono varchar(10) ,
			_direccion varchar(1000)

)begin

insert into clientes (idCliente,nombres,edad,telefono,direccion) values(_idCliente, _nombres,  _edad, _telefono, _direccion);

END

//DELIMITER ;






DELIMITER //
create procedure selectAllClientes(

)begin
select * from clientes; 

end
//DELIMITER ;

DELIMITER //
create procedure deleteCliente(
	in _idCliente varchar(100)
)begin
 
delete from clientes where idCliente=_idCliente;
end
//DELIMITER ;




