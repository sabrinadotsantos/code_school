USE bd_vsconnect;

/*UUID CONVERTENDO ID PARA BINARIO - DML*/
INSERT INTO tb_techs VALUES (UUID_TO_BIN(UUID()), "html");
INSERT INTO tb_techs VALUES (UUID_TO_BIN(UUID()), "css");
INSERT INTO tb_techs VALUES (UUID_TO_BIN(UUID()), "react");


/* CONVERTENDO BIN PARA UUID*/

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())), 
    "Odirlei",
    "odirlei@email.com",
    "senai",
    "Rua Niterói, 180",
    "12345-678",
    0
);

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())), 
    "Jessica",
    "jessica@email.com",
    "senai",
    "Rua Niterói, 180",
    "12345-678",
    0
);

INSERT INTO tb_usuarios VALUES (
	(UUID_TO_BIN(UUID())), 
    "Alexia",
    "alexia@email.com",
    "senai",
    "Rua Niterói, 180",
    "12345-678",
    0
);

/*TODOS OS SELECTS*/

SELECT * FROM tb_usuarios;
SELECT BIN_TO_UUID(id_usuario), nome FROM tb_usuarios;
SELECT BIN_TO_UUID(id_tech), nome FROM tb_techs;
SELECT  BIN_TO_UUID(id_servico), titulo FROM tb_servicos;
/**/


DELETE FROM tb_usuarios WHERE id_usuario = UUID_TO_BIN("13b1b19b-6ee0-11ee-9cdc-b445067b827e");

UPDATE tb_usuarios
SET tipo_usuario = 1
WHERE id_usuario = UUID_TO_BIN("e104fd08-6edf-11ee-9cdc-b445067b827e");

INSERT INTO tb_dev_tech VALUES (UUID_TO_BIN("e104fd08-6edf-11ee-9cdc-b445067b827e"), UUID_TO_BIN("d505c682-6edf-11ee-9cdc-b445067b827e"));
INSERT INTO tb_dev_tech VALUES (UUID_TO_BIN("e104fd08-6edf-11ee-9cdc-b445067b827e"), UUID_TO_BIN("d3b7a762-6edf-11ee-9cdc-b445067b827e"));
INSERT INTO tb_dev_tech VALUES (UUID_TO_BIN("e104fd08-6edf-11ee-9cdc-b445067b827e"), UUID_TO_BIN("d662350c-6edf-11ee-9cdc-b445067b827e"));

INSERT INTO tb_servicos VALUES
    (UUID_TO_BIN(UUID()), "Dashboard", "Desenvolver uma dashboard com informações importantes do nosso controle de vendas.", "3000", "Concluído", UUID_TO_BIN("de73e33e-6edf-11ee-9cdc-b445067b827e"), NULL),
    (UUID_TO_BIN(UUID()), "Desenvolvimento de site institucional - Gateway de Pagamento / Fintech", "Desenvolver um site responsivo que seja utilizado como uma plataforma de apresentação do nosso gateway de pagamento. O objetivo principal deste projeto é criar um site atraente e informativo, que demonstre as funcionalidades e benefícios do nosso gateway de pagamento para potenciais clientes.", "1300", "Em andamento", UUID_TO_BIN("de73e33e-6edf-11ee-9cdc-b445067b827e"), NULL),
    (UUID_TO_BIN(UUID()), "Preciso da estrutura de uma HomePage", "Preciso fazer uma tela somente estruturada em HTML para minha empresa.", "1000", "Pendente", UUID_TO_BIN("de73e33e-6edf-11ee-9cdc-b445067b827e"), NULL);

INSERT INTO tb_cotacao VALUES (
	UUID_TO_BIN(UUID()),
    10000.00,
    UUID_TO_BIN("13b1b19b-6ee0-11ee-9cdc-b445067b827e"), /*id do dev*/
    UUID_TO_BIN("1f9531ab-6ee2-11ee-9cdc-b445067b827e") /*id do servico*/
);

INSERT INTO tb_tech_servico VALUES(UUID_TO_BIN("d505c682-6edf-11ee-9cdc-b445067b827e"), UUID_TO_BIN("1f9531ab-6ee2-11ee-9cdc-b445067b827e"));
INSERT INTO tb_tech_servico VALUES(UUID_TO_BIN("d3b7a762-6edf-11ee-9cdc-b445067b827e"), UUID_TO_BIN("1f9531ab-6ee2-11ee-9cdc-b445067b827e"));

