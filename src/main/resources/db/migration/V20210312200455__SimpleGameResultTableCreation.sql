CREATE TABLE IF NOT EXISTS simple_game_result
(
    id          serial primary key,
    result      varchar(10) NOT NULL,
    date_time   timestamp   NOT NULL
);

--drop table simple_bet;