CREATE DATABASE IF NOT EXISTS Library CHARACTER SET utf8mb4 COLLATE utf8mb4_bin;
USE Library;

CREATE TABLE `usuario` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) UNIQUE NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` bit not null,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
);

CREATE TABLE `autor` (
  `id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `name` varchar(45) UNIQUE NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

CREATE TABLE `libro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ISBN` varchar(15) UNIQUE NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `autor_id` int NOT NULL,
  `editorial` varchar(45) NOT NULL,
  `disponibilidad` boolean,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  FOREIGN KEY (autor_id) REFERENCES autor(id) ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE `pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `ISAN` varchar(15) UNIQUE NOT NULL,
  `titulo` varchar(255) NOT NULL,
  `duracion` int NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `disponibilidad` boolean,
  PRIMARY KEY (`id`)
);

CREATE TABLE `prestamo_libro` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `libro_id` int NOT NULL,
  `dia_prestamo` TIMESTAMP NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE (`usuario_id`, `libro_id`),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (libro_id) REFERENCES libro(id) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE `prestamo_pelicula` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `usuario_id` int NOT NULL,
  `pelicula_id` int NOT NULL,
  `dia_prestamo` TIMESTAMP NOT NULL,
  `created_at` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `updated_at` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE (`usuario_id`, `pelicula_id`),
  FOREIGN KEY (usuario_id) REFERENCES usuario(id) ON UPDATE CASCADE ON DELETE CASCADE,
  FOREIGN KEY (pelicula_id) REFERENCES pelicula(id) ON UPDATE CASCADE ON DELETE CASCADE
);


