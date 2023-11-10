alter table locais add ativo tinyint;
update locais set ativo = 1;
