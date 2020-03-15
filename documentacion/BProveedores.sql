DROP DATABASE BProveedores;
CREATE DATABASE BProveedores;
USE BProveedores;


CREATE TABLE TProductos  (
Id        INT   AUTO_INCREMENT PRIMARY KEY,
Nombre           VARCHAR(70) NOT NULL,
Descripcion      VARCHAR(400) NOT NULL
);
 
CREATE TABLE TProveedores  (
Id       INT  AUTO_INCREMENT PRIMARY KEY,
Nombre           VARCHAR(60)  NOT  NULL,
Telefono    VARCHAR(15)  NOT  NULL,
Contacto   VARCHAR(30)  NOT NULL
);
 

CREATE TABLE TCompras  (
Id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
IdProducto   INT NOT NULL,
IdProveedor   INT NOT NULL,
Cantidad         INT NOT NULL,
Precio     DECIMAL(6,2) NOT NULL,
Fecha        DATE NOT NULL,
FOREIGN KEY (IdProducto)  REFERENCES TProductos (Id),
FOREIGN KEY (IdProveedor) REFERENCES TProveedores (Id)
);

CREATE TABLE TUsuarios  (
Id        INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
Login     VARCHAR(15) NOT NULL,
Apellidos     VARCHAR(35) NOT NULL,
Pass      VARCHAR(64)  NOT NULL,
Rol		  VARCHAR(15)  NOT NULL,
Habilitado	 INT  NOT NULL
);

INSERT INTO TUsuarios (Login, Apellidos, Pass, Rol, Habilitado) VALUES 
  ('Raul','Lujan Pascual','81dc9bdb52d04dc20036dbd8313ed055','ROLE_ADMIN',1),
  ('Pepe','Martinez Garcia','81dc9bdb52d04dc20036dbd8313ed055','ROLE_USER',1);

INSERT INTO TProveedores (Nombre, Telefono, Contacto) VALUES 
  ('A Y R EXPRESS SL', '968245885', 'Manuel Ramirez'),
  ('ARAGON TRANSPORTES ESPECIALES SL', '968273485', 'Jose Andres Parra'),
  ('TRANSPORTES BLINDADOS', '968345844', 'Nicolas Benitez'),
  ('TRANSPORTES OCHOA SA', '968396244', 'Pepa Jimenez'),
  ('A Y R SERVICIO URGENTE LOCAL E INTERPROVINCIAL SL', '968245885', 'Juan Jose Gomez'),
  ('TRANSPORTS ARJONA-ACVAREZ', '968342144', 'Roberto Pascual'),
  ('TRANSPORTES J CARRION SOCIEDAD ANONIMA', '968345369', 'Maria Campos'),
  ('UNITED PARCEL SERVICE ESPANA LTD Y COMPANIA SRC', '968344584', 'Ricote Ribera'),
  ('LOGINTEGRAL 2000 SA', '968345000', 'Rio Benitez'),
  ('SEUR GEOPOST SLU', '968456844', 'Manuel Perez'),
  ('XPO TRANSPORT SOLUTIONS SPAIN SL.', '968400064', 'Domingo Ortega'),
  ('BREOGAN TRANSPORTE SAU','968488774','Rosario Melea'),
  ('ACASERVI SA','968451247','Carmen Zapatero'),
  ('TUDEFRIGO SL','968450035','Jose Luis Rodriguez'),
  ('LOGESTA GESTION DE TRANSPORTE SA','968453360','Pablo Masia'),
  ('TRANS SESE SL','968001544','Raul Ortiz'),
  ('CONTANK SA','968459987','Nicolas Perez'),
  ('DHL PARCEL BARCELONA SPAIN S.L.','968985845','Ana Hidalgo'),
  ('TRANSPORTES DEL VALLE SA','96624632','Bernardo Caceres');

