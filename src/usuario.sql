create table usuario (
    id int generated always as identity primary key,
    nome varchar(100) not null,
    tipo varchar(10) not null check (tipo in ('aluno', 'professor')),
    limite_itens int not null
);