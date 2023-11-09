USE bd_volksway;

INSERT INTO tb_empresas VALUES (
	(UUID_TO_BIN(UUID())),
    "Caminhoes LTDA",
    "Rio de Janeiro",
    "123456789098765432"
);

INSERT INTO tb_empresas VALUES (
	(UUID_TO_BIN(UUID())),
    "Volks LTDA",
    "Bahia",
    "12346789098765432"
);

SELECT * FROM tb_empresas;
SELECT BIN_TO_UUID(id_empresa), razao_social FROM tb_empresas;

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('46ae3cba-7910-11ee-bfa0-b445067b827e'),
    "1155554444",
    "sabrina@email.com",
    "senai",
    "1997-12-19",
    "Sao Paulo",
    00000000000,
    1,
    "Sabrina Santos da Silva"
);

SELECT * FROM tb_usuarios;
SELECT BIN_TO_UUID(id_usuario), nome FROM tb_usuarios;

INSERT INTO tb_veiculos VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('54a24d8d-7910-11ee-bfa0-b445067b827e'),
    "1234567899876543210"
    "Volkswagen",
    "ABC445K9"
);

SELECT * FROM tb_veiculos;

INSERT INTO tb_checklists VALUES (
	(UUID_TO_BIN(UUID())),
    1,
    1,
    1,
    "teste",
    1
);

INSERT INTO tb_propagandas VALUES (
	(UUID_TO_BIN(UUID())),
    "Propaganda Teste",
	"teste teste",
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit",
    "img teste",
    "motorista",
    "2024/23/10"
    "",
    1,
    "Banner"
);

INSERT INTO tb_interesses VALUES (
	(UUID_TO_BIN(UUID())),
	1
);





