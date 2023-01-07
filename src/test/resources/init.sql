DROP TABLE IF EXISTS persons;
CREATE TABLE contracts (
                        id          SERIAL PRIMARY KEY,
                        code        VARCHAR(30),
                        date_sign   DATE
);

INSERT INTO contracts VALUES (1, 'TDjZ-2019-HZ-1015', '2019-09-11');