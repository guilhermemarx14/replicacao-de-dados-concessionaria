DROP DATABASE IF EXISTS `ConcessionariaDB`;
CREATE DATABASE IF NOT EXISTS `ConcessionariaDB` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_ci;

drop user if exists concessionaria@localhost;
flush privileges;
create user concessionaria@localhost identified by '';
GRANT ALL PRIVILEGES ON ConcessionariaDB.* TO concessionaria@localhost;

USE ConcessionariaDB;

CREATE TABLE Veiculo(
	idVeiculo INT(5) AUTO_INCREMENT PRIMARY KEY,
	km INT(10) NOT NULL,
	situacao INT NOT NULL,
	placa VARCHAR(10) UNIQUE,
	tipo VARCHAR(15) NOT NULL,
	modelo VARCHAR(15) NOT NULL,
	montadora VARCHAR(15) NOT NULL,
	cor VARCHAR(10) NOT NULL
);


CREATE TABLE Pvenda(
	idVeiculo INT(5) NOT NULL,
	precoVenda FLOAT(10) NOT NULL,
	PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo)
);

CREATE TABLE Paluguel(
	idVeiculo INT(5) NOT NULL,
	precoFixo FLOAT(10) NOT NULL,
	precoPorKm FLOAT(10) NOT NULL,
	PRIMARY KEY (idVeiculo),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo)
);

CREATE TABLE Funcionario(
	cpfFuncionario VARCHAR(15) NOT NULL PRIMARY KEY UNIQUE,
	salarioFixo FLOAT(10) NOT NULL,
	nome VARCHAR(50) NOT NULL,
	telefone VARCHAR(15)
);

CREATE TABLE Vendedor(
	cpfFuncionario VARCHAR(15) NOT NULL,
	porcentagemComissao INT(2) NOT NULL,
	PRIMARY KEY (cpfFuncionario),
	FOREIGN KEY (cpfFuncionario) REFERENCES Funcionario(cpfFuncionario)
);

CREATE TABLE Mecanico(
	cpfFuncionario VARCHAR(15) NOT NULL,
	comissaoPorRevisao FLOAT(5) NOT NULL,
	PRIMARY KEY (cpfFuncionario),
	FOREIGN KEY (cpfFuncionario) REFERENCES Funcionario(cpfFuncionario)
);

CREATE TABLE Cliente(
	idCliente INT(5) AUTO_INCREMENT PRIMARY KEY,
	telefone VARCHAR(15),
	nome VARCHAR(50) NOT NULL,
	cep VARCHAR(10),
	complemento VARCHAR(30),
	numero VARCHAR(5),
	numCartao VARCHAR(20) NOT NULL,
	numConta VARCHAR(20) NOT NULL
);

CREATE TABLE Pfisica(
	idCliente INT(5) NOT NULL,
	cpf VARCHAR(15) NOT NULL UNIQUE,
	PRIMARY KEY (idCLiente),
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

CREATE TABLE Pjuridica(
	idCliente INT(5) NOT NULL,
	cnpj VARCHAR(20) NOT NULL UNIQUE,
	PRIMARY KEY (idCLiente),
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);


CREATE TABLE Revisao(
	idRevisao INT(5) AUTO_INCREMENT PRIMARY KEY,
	efetivado TINYINT(1) DEFAULT 1,
	valorConserto FLOAT(10),
	dataRevisao VARCHAR(11) NOT NULL,
	idCliente INT(5) NOT NULL,
	valorRevisao FLOAT(10),
	idVeiculo INT(5) NOT NULL,
	idMecanico VARCHAR(15) NOT NULL,
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo),
	FOREIGN KEY (idMecanico) REFERENCES Funcionario(cpfFuncionario)
);

CREATE TABLE Aluguel(
	idVeiculo INT(5) NOT NULL,
	idCliente INT(5) NOT NULL,
	idVendedor VARCHAR(15) NOT NULL,
	idRevisao INT(5) NOT NULL,
	PRIMARY KEY (idVeiculo,idCliente,idVendedor,idRevisao),
	valorTotal FLOAT(10),
	kmRodados INT(5),
	dataFim VARCHAR(11),
	dataInicio VARCHAR(11) NOT NULL,
	multaAtraso FLOAT(10),
	finalizado TINYINT(1) DEFAULT 0,
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo),
	FOREIGN KEY (idVendedor) REFERENCES Funcionario(cpfFuncionario),
	FOREIGN KEY (idRevisao) REFERENCES Revisao(idRevisao)
);

CREATE TABLE CompraVenda(
	idCompraVenda INT(5) AUTO_INCREMENT PRIMARY KEY,
	dataCompraVenda VARCHAR(11) NOT NULL,
	idVendedor VARCHAR(15) NOT NULL,
	idCliente INT(5) NOT NULL,
	idVeiculo INT(5) NOT NULL,
	valorCompraVenda FLOAT(10) NOT NULL,
    troca boolean DEFAULT false,
	FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
	FOREIGN KEY (idVeiculo) REFERENCES Veiculo(idVeiculo),
	FOREIGN KEY (idVendedor) REFERENCES Funcionario(cpfFuncionario)
);


CREATE TABLE Troca (
	idVenda INT(5) NOT NULL,
	idCompra INT(5) NOT NULL,
	PRIMARY KEY (idVenda,idCompra),
	FOREIGN KEY (idVenda) REFERENCES CompraVenda(idCompraVenda),
	FOREIGN KEY (idCompra) REFERENCES CompraVenda(idCompraVenda)
);
