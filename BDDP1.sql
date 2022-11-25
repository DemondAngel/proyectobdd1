use AdventureWorks2019;
/*Equipo 10 */
/*
a.
 Determinar el total de las ventas de los productos con la categoría que se proveade argumento de entrada en la consulta,para cada uno de los territorios registradosen la base de datos.
 * */

CREATE PROCEDURE sp_TotVentas @categoryID int as
begin 
	SELECT soh.TerritoryID, SUM(Tabla.lineTotal) as total_Ventas FROM AdventureWorks2019.Sales.SalesOrderHeader soh
inner join
    (SELECT SalesOrderID, productId, orderqty, lineTotal
		FROM AdventureWorks2019.Sales.SalesOrderDetail sod
		WHERE ProductID in( SELECT productID FROM AdventureWorks2019.Production.Product WHERE ProductSubcategoryID 
		in(SELECT productSubcategoryId FROM AdventureWorks2019.Production.ProductSubcategory
			WHERE ProductCategoryID in(
				SELECT productCategoryID FROM AdventureWorks2019.Production.ProductCategory
				WHERE ProductCategoryID = @categoryID)))) as Tabla
    on soh.SalesOrderID = Tabla.SalesOrderID GROUP by soh.TerritoryId
	ORDER by total_Ventas DESC
end

exec sp_TotVentas 2;

/*
b. Determinar el producto más solicitado para la región (atributo group de salesterritory)“Noth America”y en que territorio de la región tiene mayordemanda.Quitando el Top 1, da la lista de todos los productos
 * */

CREATE PROCEDURE sp_ProdMasSolicitado @Territory nvarchar(50) AS
BEGIN 
SELECT
	TOP 1 SUM(Tabla.lineTotal) as total_ventas, Prod.Name as Nombre, Prod.ProductID
FROM AdventureWorks2019.Production.Product Prod
inner join(SELECT ProductID, lineTotal FROM AdventureWorks2019.Sales.SalesOrderDetail sod
	WHERE SalesOrderID in( SELECT SalesOrderID FROM AdventureWorks2019.Sales.SalesOrderHeader soh
		WHERE TerritoryID in( SELECT TerritoryID FROM AdventureWorks2019.Sales.SalesTerritory st
			WHERE [Group] = @Territory))) as Tabla
	on
	Prod.ProductID = Tabla.ProductID GROUP BY Prod.Name, Prod.ProductID ORDER by
	total_ventas DESC
END 

/* c. Actualizar el stock disponible en un 5% de los productos de la categoría que se  provea como argumento de entrada en una localidad que se provea como entrada en 
 la instrucción de actualización..
 NOTA: De momento solo consulta el producto con stock, dependiendo la localidad 
	 * */


	 /*]?????????????????????????????????????????????*/
CREATE PROCEDURE sp_ActualizarStock @Categ nvarchar(50) 
AS
BEGIN 
	DECLARE @pId int;

	set @pId = (SELECT ProductID FROM Production.ProductInventory pii WHERE
	pii.LocationID in(SELECT ProductID FROM Production.ProductSubcategory WHERE ProductCategoryID = @Categ));

	update AdventureWorks2019.Production.ProductInventory set Quantity = Quantity*1.05 WHERE ProductID = @pId;

END


/* Determinar si hay clientes que realizan ordenes en territorios diferentes al que se encuentran. 
	 */

CREATE PROCEDURE sp_CustomerDiferrentOrder  AS 
BEGIN
SELECT scus.TerritoryID as Territorio_Cliente, soh.TerritoryID as Territorio_Orden
FROM AdventureWorks2019.Sales.Customer scus inner join 
AdventureWorks2019.Sales.SalesOrderHeader soh on scus.CustomerID != soh.CustomerID
GROUP by scus.TerritoryID, soh.TerritoryID 
END

/*
 Actualizar  la  cantidad  de  productos  de  una  orden que  se provea  como argumento en la instrucción de actualización.
NOTA: Lista la cantidad de productos, nombre y el ID de la Orden de venta
	 * */

CREATE PROCEDURE sp_ActualizarCant @SOID int, @SOCant int
AS
BEGIN
	IF EXISTS (SELECT sod.OrderQty as Cantidad_Productos, Prod.Name as Nombre_Producto, sod.SalesOrderID
	FROM AdventureWorks2019.Sales.SalesOrderDetail sod
	inner join AdventureWorks2019.Production.Product Prod 
	on sod.ProductID = Prod.ProductID and sod.SalesOrderID = @SOID) 

	update AdventureWorks2019.Sales.SalesOrderDetail set OrderQty = @SOCant where SalesOrderID = @SOID
	ELSE 
	PRINT 'SIN ACTUALIZAR'
END
	

/*
 Actualizar el método de envío de una orden que se reciba como argumento en la instrucción de actualización.  NOTA: Lista todas las ordenenes dependiendo el metodo de envio
 */	
	
CREATE PROCEDURE sp_ActualizarMetEnvio @SOID int,@SHIPMTHID int AS
BEGIN 
	IF EXISTS (SELECT MetEnv.Name as Metodo_Envio, MetEnv.ShipMethodID as ID_Metodo,
	soh.ShipMethodID as ID_Metodo_Seleccionado, soh.SalesOrderID
	FROM AdventureWorks2019.Sales.SalesOrderHeader soh inner join AdventureWorks2019.Purchasing.ShipMethod MetEnv
	on soh.ShipMethodID = MetEnv.ShipMethodID
	where soh.SalesOrderID = @SOID)


	UPDATE AdventureWorks2019.Sales.SalesOrderHeader set ShipMethodID = @SHIPMTHID WHERE SalesOrderID = @SOID
	ELSE 
		PRINT 'SIN ACTUALIZAR'
END

/*
 Actualizar el correo electrónico de una cliente que se reciba como argumento en la instrucción de actualización. NOTA: Lista a la persona y su correElectronico, parametrizar por correo electronico, en lugar de BusinessEntityID
 */

ALTER PROCEDURE sp_ActualizaEmail @EmailActual nvarchar(50), @EmailNuevo nvarchar(50) AS 
BEGIN 
	IF EXISTS (
		SELECT Pers.FirstName as Nombre, Email.EmailAddress as Email
	FROM AdventureWorks2019.Person.Person Pers
	inner join AdventureWorks2019.Person.EmailAddress Email
	on Pers.BusinessEntityID = Email.BusinessEntityID 
	where Email.EmailAddress = @EmailActual
	)
	UPDATE AdventureWorks2019.Person.EmailAddress set EmailAddress = @EmailNuevo  WHERE EmailAddressID = @EmailActual
	ELSE 
		PRINT 'SIN ACTUALIZAR'
	
END