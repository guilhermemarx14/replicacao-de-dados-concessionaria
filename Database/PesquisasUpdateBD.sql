SELECT *
FROM Cliente;

SELECT *
FROM Funcionario;

SELECT *
FROM Veiculo;

SELECT nome, idCliente
FROM Cliente;

SELECT nome, cpfFuncionario
FROM Funcionario;

SELECT F.*, M.comissaoPorRevisao, V.porcentagemComissao
FROM (Funcionario AS F LEFT OUTER JOIN Mecanico AS M ON F.cpfFuncionario = M.cpfFuncionario  LEFT OUTER JOIN Vendedor AS V ON F.cpfFuncionario = V.cpfFuncionario);

SELECT C.*, F.cpf,J.cnpj
FROM (Cliente AS C LEFT OUTER JOIN Pjuridica AS J ON C.idCLiente = J.idCLiente LEFT OUTER JOIN Pfisica AS F ON C.idCliente = F.idCLiente);

SELECT *
FROM Veiculo NATURAL JOIN Pvenda
NATURAL JOIN Paluguel;

SELECT *
FROM Funcionario NATURAL JOIN Mecanico;

SELECT *
FROM Funcionario NATURAL JOIN Vendedor;

SELECT *
FROM Cliente NATURAL JOIN Pjuridica;

SELECT *
FROM Cliente NATURAL JOIN Pfisica;

SELECT *
FROM Veiculo NATURAL JOIN Pvenda;

SELECT *
FROM Veiculo NATURAL JOIN Paluguel;

// todas compra/venda

SELECT  CP.dataCompraVenda, CP.valorCompraVenda, Veiculo.*, C.nome, F.nome
from (CompraVenda as CP natural join Veiculo) left outer join Cliente as C on CP.idCLiente = C.idCLiente left outer join Funcionario as F on CP.idVendedor = F.cpfFuncionario;

// todos alugueis

SELECT  Veiculo.*, C.nome, F.nome, A.dataInicio, A.dataFim, A.kmRodados, A.multaAtraso, A.valorTotal, Revisao.*
from (Aluguel as A natural join Veiculo) left outer join Cliente as C on A.idCLiente = C.idCLiente left outer join Funcionario as F on A.idVendedor = F.cpfFuncionario left outer join Revisao on A.idRevisao = Revisao.idRevisao;

// devolucao

SELECT C.nome, Veiculo.*
FROM Cliente as C natural join Aluguel natural join Veiculo
where situacao <> 2;

// todas revisoes

SELECT V.idVeiculo, V.placa, dataRevisao, valorConserto, valorRevisao, efetivado, C.nome, F.nome
FROM (Veiculo as V natural join Revisao) left outer join Cliente as C on Revisao.idCLiente = C.idCLiente left outer join Funcionario as F on Revisao.idMecanico = F.cpfFuncionario;

//TROCA


SELECT  idVenda, idCompra, idVeiculoComprado, idVeiculoVendido, ValorCompra, valorVenda
FROM ( SELECT idCompra, dataCompraVenda, idVendedor, idCliente, idVeiculo AS idVeiculoComprado, valorCompraVenda AS ValorCompra
		FROM Troca  INNER JOIN CompraVenda ON idCompra = idCompraVenda) AS COMPRA

	INNER JOIN

	(  SELECT idVenda, dataCompraVenda, idVendedor, idCliente, idVeiculo AS idVeiculoVendido, valorCompraVenda AS valorVenda
		FROM Troca  INNER JOIN CompraVenda ON idVenda = idCompraVenda) AS VENDA

		ON COMPRA.idCliente=VENDA.idCliente AND COMPRA.dataCompraVenda = VENDA.dataCompraVenda AND COMPRA.idVendedor = VENDA.idVendedor  ;









// TESTAR UPDATES
// valores com $ significa que vc tem que digitar um dado valido para aquele campo

UPDATE Funcionario
SET nome = $(nome), telefone = $(tel), salarioFixo = $(salario)
WHERE cpfFuncionario = $(cpfFuncionario);

UPDATE Vendedor
SET porcentagemComissao = $(porcentagemComissao)
WHERE cpfFuncionario = $(cpfFuncionario);

UPDATE Mecanico
SET comissaoPorRevisao = $(comissaoPorRevisao)
WHERE cpfFuncionario = $(cpfFuncionario);

UPDATE Cliente
SET nome = $(nome), cep = $(dep), telefone = $(tel), numero = $(numero), complemento = $(complemento), numConta = $(numConta), numCartao = $(numCartao)
WHERE idCliente = $(idCliente);

UPDATE *
FROM CompraVenda
WHERE dataCompraVenda = $(data), idVendedor = $(idFuncionario), idCliente = $(idCliente), idVeiculo = $(idVeiculoPvenda);

UPDATE *
FROM Aluguel
WHERE idVeiculo = $(idVeiculoPaluguel), idCliente = (idCliente), idVendedor = $(idFuncionario), idRevisao = $(idRevisao), valorTotal = $(valorTotal), kmRodados = $(kmRodados), dataInicio = $(dataInicio), dataFim = $(dataFim), multaAtraso = $(multa), finalizado = $(binario);

UPDATE *
FROM Revisao
WHERE idVeiculo = $(idVeiculo), idCliente = $(idCliente), idRevisao = $(idRevisao), idMecanico = $(idFuncionario), efetivado = $(binario), valorConserto = $(valor), valorRevisao = $(valorRevisao), dataRevisao = $(data);
