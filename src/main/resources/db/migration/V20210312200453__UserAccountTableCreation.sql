CREATE TABLE IF NOT EXISTS user_account
(
    id         serial primary key,
    first_name varchar(50)           NOT NULL,
    last_name  varchar(50)           NOT NULL,
    tax_number decimal(15, 2) unique NOT NULL,
    birthday   date                  NOT NULL,
    username   varchar(50) unique    NOT NULL,
    password   varchar(100)          NOT NULL,
    email      varchar(50) unique    NOT NULL,
    balance    int default 0         NOT NULL
);

drop table user_account cascade;