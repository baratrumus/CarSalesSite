DROP TABLE IF EXISTS models CASCADE;
DROP TABLE IF EXISTS brands CASCADE;
DROP TABLE  IF EXISTS engines CASCADE;
DROP TABLE  IF EXISTS bodytype CASCADE;

DROP TABLE  IF EXISTS car CASCADE;
DROP TABLE  IF EXISTS roles CASCADE;
DROP TABLE  IF EXISTS users CASCADE;
DROP TABLE  IF EXISTS ads CASCADE;


CREATE TABLE brands
(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE models
(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    brand_id INT NOT NULL references brands(id)
);

-- ALTER TABLE models ADD CONSTRAINT fk_brands FOREIGN KEY(brand_id) REFERENCES brands(id);

CREATE TABLE engines
(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE bodytype
(
    id serial PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

CREATE TABLE car
(
    id serial PRIMARY KEY,
    brand_id INT NOT NULL references brands(id),
    model_id INT NOT NULL references models(id),
    body_id INT NOT NULL references bodytype(id),
    engine_id INT NOT NULL references engines(id),
    car_year    VARCHAR(255),
    mileage    INT,
    color    VARCHAR(255)
);


CREATE TABLE roles
(
    id serial PRIMARY KEY,
    role_name VARCHAR(255)  NOT NULL
);


CREATE TABLE carusers
(
    id serial PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(255) NOT NULL,
    role_id INT NOT NULL references roles(id)
);


CREATE TABLE ads
(
    id serial PRIMARY KEY,
    descr     VARCHAR(1000)           NOT NULL,
    created   TIMESTAMP DEFAULT now() NOT NULL,
    fileimage bytea,
    price     INT    NOT NULL,
    sold      BOOLEAN   DEFAULT false  NOT NULL,
    car_id    INT    REFERENCES car (id) ON DELETE SET NULL,
    user_id   INT    NOT NULL REFERENCES carusers (id) ON DELETE CASCADE
);


