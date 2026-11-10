create table item (
    id int generated always as identity primary key,
    codigo int not null unique,
    titulo varchar(100) not null,
    tipo varchar(10) not null check (tipo in ('livro', 'revista')),
    autor varchar(100),
    edicao varchar(50),
    disponivel boolean not null default true
);