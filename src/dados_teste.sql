insert into item (codigo, titulo, tipo, autor, edicao, disponivel) values
    (1, 'Dom Casmurro', 'livro', 'Machado de Assis', null, true),
    (2, 'Memórias Póstumas de Brás Cubas', 'livro', 'Machado de Assis', null, true),
    (3, 'Superinteressante', 'revista', null, 'Edição 450', false),
    (4, 'Veja', 'revista', null, 'Edição 2900', true);

insert into usuario (nome, tipo, limite_itens) values
    ('Gustavo', 'aluno', 3),
    ('Professor Jacques', 'professor', 5);

insert into emprestimo (item_id, usuario_id, data_retirada, data_devolucao_prevista, data_devolucao, valor_multa) values
    (1, 1, '2026-10-01', '2026-10-15', '2026-10-21', 3.00),
    (3, 2, '2026-11-02', '2026-11-09', null, 0);