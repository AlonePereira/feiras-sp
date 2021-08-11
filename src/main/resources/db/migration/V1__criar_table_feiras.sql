create table feiras
(
    id         bigint not null primary key,
    areap      varchar(255) not null,
    bairro     varchar(255) not null,
    coddist    int          not null,
    codsubpref int          not null,
    distrito   varchar(255) not null,
    lat        double       not null,
    logradouro varchar(255) not null,
    lon        double       not null,
    nome_feira varchar(255) not null,
    numero     varchar(255) not null,
    referencia varchar(255) not null,
    regiao5    varchar(255) not null,
    regiao8    varchar(255) not null,
    registro   varchar(255) not null,
    setcens    varchar(255) not null,
    subprefe   varchar(255) not null
);