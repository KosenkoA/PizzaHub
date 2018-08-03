INSERT INTO ph.role (name) VALUES ('administrator');
INSERT INTO ph.role (name) VALUES ('user');

INSERT INTO ph.status (name) VALUES ('preparing');
INSERT INTO ph.status (name) VALUES ('cooking');
INSERT INTO ph.status (name) VALUES ('delivery');

INSERT INTO ph.user (email, password, name, role_id) VALUES ('kosenkoandrew1@gmail.com', '123456', 'admin', '1');
INSERT INTO ph.user (email, password, name, role_id) VALUES ('somerandomemail@gmail.com', '123456', 'simple_user', '2');

INSERT INTO ph.userrole (user_id, role_id) VALUES (1, 1);
INSERT INTO ph.userrole (user_id, role_id) VALUES (2, 2);

INSERT INTO ph.product (name, description, weight, calories, preparingtime, price, availability, picture)
VALUES ('Cheese Product', 'Classic cheese product', 123, 123, 123, 123, TRUE, '/images/cheese-product.jpg');
INSERT INTO ph.product (name, description, weight, calories, preparingtime, price, availability, picture) VALUES
  ('New York Special Product', 'Pepperoni, sausage, meatballs, green peppers, mushrooms, red onions.', 123, 123, 123,
   123,
   TRUE, '/images/cheese-product.jpg');
INSERT INTO ph.product (name, description, weight, calories, preparingtime, price, availability, picture) VALUES
  ('New York Special Product 2',
   'Pepperoni, sausage, meatballs, green peppers, mushrooms, red onions and some other stuff.', 123, 123, 123, 123,
   TRUE, '/images/cheese-product.jpg');
