create table Country
(
    id   bigint auto_increment
        primary key,
    name varchar(255) null
)
    engine = MyISAM;

INSERT INTO hung123.Country (id, name) VALUES (1, 'italia');
INSERT INTO hung123.Country (id, name) VALUES (2, 'singapore');