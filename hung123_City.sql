create table City
(
    id          bigint auto_increment
        primary key,
    area        double       not null,
    description varchar(255) null,
    gdp         double       not null,
    name        varchar(15)  null,
    population  double       not null,
    countryId   bigint       null
)
    engine = MyISAM;

create index FKf30cqcsw5iq7u31gk7ckpj2vf
    on City (countryId);

INSERT INTO hung123.City (id, area, description, gdp, name, population, countryId) VALUES (1, 234230, 'n&#432;&#7899;c ý', 32, 'roma', 214214234, 1);