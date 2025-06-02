INSERT INTO CATEGORIA (id, nome) VALUES (1, 'Proteina'), (2, 'Vitaminas'), (3, 'Minerais'), (4, 'Aminoacidos'), (5, 'Energeticos');
INSERT INTO MARCA (id, nome) VALUES (1, 'MaxTitanium'), (2, 'Growth'), (3, 'IntegralMedica'), (4, 'Probiótica'), (5, 'BlackSkull');
INSERT INTO INGREDIENTE (id, nome, quantidade) VALUES (1, 'Creatina', '5g'), (2, 'Cafeina', '200mg'), (3, 'Whey Protein', '30g'), (4, 'BCAA', '10g'), (5, 'Glutamina', '5g');
INSERT INTO SUPLEMENTO (id, nome, descricao, preco_de_custo, categoria_id, marca_id) VALUES (1, 'Super Whey', 'Suplemento de proteina', 120.0, 1, 1), (2, 'Energy Boost', 'Suplemento energetico', 90.0, 5, 2), (3, 'Power Creatina', 'Creatina monohidratada', 70.0, 4, 3), (4, 'BCAA Plus', 'BCAA com glutamina', 85.0, 4, 4), (5, 'MultiVit', 'Complexo de vitaminas', 65.0, 2, 5);
INSERT INTO SUPLEMENTO_INGREDIENTES (suplemento_id, ingredientes_id) VALUES (1, 3), (2, 2), (3, 1), (4, 4), (4, 5), (5, 2);
ALTER TABLE CATEGORIA ALTER COLUMN id RESTART WITH 6;
ALTER TABLE MARCA ALTER COLUMN id RESTART WITH 6;
ALTER TABLE INGREDIENTE ALTER COLUMN id RESTART WITH 6;
ALTER TABLE SUPLEMENTO ALTER COLUMN id RESTART WITH 6;