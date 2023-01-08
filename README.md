# proyectobdd1
El nombre de los Linked Server para poder realizar la conexión sería SALESAW, OTROSAW, PRODUCTIONAW.
Y como catalog salesAW, otrosAW y productionAW.

Se tiene que utilizar una computadora por a parte para realizar la conexión hacia los Linked Server configurando el DTC de Windows para que se puedan llevar acabo las
transacciones distribuidas.

Colocar usuario y contraseña del gestor de base de datos en el persistence.xml

La filosofía de JPA es transaccional, es decir, queda operacion que realiza dentro de la base de datos queda registrada y controlada por la misma tecnología.
En este proyecto se trabajaron todas las consultas con transacciones de forma igualitaria para seguir esta filosofía. NO ES NECESARIO programar todo con transacciones
debido a que algunas consultas son sencillas. Para este proyecto se considera que las consultas que tienen actualizaciones son las que deben llevar la transacción de forma obligatoria, para que en un caso severo se realice un rollback y los datos queden inmunes a los cambios que se estuvieron realizando. Además de que estos
verifican la información antes de actualizarla por lo que si se tiene que llevar un registro de ello.

Ademas de actualizar nuestro script de la base de datos AdventureWorks2019 modificando los StoreProcedures para realizar consultas transaccionales, en especifico los updates, cuidando la inconsistencia de datos entrantes. Como mencionamos modificamos las consultas y en caso de una inconsistencia de datos con ayuda de JPA aplicariamos el rollback de la informacion. 
