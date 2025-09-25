DROP DATABASE examendb;
CREATE DATABASE examendb;
USE examendb;


CREATE TABLE ExamStatement (
ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
DESCRIPTION varchar(200),
NIVEL ENUM('ALTO', 'MEDIO', 'BAJO'),
AVAIABLE boolean,
RUTA varchar(100)
);

CREATE TABLE TeachingUnit (
ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
ACRONIM varchar(10),
TITLE varchar(100),
EVALUATION varchar(50),
DESCRIPTION varchar(200)
);

CREATE TABLE StatementUnit (
E_ID int,
UD_ID int,
PRIMARY KEY (E_ID, UD_ID),
FOREIGN KEY (E_ID) REFERENCES ExamStatement (ID) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (UD_ID) REFERENCES TeachingUnit (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ExamSession (
CONVOCATORIA varchar(50) PRIMARY KEY NOT NULL,
DESCRIPTION varchar(200),
SESSION_DATE Date,
COURSE varchar(50),
E_ID int,
FOREIGN KEY (E_ID) REFERENCES ExamStatement (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO ExamStatement (DESCRIPTION, NIVEL, AVAIABLE, RUTA) VALUES
("Descripcion de ejemplo 1", "ALTO", true, "Por la derecha"),
("Descripcion de ejemplo 2", "MEDIO", false, "A la izquierda");

INSERT INTO TeachingUnit (ACRONIM, TITLE, EVALUATION, DESCRIPTION) VALUES
("ACNM", "Titulo 1", "Primera", "Descripcion de ejemplo 3"),
("ACRM", "Titulo 2", "Tercera", "Descripcion de ejemplo 4");

INSERT INTO StatementUnit VALUES
(1, 1),
(2, 1);

INSERT INTO ExamSession VALUES
("Primera Convocatoria", "Descripcion de ejemplo 5", '2025-01-04', "Mantenimiento", 1),
("Segunda Convocatoria", "Descripcion de ejemplo 6", '2025-02-24', "Electronica", 1);
