USE bd_volksway;

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())), 
    "1155554444",
    "sabrina@email.com",
    "senai",
    "1997/19/12",
    "Sao Paulo",
    00000000000,
    1,
    "Sabrina Santos da Silva"
);

INSERT INTO tb_empresas VALUES (
	(UUID_TO_BIN(UUID())),
    "Caminhoes LTDA",
    "Rio de Janeiro"
    "123456789098765432"
);

INSERT INTO tb_veiculos VALUES (
	(UUID_TO_BIN(UUID())),
    "12345678909876543210"
    "Volkswagen",
    "ABC445K9"
);

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





