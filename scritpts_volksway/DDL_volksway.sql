CREATE DATABASE bd_volksway;

USE bd_volksway;


CREATE TABLE tb_empresas(
	id_empresa BINARY(16) NOT NULL,
	razaoSocial VARCHAR(50) NOT NULL,
    cidade VARCHAR(50) NOT NULL,
    cnpj CHAR(18) NOT NULL UNIQUE,
    PRIMARY KEY(id_empresa)
);

CREATE TABLE tb_usuarios(
	id_usuario BINARY(16) NOT NULL,
    telefone VARCHAR (15),
    email VARCHAR (50) NOT NULL UNIQUE,
    senha VARCHAR (50) NOT NULL,
    dataNascimento DATE NOT NULL,
    cidade VARCHAR (50) NOT NULL,
    cpf CHAR(14) NOT NULL,
    tipoUsuario TINYINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    PRIMARY KEY(id_usuario),
    FOREIGN KEY(id_empresa) REFERENCES tb_empresas(id_empresa)
);



CREATE TABLE tb_veiculos(
	id_veiculo BINARY(16) NOT NULL,
	codigoChassi CHAR(20) NOT NULL,
    marca VARCHAR(30) NOT NULL,
    placa CHAR(8) NOT NULL,
    PRIMARY KEY(id_veiculo),
    FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
); 

CREATE TABLE tb_checklists(
	id_checklist BINARY(16) NOT NULL,
	freio BIT(1) NOT NULL,
    combustivel BIT(1) NOT NULL,
    oleo BIT(1) NOT NULL,
    fotoPneu VARCHAR(255) NOT NULL,
    arCondicionado BIT(1) NOT NULL,
    PRIMARY KEY(id_checklist),
    FOREIGN KEY(id_veiculo) REFERENCES tb_veiculos(id_veiculo)
);
     
CREATE TABLE tb_propagandas(
id_propaganda BINARY(16) NOT NULL,
titulo VARCHAR(50) NOT NULL,
url VARCHAR(255) NOT NULL,
descricao VARCHAR(255) NOT NULL,
img VARCHAR(255) NOT NULL,
publicoAlvo VARCHAR(30) NOT NULL,
dataLimite DATE NOT NULL,
preco FLOAT(10, 2),
importancia BIT(1) NOT NULL,
nomeTipoPropaganda VARCHAR(20) NOT NULL,
PRIMARY KEY(id_propaganda),
FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario) 
);

CREATE TABLE tb_interesses(
	id_interesse BINARY(16) NOT NULL,
    meioContatoEmail BIT(1),
    PRIMARY KEY(id_interesse),
    FOREIGN KEY(id_propaganda) REFERENCES tb_propagandas(id_propaganda),
    FOREIGN KEY(id_usuario) REFERENCES tb_usuarios(id_usuario)
);