INSERT INTO ph.role (name) VALUES ('administrator');
INSERT INTO ph.role (name) VALUES ('user');

INSERT INTO ph.status (name) VALUES ('preparing');
INSERT INTO ph.status (name) VALUES ('cooking');
INSERT INTO ph.status (name) VALUES ('delivery');

INSERT INTO ph.user (email, password, name, role_id) VALUES ('kosenkoandrew1@gmail.com', '123456', 'admin', '1');
INSERT INTO ph.user (email, password, name, role_id) VALUES ('somerandomemail@gmail.com', '123456', 'simple_user', '2');

INSERT INTO ph.userrole (user_id, role_id) VALUES (1, 1);
INSERT INTO ph.userrole (user_id, role_id) VALUES (2, 2);

INSERT INTO ph.pizza (name, description, weight, calories, preparingtime, price, availability)
VALUES ('Cheese Pizza', 'Classic cheese pizza', 123, 123, 123, 123, TRUE);
INSERT INTO ph.pizza (name, description, weight, calories, preparingtime, price, availability) VALUES
  ('New York Special Pizza', 'Pepperoni, sausage, meatballs, green peppers, mushrooms, red onions.', 123, 123, 123, 123,
   TRUE);
