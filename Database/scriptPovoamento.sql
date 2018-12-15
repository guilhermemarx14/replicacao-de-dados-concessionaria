USE ConcessionariaDB;




INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (0, 1, NULL, 'carro', 'Gol', 'Volkswagen', 'cinza');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (1254,3,'ABC-1234','caminhao','R440','Scania','azul');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (5400,3,'NFS-0059','carro','Uno','Fiat','vermelho');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (249,3,'PQK-0693','moto','CG 160','Honda','vermelho');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (500,1,'KIT-2424','van','Sprinter','Mercedes-Benz','azul');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (0,1,NULL,'moto','Fazer 250','Yamaha','preto');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (1240,1,'SCA-1298','carro','Palio','Fiat','preto');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (1555,1,'LQK-5764','carro','Fox','Volkswagen','branco');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (10059,2,'AQB-0318','carro','HB20','Hyundai','vermelho');
INSERT INTO Veiculo(km,situacao,placa,tipo,modelo,montadora,cor) VALUES (20565,2,'IFA-4340','caminhao','FH 540','Volvo','branco');

INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(1,43415.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(5,130000.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(6,12000.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(7,35000.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(8,40000.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(9,30000.00);
INSERT INTO Pvenda(idVeiculo,precoVenda) VALUES(10,320000.00);

INSERT INTO Paluguel(idVeiculo,precoFixo,precoPorKm) VALUES(5,300.00,0.50);
INSERT INTO Paluguel(idVeiculo,precoFixo,precoPorKm) VALUES(7,80.00,0.30);
INSERT INTO Paluguel(idVeiculo,precoFixo,precoPorKm) VALUES(8,80.00,0.30);
INSERT INTO Paluguel(idVeiculo,precoFixo,precoPorKm) VALUES(9,150.00,0.30);
INSERT INTO Paluguel(idVeiculo,precoFixo,precoPorKm) VALUES(10,400.00,0.50);

INSERT INTO Funcionario(cpfFuncionario,salarioFixo,nome,telefone) VALUES('05345776144',954.00,'Guilherme Marx Ferreira Tavares', '31985115976');
INSERT INTO Funcionario(cpfFuncionario,salarioFixo,nome,telefone) VALUES('12345665400',1351.46,'Walderice Santos da Conceição','54987675437');
INSERT INTO Funcionario(cpfFuncionario,salarioFixo,nome,telefone) VALUES('65434512409',1500.00,'José da Silva dos Anjos','33981023498');
INSERT INTO Funcionario(cpfFuncionario,salarioFixo,nome,telefone) VALUES('33344455511',1732.90,'Maria Aparecida Selvagem','21912345678');

INSERT INTO Vendedor(cpfFuncionario,porcentagemComissao) VALUES('05345776144',5);
INSERT INTO Vendedor(cpfFuncionario,porcentagemComissao) VALUES('12345665400',3);

INSERT INTO Mecanico(cpfFuncionario,comissaoPorRevisao) VALUES('65434512409',100.00);
INSERT INTO Mecanico(cpfFuncionario,comissaoPorRevisao) VALUES('33344455511',80.00);

INSERT INTO Cliente(telefone,nome,cep,complemento,numero,numCartao,numConta) VALUES('31900001111','Geraldine dos Santos Apocalipse','17980322','Apto 902','192','1234567812345678','406089');
INSERT INTO Cliente(telefone,nome,cep,complemento,numero,numCartao,numConta) VALUES('33922223333','Funerária Semente LTDA.','35930022',NULL,'33','9876123409875464','165789098');
INSERT INTO Cliente(telefone,nome,cep,complemento,numero,numCartao,numConta) VALUES('35955557777','Joaquim da Boa Conquista',NULL,NULL,NULL,'0783120987194321','98345765');

INSERT INTO Pfisica(idCliente,cpf) VALUES(1,'17898789698');
INSERT INTO Pfisica(idCliente,cpf) VALUES(3,'29887367888');

INSERT INTO Pjuridica(idCliente,cnpj) VALUES(2,'88227721000-80');

INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(0.00,'01/11/2018',1,120.00,2,'65434512409');
INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(0.00,'10/11/2018',1,120.00,2,'65434512409');
INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(0.00,'03/11/2018',2,120.00,3,'65434512409');
INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(150.00,'04/11/2018',2,120.00,4,'33344455511');
INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(150.00,'05/11/2018',2,120.00,9,'33344455511');
INSERT INTO Revisao(valorConserto,dataRevisao,idCliente,valorRevisao,idVeiculo,idMecanico) VALUES(150.00,'06/11/2018',3,180.00,10,'33344455511');

INSERT INTO Aluguel(idVeiculo,idCliente,idVendedor,idRevisao,valorTotal,kmRodados,dataFim,dataInicio,multaAtraso,finalizado) VALUES(10,3,'05345776144',6,NULL,NULL,'30/11/2018','07/11/2018',NULL,0);
INSERT INTO Aluguel(idVeiculo,idCliente,idVendedor,idRevisao,valorTotal,kmRodados,dataFim,dataInicio,multaAtraso,finalizado) VALUES(3,2,'05345776144',3,154.80,50,'13/11/2018','04/11/2018',0.00,1);
INSERT INTO Aluguel(idVeiculo,idCliente,idVendedor,idRevisao,valorTotal,kmRodados,dataFim,dataInicio,multaAtraso,finalizado) VALUES(4,2,'05345776144',4,162.90,86,'14/11/2018','05/11/2018',40.00,1);
INSERT INTO Aluguel(idVeiculo,idCliente,idVendedor,idRevisao,valorTotal,kmRodados,dataFim,dataInicio,multaAtraso,finalizado) VALUES(2,1,'12345665400',2,250.30,94,'15/11/2018','02/11/2018',30.00,1);
INSERT INTO Aluguel(idVeiculo,idCliente,idVendedor,idRevisao,valorTotal,kmRodados,dataFim,dataInicio,multaAtraso,finalizado) VALUES(9,2,'12345665400',5,NULL,NULL,'29/11/2018','06/11/2018',NULL,0);

INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('20/10/2018','05345776144',1,1,-40000.00, false);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('21/10/2018','05345776144',2,6,-15000.00, true);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('25/10/2018','12345665400',3,9,-27000.00, false);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('27/10/2018','12345665400',1,10,-300000.00, false);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('20/11/2018','05345776144',2,7,-32000.00, false);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('21/11/2018','12345665400',2,4,11000.00, false);
INSERT INTO CompraVenda(dataCompraVenda,idVendedor,idCliente,idVeiculo,valorCompraVenda, troca) VALUES('21/10/2018','05345776144',2,3,27000.00, true);

-- Inserir na Tabela Troca
INSERT INTO Troca
SELECT * FROM (
SELECT  IDVenda, IDCompra
FROM ( 	SELECT IDCompraVenda AS IDCompra, IDCliente, DATACOMPRAVENDA
		FROM COMPRAVENDA
		WHERE valorCompraVenda<0 AND TROCA) AS Compra
iNNER JOIN
(		SELECT IDCompraVenda AS IDVenda, IDCliente,  DATACOMPRAVENDA
		FROM COMPRAVENDA
		WHERE valorCompraVenda>0 AND TROCA) AS Venda

ON (Compra.IDCliente = Venda.IDCliente AND Compra.DataCompravenda = Venda.DataCompravenda)
) AS Res ;
