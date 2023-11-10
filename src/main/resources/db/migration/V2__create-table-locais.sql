create table locais(

    id bigint not null auto_increment primary key,
    cod int not null unique,
    nome varchar(100) not null,
    descricao varchar(150),
    responsavel_id bigint,
    CONSTRAINT fk_responsavel
    FOREIGN KEY (responsavel_id)
    REFERENCES colaboradores(id)
);