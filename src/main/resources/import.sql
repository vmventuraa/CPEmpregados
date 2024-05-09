INSERT INTO tb_departamento(nome) VALUES('Recursos Humanos');
INSERT INTO tb_departamento(nome) VALUES('Telecomunicações');
INSERT INTO tb_departamento(nome) VALUES('Tecnologia');
INSERT INTO tb_departamento(nome) VALUES('Marketing');
INSERT INTO tb_departamento(nome) VALUES('Financeiro');

INSERT INTO tb_projeto (nome) VALUES ('Sistema Financeiro');
INSERT INTO tb_projeto (nome) VALUES ('Recrutamento');
INSERT INTO tb_projeto (nome) VALUES ('Dashboards');
INSERT INTO tb_projeto (nome) VALUES ('Sistema de Marketing');
INSERT INTO tb_projeto (nome) VALUES ('Publicidade Digital');

INSERT INTO tb_empregado(nome, email,salario, departamento_id) VALUES('Victor', 'victor@gmail.com', 2000.0, 1);
INSERT INTO tb_empregado(nome, email,salario, departamento_id) VALUES('Gustavo', 'gusta@hotmail.com', 1600.0, 2);
INSERT INTO tb_empregado(nome, email,salario, departamento_id) VALUES('Amanda', 'amanda@ig.com.br', 4000.0, 3);
INSERT INTO tb_empregado(nome, email,salario, departamento_id) VALUES('Bruna', 'bru@gmail.com', 1800.0, 4);
INSERT INTO tb_empregado(nome, email,salario, departamento_id) VALUES('Manuela', 'manu@gmail.com', 3000.0, 5);

INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (1, 1);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (1, 2);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (2, 4);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (3, 2);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (3, 4);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (3, 5);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (4, 1);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (4, 2);
INSERT INTO tb_empregado_projeto (empregado_id, projeto_id) VALUES (5, 5);






