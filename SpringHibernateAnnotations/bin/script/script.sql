CREATE DATABASE IF NOT EXISTS spring;  
USE spring;

CREATE TABLE IF NOT EXISTS usuario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(100) DEFAULT NULL,
  email varchar(100) DEFAULT NULL,
  senha varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

INSERT INTO usuario (nome, email, senha) VALUES ('Administrador', 'admin@gmail.com', '123');