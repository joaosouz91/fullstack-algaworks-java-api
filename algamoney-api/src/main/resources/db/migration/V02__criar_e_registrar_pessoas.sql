CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(70) NOT NULL,
	ativo TINYINT(1) NOT NULL,
	logradouro VARCHAR(100) NOT NULL,
	numero VARCHAR(10) NOT NULL,
	complemento VARCHAR(15),
	bairro VARCHAR(70) NOT NULL,
	cep VARCHAR(9) NOT NULL,
	cidade VARCHAR(30),
	estado VARCHAR(25)
) 	ENGINE=InnoDB
	DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('João Victor de Souza Santos', 1, 'Rua Nebraska', '246', 'apto 31', 'Brooklin Novo', '04560-010', 'São Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Raphaela Jordânia', 1, 'Rua Kansas', '334', 'apto 14B', 'Brooklin', '04560-001', 'São Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Charles Miller', 1, 'Av dos Pinhais', '2076', null, 'Bairro dos Açus', '05579-987', 'Cuiabá', 'MT');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Giselle Martins dos Santos', 0, 'Rua Jardim França', '876', 'Casa 2', 'Noival', '87659-772', 'Pinhais', 'CE');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Marcos Filho', 1, 'Rua Marechal', '1020', null, 'Pujol', '87659-772', 'Sao Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Guerrero Nesto', 1, 'Rua Marechal', '12', null, 'Boçal', '05579-987', 'Sao Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Erick Moveda', 1, 'Rua dos Passaros', '567', 'apto 67', 'Minhard', '04560010', 'Sao Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Eleanora Fitzgerald', 1, 'Rua Moema', '10343', 'apto 56', 'Jumengard', '05579-987', 'Sao Paulo', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Genesio Dos Santos', 1, 'Av dos Indios', '6745', null, 'Pueri', '87459-732', 'Sao Vicente', 'SP');
	
INSERT INTO pessoa (nome, ativo, logradouro, numero, complemento, bairro, cep, cidade, estado) 
	values ('Genivaldo Botelho', 1, 'Travessa dos Curumins', '3456', null, 'Enio Pascoale', '45365-172', 'Paulista', 'BA');
