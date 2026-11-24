select codigo, titulo, tipo, disponivel
from item
order by codigo;

select u.nome, i.titulo
from emprestimo e
join usuario u on u.id = e.usuario_id
join item i on i.id = e.item_id
where e.data_devolucao is null;

select u.nome, sum(e.valor_multa) as total_multas
from usuario u
join emprestimo e on e.usuario_id = u.id
group by u.id, u.nome
order by u.nome;

select i.codigo, i.titulo
from item i
left join emprestimo e on e.item_id = i.id
where e.id is null;