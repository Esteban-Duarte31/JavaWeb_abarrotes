/*create database if not exists DataBaseProducts; 

use DataBaseProducts;

CREATE TABLE IF NOT EXISTS productos (
    idProducto VARCHAR(10) PRIMARY KEY NOT NULL,
    descripcion VARCHAR(200) NOT NULL,
    stock INT NOT NULL,
    categoria VARCHAR(20) NOT NULL,
    precio INT NOT NULL,
    imagen VARCHAR(200) NOT NULL
);
*/


/*
para borrar tab
drop table productos;
*/



/*
insert into productos values('ace01','aceite',3,'viveres',1000);
insert into productos values('to1','tomate',9,'Frutas y verduras',1300);
insert into productos values('zan01','zanahoria',7,'Frutas y verduras',1000);
insert into productos values('jab1','jabon',3,'Aseo',1400);
*/

/*
describe productos

select * from productos
*/



/*
DELIMITER //
CREATE PROCEDURE insertProducto(
	in	    _idProducto varchar(10),
			_descripcion varchar(200),
			_stock int,
			_categoria varchar(20) ,
			_precio int,
            _imagen varchar(200)

)begin

insert into productos (idProducto, descripcion, stock, categoria, precio, imagen) values(_idProducto, _descripcion, _stock, _categoria, _precio, _imagen);

END

//DELIMITER ;
*/


/*
call insertProducto('pa','panela',2,'viveres',1300,'');
*/


/*
call insertProducto('pa','panela',2,'viveres',1300,"imgUpload/productos/tomate.jpg");
*/

/*
select * from productos;
describe productos;
delete from productos where idProducto="";
*/

/*
DELIMITER //
create procedure selectAllproductos(

)begin
select * from productos; 

end
//DELIMITER ;

*/


/*
DELIMITER //
create procedure deleteProducto(
	in _idProducto varchar(10)
)begin
 
delete from productos where idProducto=_idProducto;
end
//DELIMITER ;



DELIMITER //
create procedure updateProducto(
	in _idProducto varchar(10),
			_descripcion varchar(200),
			_stock int,
			_categoria varchar(20) ,
			_precio int
)begin
 
update productos set idProducto = _idProducto, descripcion= _descripcion, stock= _stock, categoria= _categoria, precio=_precio where idProducto= _idProducto;
end
//DELIMITER ;

*/








