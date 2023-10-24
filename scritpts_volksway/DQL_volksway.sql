USE bd_volksway;

SELECT COUNT(id_empresa) FROM tb_empresas;

SELECT * FROM tb_empresas WHERE tb_empresas.cidade LIKE "São Paulo";

SELECT nome FROM tb_usuarios ORDER BY nome ASC;