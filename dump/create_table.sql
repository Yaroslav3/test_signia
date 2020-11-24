create table authorization
(
    id       bigint       not null
        primary key,
    email    varchar(255) null,
    password varchar(255) null
)
    engine = MyISAM;




create table opt
(
    id               bigint       not null
        primary key,
    code             varchar(255) null,
    date_create_opt  datetime     null,
    id_authorization bigint       null,
    session_id       varchar(255) null
)
    engine = MyISAM;

create index FKe2ysr7wqjt61vlrk5ykjqukkl
    on opt (id_authorization);




