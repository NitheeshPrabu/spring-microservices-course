INSERT INTO user (id, name, birth_date) VALUES (1001, 'Test1', sysdate());
INSERT INTO user (id, name, birth_date) VALUES (1002, 'Test2', sysdate());
INSERT INTO user (id, name, birth_date) VALUES (1003, 'Test3', sysdate());

INSERT INTO post (id, description, user_id) VALUES (2001, 'Test Post 1', 1001);
INSERT INTO post (id, description, user_id) VALUES (2002, 'Test Post 2', 1001);
INSERT INTO post (id, description, user_id) VALUES (2003, 'Test Post 3', 1002);