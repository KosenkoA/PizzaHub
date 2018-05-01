DROP SEQUENCE IF EXISTS userrole_sequence CASCADE;
CREATE SEQUENCE userrole_sequence;
CREATE TABLE ph.userrole
(
  id      BIGINT NOT NULL PRIMARY KEY DEFAULT nextval('userrole_sequence'),
  user_id BIGINT NOT NULL,
  role_id BIGINT NOT NULL
  /*FOREIGN KEY (user_id) REFERENCES ph."user"(id) ON DELETE CASCADE ON UPDATE CASCADE,
  FOREIGN KEY (role_id) REFERENCES ph."role"(id) ON DELETE CASCADE ON UPDATE CASCADE*/
);

ALTER TABLE ph.userrole
  ADD CONSTRAINT user_id_const FOREIGN KEY (user_id) REFERENCES ph.user (id) MATCH FULL;
ALTER TABLE ph.userrole
  ADD CONSTRAINT role_id_const FOREIGN KEY (role_id) REFERENCES ph.role (id) MATCH FULL;