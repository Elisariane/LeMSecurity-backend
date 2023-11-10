create table colaboradores(

    id bigint not null auto_increment,
    matricula int not null unique,
    nome varchar(100) not null,
    data_admissao date not null,

    primary key(id)

);