INSERT INTO TProductos (Nombre, Descripcion) VALUES 
  ('Envolvedora ESP TI','La ESP TI llega para evitar tener que girar alrededor de un palet.'),
  ('Envolvedora ESB EVOLVO','La solucion perfecta para palets pesados o inestables. Se puede montar en la pared o de pie. La tension del film puede ser muy ligera para un buen funcionamiento cuando los palets son inestables.'),
  ('Envolvedora EST 80A','Sistemas de envoltura automatica a tunel concebidos para bultos especialmente alargados, tales como perfileria, puertas, tablones, etc.'),
  ('Flejadora FM ECO 13-16-19','Sistema manual para el flejado metalico sin union, mediante troquelado del fleje.'),
  ('Flejadora FP GT-SMART','La FP GT SMART es un aparato manual motorizado de flejado con soldadura a friccion que garantiza una alta eficiencia de union con un bajo coste de mantenimiento.'),
  ('Flejadora FP 601 A','Existen versiones con mesa motorizada a rodillos (A) o bandas (B) en cuyo caso incluyen fotocelulas y un sencillo programa que permite ajustar la distancia y numero de flejadas por paquete.'),
  ('Pistola Retractiladora ER 40','Pistola para el embalaje economico mediante retraccion con film de polietileno de cargas paletizables, ideal para cualquier objeto de grandes dimensiones o irregular: muebles, escaleras, barcos, maquinas industriales.'),
  ('Retractiladora ERC 346','Retractiladora de envoltura termoretractil, de bajo consumo y mantenimiento, programable con el control electronico.'),
  ('Enfajadora ERF M500','Compacta, innovadora y robusta, para confeccionar con todo tipo de films termoretractiles una amplisima gama de productos (Botellas, vasos, latas, cajas, etc). La solucion para sellar grandes cajas, confeccionar piezas especiales integrando o sustituyendo en el final de linea el uso del carton ondulado, no precisa alimentacion pneumatica y permite un cambio de formato muy rapido.'),
  ('Precintadora P ECO T50SB','Equipo para el precintado mediante dos cabezales que precintan simultaneamente la parte superior e inferior de la caja.'),
  ('Precintadora P 650A','Equipo totalmente automatico para el precintado mediante dos cabezales que precintan simultaneamente la parte superior e inferior de la caja, la solucion ideal para el cerrado en serie de cajas con dimensiones que varian frecuentemente.'),
  ('Amortiguador vertical para muelle de carga Stommpy (Buffer)',' ¿Desea conservar la integridad y la funcionalidad del compartimiento de carga y evitar que los remolques erosionen las plataformas de carga? El tope de proteccion STOMMPY es la solucion correcta que le permitira ahorrar costos de mantenimiento debido a la restauracion de los puntos de carga/descarga de mercancias.'),
  ('Luz de seguridad LED para el suelo Stommpy','Las luces LED de suelo de STOMMPY son la solucion ideal para reforzar la senalizacion horizontal. En la version de una cara y de doble cara, tienen una gran autonomia de operacion y son absolutamente resistentes al paso de los vehiculos. Alta visibilidad incluso de noche.'),
  ('Amortiguador para muelle de carga Stommpy (Buffer)','Para la proteccion de la estructura del muelle de carga. Una solucion simple, economica y practica, que absorbe los impactos generados al acercarse a un vehiculo.'),
  ('Puerta peatonal Stommpy',' ¿Tiene que ajustar los cruces en areas de trafico mixto, creando un obstaculo para los peatones desatentos? Minimice el riesgo de accidentes y lesiones gracias a la puerta peatonal STOMMPY.'),
  ('Barrera de seguridad contra impacto Stommpy','Proteccion contra impactos para estructuras, bienes, personal y su equipo de manipulacion.'),
  ('Fleje plsstico PP','Flejes plasticos de Polipropileno. Para ver todas las categorias disponibles consulte nuestra tabla de calidades descargando el PDF.'),
  ('Plastico burbuja','Consulte las refrencias rellenando el formulario.'),
  ('Cintas adhesivas','Cintas adhesivas de polipropileno y de PVC en distintas calidades y colores personalizadas o anonimas. Consulte nuestra tabla de calidades descargando el PDF.'),
  ('Formadora de airbags PR CIRRUS 45-5','Sistema de proteccion de cargas mediante cojines de aire.');
  

INSERT INTO TCompras (IdProveedor, IdProducto,  Cantidad, Precio, Fecha) VALUES
  (1, 11, 20, 250 , '2015/06/10' ),
  (3, 2, 100, 253 , '2015/07/24' ),
  (2, 13, 100, 350 , '2016/06/14' ),
  (9, 2, 150, 280, '2016/08/24' ),
  (3, 5, 50, 2250 , '2016/11/20' ),
  (8, 16, 60, 2250 , '2017/01/04' ),
  (4, 17, 60, 2450 , '2017/05/23' ),
  (13, 8, 40, 25605 , '2017/09/17' ),
  (12, 7, 50, 2560 , '2017/12/11' ),
  (4, 11, 200, 1000 , '2018/02/23' ),
  (10, 5, 170, 850 , '2018/08/14' ),
  (4, 9, 180, 900 , '2018/10/19' ),
  (6, 14, 270, 205 , '2019/01/24'),
  (14, 7, 350, 150.5 , '2019/05/04'),
  (2, 5, 2500, 1250.5 , '2019/09/28'),
  (18, 19, 20, 200 , '2019/12/01' );