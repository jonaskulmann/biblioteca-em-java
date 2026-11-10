create table emprestimo (
    id int generated always as identity primary key,
    item_id int not null references item(id),
    usuario_id int not null references usuario(id),
    data_retirada date not null,
    data_devolucao_prevista date not null,
    data_devolucao date,
    valor_multa numeric(8, 2) not null default 0
);