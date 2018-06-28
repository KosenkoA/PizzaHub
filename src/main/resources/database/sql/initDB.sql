DROP SCHEMA IF EXISTS ph CASCADE;
CREATE SCHEMA ph;

DROP SEQUENCE IF EXISTS role_sequence CASCADE;
CREATE SEQUENCE role_sequence;
CREATE TABLE ph.role (
  id   BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('role_sequence'),
  name VARCHAR(50)
);

DROP SEQUENCE IF EXISTS status_sequence CASCADE;
CREATE SEQUENCE status_sequence;
CREATE TABLE ph.status (
  id   BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('status_sequence'),
  name VARCHAR(50)
);

DROP SEQUENCE IF EXISTS user_sequence CASCADE;
CREATE SEQUENCE user_sequence;
CREATE TABLE ph.user
(
  id       BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('user_sequence'),
  email    VARCHAR(50),
  password VARCHAR(100),
  name     VARCHAR(50),
  role_id  BIGINT,
  CONSTRAINT role_id FOREIGN KEY (role_id)
  REFERENCES ph.role (id)
);

DROP SEQUENCE IF EXISTS order_sequence CASCADE;
CREATE SEQUENCE order_sequence;
CREATE TABLE ph.order
(
  id      BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('order_sequence'),
  time    TIMESTAMP WITHOUT TIME ZONE,
  closed  BOOLEAN,
  user_id BIGINT,
  CONSTRAINT "user_id" FOREIGN KEY ("user_id")
  REFERENCES ph.user (id)
);

DROP SEQUENCE IF EXISTS product_sequence CASCADE;
CREATE SEQUENCE product_sequence;
CREATE TABLE ph.product
(
  id            BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('product_sequence'),
  name          VARCHAR(500),
  description   VARCHAR(10000),
  weight        INT,
  calories      INT,
  preparingtime VARCHAR(50),
  price         INT,
  availability  BOOLEAN,
  picture varchar(1000)
);

DROP SEQUENCE IF EXISTS orderproduct_sequence CASCADE;
CREATE SEQUENCE orderproduct_sequence;
CREATE TABLE ph.orderproduct
(
  id         BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('orderproduct_sequence'),
  product_id BIGINT,
  status_id BIGINT,
  order_id  BIGINT,
  CONSTRAINT "product_id" FOREIGN KEY ("product_id")
  REFERENCES ph.product (id),
  CONSTRAINT "status_id" FOREIGN KEY ("status_id")
  REFERENCES ph.status (id),
  CONSTRAINT "order_id" FOREIGN KEY ("order_id")
  REFERENCES ph.order (id)
);