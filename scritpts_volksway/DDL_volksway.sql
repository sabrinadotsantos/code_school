CREATE DATABASE bd_volksway;

USE bd_volksway;

DROP TABLE tipo_usuario;


CREATE TABLE tb_empresas(
	id_empresa BINARY(16) NOT NULL,
	razao_social VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    cnpj CHAR(18) NOT NULL UNIQUE,
    PRIMARY KEY(id_empresa)
);

DROP database bd_volksway;

DROP TABLE tb_usuarios;

CREATE TABLE tb_usuarios(
	id_usuario BINARY(16) NOT NULL,
    id_empresa BINARY(16) NOT NULL,
    telefone VARCHAR (15),
    email VARCHAR (50) NOT NULL UNIQUE,
    senha VARCHAR (50) NOT NULL,
    data_nascimento DATE NOT NULL,
    cidade VARCHAR (50) NOT NULL,
    cpf CHAR(14) NOT NULL,
    tipo_usuario TINYINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_usuario),
    FOREIGN KEY(id_empresa) REFERENCES tb_empresas(id_empresa)
);


CREATE TABLE tb_veiculos(
	id_veiculo BINARY(16) NOT NULL,
    id_usuario BINARY(16) NOT NULL,
	codigo_chassi CHAR(20) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    placa CHAR(8) NOT NULL,
    PRIMARY KEY(id_veiculo),
    FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
);

CREATE TABLE tb_checklists(
	id_checklist BINARY(16) NOT NULL,
    id_veiculo BINARY(16) NOT NULL,
	freio BIT NOT NULL,
    combustivel BIT NOT NULL,
    oleo BIT NOT NULL,
    foto_pneu VARCHAR(255) NOT NULL,
    ar_condicionado BIT NOT NULL,
    PRIMARY KEY(id_checklist),
    FOREIGN KEY(id_veiculo) REFERENCES tb_veiculos(id_veiculo)
);

DROP TABLE tb_propagandas;

CREATE TABLE tb_propagandas(
id_propaganda BINARY(16) NOT NULL,
id_usuario BINARY(16) NOT NULL,
titulo VARCHAR(50) NOT NULL,
url VARCHAR(255) NOT NULL,
descricao VARCHAR(255) NOT NULL,
img VARCHAR(255) NOT NULL,
publico_alvo VARCHAR(30) NOT NULL,
data_limite DATE NOT NULL,
preco FLOAT(10, 2),
importancia BIT NOT NULL,
nome_tipo_propaganda VARCHAR(20) NOT NULL,
PRIMARY KEY(id_propaganda),
FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
);

CREATE TABLE tb_interesses(
	id_interesse BINARY(16) NOT NULL,
    id_propaganda BINARY(16) NOT NULL,
    id_usuario BINARY(16) NOT NULL,
    email BIT, -- meio_contato_email
    PRIMARY KEY(id_interesse),
    FOREIGN KEY(id_propaganda) REFERENCES tb_propagandas(id_propaganda),
    FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
);
