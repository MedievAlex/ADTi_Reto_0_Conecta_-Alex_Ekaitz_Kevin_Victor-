DROP DATABASE examendb;
CREATE DATABASE examendb;
USE examendb;


CREATE TABLE Enunciado (
ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
DESCRIPCION varchar(200),
NIVEL ENUM('ALTO', 'MEDIO', 'BAJO'),
DISPONIBLE boolean,
RUTA varchar(100)
);

CREATE TABLE UnidadDidactica (
ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
ACRONIMO varchar(10),
TITULO varchar(100),
EVALUACION varchar(50),
DESCRIPCION varchar(200)
);

CREATE TABLE EnunciadoUnidad (
E_ID int,
UD_ID int,
PRIMARY KEY (E_ID, UD_ID),
FOREIGN KEY (E_ID) REFERENCES Enunciado (ID) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (UD_ID) REFERENCES UnidadDidactica (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Convocatoria (
CONVOCATORIA varchar(50) PRIMARY KEY NOT NULL,
DESCRIPCION varchar(200),
FECHA Date,
CURSO varchar(50),
E_ID int,
FOREIGN KEY (E_ID) REFERENCES Enunciado (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO Enunciado (DESCRIPCION, NIVEL, DISPONIBLE, RUTA) VALUES
("Descripcion de ejemplo 1", "ALTO", true, "Por la derecha"),
("Descripcion de ejemplo 2", "MEDIO", false, "A la izquierda");

INSERT INTO UnidadDidactica (ACRONIMO, TITULO, EVALUACION, DESCRIPCION) VALUES
("ACNM", "Titulo 1", "Primera", "Descripcion de ejemplo 3"),
("ACRM", "Titulo 2", "Tercera", "Descripcion de ejemplo 4");

INSERT INTO EnunciadoUnidad VALUES
(1, 1),
(2, 1);

INSERT INTO Convocatoria VALUES
("Primera Convocatoria", "Descripcion de ejemplo 5", '2025-01-04', "Mantenimiento", 1),
("Segunda Convocatoria", "Descripcion de ejemplo 6", '2025-02-24', "Electronica", 1);


