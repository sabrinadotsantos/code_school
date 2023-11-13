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
    UUID_TO_BIN('89751c1b-8176-11ee-9fae-641c679fcf32'),
    "1155554444",
    "sabrina@email.com",
    "senai",
    "1997-12-19",
    "Sao Paulo",
    00000000000,
    1,
    "Sabrina Santos da Silva"
);

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('8aca1f4d-8176-11ee-9fae-641c679fcf32'),
    "1155554444",
    "matheus@email.com",
    "senai",
    "1997-12-19",
    "Sao Paulo",
    "115615156",
    1,
    "Matheus Santos da Silva"
);

SELECT * FROM tb_usuarios;
SELECT BIN_TO_UUID(id_usuario), nome FROM tb_usuarios;

INSERT INTO tb_veiculos VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('9c408a7b-8176-11ee-9fae-641c679fcf32'),
    "1234567899876543210",
    "Volkswagen",
    "ABC445K9"
);

INSERT INTO tb_veiculos VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('9e8a60a2-8176-11ee-9fae-641c679fcf32'),
    "1234567879876543210",
    "Scania",
    "ABC445P9"
);

SELECT * FROM tb_veiculos;
SELECT BIN_TO_UUID(id_veiculo), placa FROM tb_veiculos;

INSERT INTO tb_checklists VALUES (
	(UUID_TO_BIN(UUID())),
   UUID_TO_BIN('ac1aae0a-8176-11ee-9fae-641c679fcf32'),
   1,
   1,
   1,
   "teste",
   1
);

SHOW ERRORS;

INSERT INTO tb_propagandas VALUES (
	(UUID_TO_BIN(UUID())),
     UUID_TO_BIN('9e8a60a2-8176-11ee-9fae-641c679fcf32'),
    "Propaganda Teste",
	"teste teste",
    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit",
    "img teste",
    "motorista",
    "2024-10-23",
    100.00,
    1,
    "Banner"
);

INSERT INTO tb_propagandas VALUES (
	(UUID_TO_BIN(UUID())),
     UUID_TO_BIN('9c408a7b-8176-11ee-9fae-641c679fcf32'),
    "Propaganda Teste",
	"teste teste",
    "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit",
    "img teste",
    "usuario",
    "2024-10-23",
    200.00,
    1,
    "Banner"
);

SELECT * FROM tb_propagandas;
SELECT BIN_TO_UUID(id_propaganda), titulo FROM tb_propagandas;

INSERT INTO tb_interesses VALUES (
	(UUID_TO_BIN(UUID())),
    UUID_TO_BIN('d326cf3e-8176-11ee-9fae-641c679fcf32'),
    UUID_TO_BIN('9e8a60a2-8176-11ee-9fae-641c679fcf32'),
	1
);

SELECT * FROM tb_interesses;

SHOW ERRORS;