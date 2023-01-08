DROP TABLE IF EXISTS persons;
CREATE TABLE contracts (
                        id          SERIAL PRIMARY KEY,
                        code        VARCHAR(30),
                        date_sign   DATE,
                        additional_Properties    JSON
);

INSERT INTO contracts VALUES (1, 'TDjZ-2019-HZ-1015', '2019-09-11', '{
  "a": "1",
  "b": 2
}');