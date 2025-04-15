DROP DATABASE IF EXISTS TiendaLibros;

CREATE DATABASE TiendaLibros;

USE TiendaLibros;

DROP TABLE IF EXISTS usuarios;

CREATE TABLE Usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    sexo VARCHAR(50) NOT NULL
);


DROP TABLE IF EXISTS libros;

CREATE TABLE Libros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    autor VARCHAR(255) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    imagen VARCHAR(255),
    editorial VARCHAR(255)
);


INSERT INTO Libros (titulo, autor, precio, imagen, editorial) VALUES
('El Principito', 'Antoine de Saint-Exupéry', 120.50, 'el_principito.jpg', 'Editorial Juventud'),
('1984', 'George Orwell', 200.00, '1984.jpg', 'Secker & Warburg'),
('Cien Años de Soledad', 'Gabriel García Márquez', 150.00, 'cien_anos_de_soledad.jpg', 'Editorial Sudamericana'),
('Don Quijote de la Mancha', 'Miguel de Cervantes', 250.75, 'don_quijote.jpg', 'Francisco de Robles'),
('La Metamorfosis', 'Franz Kafka', 180.50, 'metamorfosis.jpg', 'Kurt Wolff Verlag');


DROP TABLE IF EXISTS ordenes;


CREATE TABLE Ordenes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    total DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (usuario_id) REFERENCES Usuarios(id)
);


DROP TABLE IF EXISTS detallesordenes;


CREATE TABLE DetallesOrdenes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    orden_id INT NOT NULL,
    libro_id INT NOT NULL,
    cantidad INT NOT NULL,
    subtotal DECIMAL(10,2) NOT NULL,
    FOREIGN KEY (orden_id) REFERENCES Ordenes(id),
    FOREIGN KEY (libro_id) REFERENCES Libros(id)
);