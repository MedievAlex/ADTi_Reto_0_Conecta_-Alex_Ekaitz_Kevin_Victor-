DROP DATABASE examendb;
CREATE DATABASE examendb;
USE examendb;

CREATE TABLE TeachingUnit (
ACRONIM varchar(10) PRIMARY KEY NOT NULL,
TITLE varchar(100),
EVALUATION varchar(50),
DESCRIPTION varchar(200)
);

CREATE TABLE ExamStatement (
ID int AUTO_INCREMENT PRIMARY KEY NOT NULL,
DESCRIPTION varchar(200),
STATEMENT_LEVEL ENUM('ALTO', 'MEDIO', 'BAJO'),
AVAIABLE boolean,
RUTA varchar(100)
);

CREATE TABLE StatementUnit (
TU_ACRONIM varchar(10),
ES_ID int,
PRIMARY KEY (TU_ACRONIM, ES_ID),
FOREIGN KEY (TU_ACRONIM) REFERENCES TeachingUnit (ACRONIM) ON UPDATE CASCADE ON DELETE CASCADE,
FOREIGN KEY (ES_ID) REFERENCES ExamStatement (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE ExamSession (
CONVOCATORIA varchar(50) PRIMARY KEY NOT NULL,
DESCRIPTION varchar(200),
SESSION_DATE Date,
COURSE varchar(50),
E_ID int,
FOREIGN KEY (E_ID) REFERENCES ExamStatement (ID) ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO TeachingUnit (ACRONIM, TITLE, EVALUATION, DESCRIPTION) VALUES
("DIN", "Desarollo de Interfaces", "Primera", "Implanta sistemas y aplicaciones informáticas sobre entornos específicos."),
("ADTi", "Acceso a Datos Inglés", "Tercera", "Desarrolla aplicaciones y componentes de acceso a datos, gestionando su persistencia y garantizando la seguridad y calidad de los mismos.");

INSERT INTO ExamStatement (DESCRIPTION, STATEMENT_LEVEL, AVAIABLE, RUTA) VALUES
("Genera un programa con interfaz para una aplicación de compraventa utilizando una base de datos.", "ALTO", true, "Por la derecha"),
("Crea un esquema del funcionamiento de una aplicacion generica.", "BAJO", false, "A la izquierda");

INSERT INTO StatementUnit VALUES
("DIN", 1),
("ADTi", 1);

INSERT INTO ExamSession VALUES
("Primera Convocatoria", "Examen para la clase 208", '2025-01-04', "2DAMi", 1),
("Segunda Convocatoria", "Examend e recuperacion tanto para 1º como 2º DAMi", '2025-02-24', "2DAMi", 1);