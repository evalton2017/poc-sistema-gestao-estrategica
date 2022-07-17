
INSERT INTO situacaoentrega_legado(id_situacao_entrega, desc_situacao_entrega) VALUES( 1, 'RECEPCIONADO')
INSERT INTO situacaoentrega_legado(id_situacao_entrega, desc_situacao_entrega) VALUES( 2, 'A CAMINHO')
INSERT INTO situacaoentrega_legado(id_situacao_entrega, desc_situacao_entrega) VALUES( 3, 'SAIU PARA ENTREGA')
INSERT INTO situacaoentrega_legado(id_situacao_entrega, desc_situacao_entrega) VALUES( 4, 'ENTREGUE')
INSERT INTO situacaoentrega_legado(id_situacao_entrega, desc_situacao_entrega) VALUES( 5, 'DEVOLVIDO')

INSERT INTO TRANSPORTADORA_LEGADO(id_transportadora, nome_transportadora,cnpj) VALUES(1,'Rapido Transportadora', '46681614000187')
INSERT INTO TRANSPORTADORA_LEGADO(id_transportadora, nome_transportadora,cnpj) VALUES(2,'Transportadora Velox', '36534440000176')
INSERT INTO TRANSPORTADORA_LEGADO(id_transportadora, nome_transportadora,cnpj) VALUES(3,'Transportadora Ligeirinho', '73562987000101')
INSERT INTO TRANSPORTADORA_LEGADO(id_transportadora, nome_transportadora,cnpj) VALUES(4,'Transportadora Nacional', '47272037000132')

INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(1,'15409435001','Loja das Ferramentas')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(2,'39654852020','Duke Gomes de Sousa')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(3,'99959935035','Infor tech')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(4,'79260113000186','Varejão da economia')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(5,'85192263000100','Casas Bahia')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(6,'16290478000133','Ponto Frio')
INSERT INTO CLIENTE_LEGADO(id_cliente_legado, cpf_cnpj, nome_cliente) VALUES(7,'67606572000190','Riachuelo')

INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(1, 'Notebook', 30)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(2, 'Mesa', 35)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(3, 'Furadeira', 60)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(4, 'Geladeira', 20)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(5, 'Celular', 80)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(6, 'Kit Ferramentas', 30)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(7, 'Camisa Polo', 130)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(8, 'Tenis Masculino', 240)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(9, 'Monitor', 80)
INSERT INTO PRODUTO_LEGADO(id_produto, nome,quantidade) VALUES(10, 'TV LED', 30)

INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(1,'2022-07-03',29,1,3, 222333)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(2,'2022-07-02',50,2,1, 333222)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(3,'2022-07-01',55,1,5, 444555)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(4,'2022-07-02',60,3,5, 555444)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(5,'2022-07-04',75,2,2, 666555)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(6,'2022-07-07',1150,4,6, 555666)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(7,'2022-07-07',250,4,4, 777666)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(8,'2022-07-01',350,4,6, 666777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(9,'2022-07-08',390,3,6, 888777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(10,'2022-07-03',500,2,5, 999777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(11,'2022-07-07',480,1,4, 100777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(12,'2022-07-09',380,4,3, 111777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(13,'2022-07-09',380,7,7, 211777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(14,'2022-07-10',380,7,8, 311777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(15,'2022-07-06',380,5,9, 411777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(16,'2022-07-08',380,6,10, 511777)
INSERT INTO PEDIDO_LEGADO(id_pedido,data_pedido, valor_pedido,id_cliente_legado, id_produto, numero_pedido) VALUES(17,'2022-07-10',380,5,1, 611777)

INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(1,1,4,1,null, '2022-07-15',CURRENT_TIMESTAMP,'2022-07-01','222333', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(2,3,2,1,null, null,'2022-07-14','2022-07-03','111222', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(3,4,5,1,null, CURRENT_TIMESTAMP,'2022-07-05','2022-07-02','444555', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(4,2,2,2,null, null,'2022-07-03','2022-07-08','555444', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(5,5,4,2,null, CURRENT_TIMESTAMP,'2022-07-07','2022-07-05','666777', 'Distrito Federal', 'Brasilia')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(6,7,4,3,null, '2022-07-10','2022-07-04','2022-07-06','777666', 'Sao Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(7,6,5,3,CURRENT_TIMESTAMP, null,'2022-07-09','2022-07-07','888777', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(8,8,5,2,CURRENT_TIMESTAMP, null,'2022-07-07','2022-07-10','777888', 'Distrito Federal', 'Brasilia')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(9,9,5,2,CURRENT_TIMESTAMP, null,'2022-07-06','2022-07-03','999888', 'Rio de Janeiro', 'Macae')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(10,10,2,3,null, CURRENT_TIMESTAMP,'2022-07-08','2022-07-28','1000888', 'Rio de Janeiro', 'Rio de Janeiro')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(11,11,5,3,CURRENT_TIMESTAMP, null,'2022-07-09','2022-07-26','2222888', 'Rio de Janeiro', 'Rio de Janeiro')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(12,12,2,1,null, null,'2022-07-05','2022-07-07','3333888', 'Rio de Janeiro', 'Barra')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(13,17,2,4,null, null,'2022-07-17','2022-07-10','3333888', 'São Paulo', 'São Paulo')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(14,16,4,4,null, CURRENT_TIMESTAMP,'2022-07-12','2022-07-07','3333888', 'São Paulo', 'Guarulhos')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(15,15,5,4,CURRENT_TIMESTAMP, null,'2022-07-10','2022-07-19','3333888', 'Rio de Janeiro', 'Barra')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(16,14,2,2,null, null,'2022-07-17','2022-07-07','3333888', 'Rio de Janeiro', 'Barra')
INSERT INTO ENTREGA_LEGADO(id_entrega, id_pedido, id_situacao_entrega, id_transportadora, data_devolucao, data_entrega_efetiva, data_saida, data_entrega_prevista, numero_rastreio, estado, cidade) VALUES(17,13,4,1,null, CURRENT_TIMESTAMP,'2022-07-07','2022-07-19','3333888', 'Distrito Federal', 'Asa Sul')