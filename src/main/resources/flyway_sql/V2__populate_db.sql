
INSERT INTO worker (name, birthday, level, salary) VALUES ('Art', '2000-01-01', 'Junior', 101);
INSERT INTO worker (name, birthday, level, salary) VALUES ('John', '1999-01-01', 'Junior', 999);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Tom', '1997-01-01', 'Junior', 888);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Tom', '1998-12-01', 'Junior', 950);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Jojo', '1995-12-01', 'Senior', 53000);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Alice', '2003-11-10', 'Trainee', 300);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Lola', '2000-05-09', 'Middle', 8000);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Lisa', '1997-07-27', 'Middle', 9000);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Betty', '1995-10-05', 'Senior', 99999);
INSERT INTO worker (name, birthday, level, salary) VALUES ('Mila', '2005-05-05', 'Trainee', 800);



INSERT INTO client (name) VALUES ('Emily');
INSERT INTO client (name) VALUES ('Miranda');
INSERT INTO client (name) VALUES ('Julia');
INSERT INTO client (name) VALUES ('Olga');
INSERT INTO client (name) VALUES ('Mike');
INSERT INTO client (name) VALUES ('Tomas');





INSERT INTO project (client_id, start_date, finish_date) VALUES (1, '2003-01-01', '2010-10-10');
INSERT INTO project (client_id, start_date, finish_date) VALUES (1, '2003-01-01', '2010-10-10');
INSERT INTO project (client_id, start_date, finish_date) VALUES (2, '2003-03-01', '2004-10-10');
INSERT INTO project (client_id, start_date, finish_date) VALUES (2, '2005-05-01', '2007-09-09');
INSERT INTO project (client_id, start_date, finish_date) VALUES (3, '2004-02-01', '2011-01-15');
INSERT INTO project (client_id, start_date, finish_date) VALUES (3, '2008-10-03', '2009-11-11');
INSERT INTO project (client_id, start_date, finish_date) VALUES (4, '2009-03-05', '2010-12-13');
INSERT INTO project (client_id, start_date, finish_date) VALUES (4, '2010-12-19', '2011-09-15');
INSERT INTO project (client_id, start_date, finish_date) VALUES (1, '2011-01-07', '2017-06-01');
INSERT INTO project (client_id, start_date, finish_date) VALUES (5, '2012-03-10', '2015-07-12');
INSERT INTO project (client_id, start_date, finish_date) VALUES (5, '2013-06-15', '2018-03-18');
INSERT INTO project (client_id, start_date, finish_date) VALUES (6, '2018-04-17', '2022-09-23');
INSERT INTO project (client_id, start_date, finish_date) VALUES (4, '2019-11-07', '2023-02-21');



INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(1,2), 
(1,3),
(1,4),
(1,9);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(2,3), 
(2,4);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(3,6), 
(3,5);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(4,6), 
(4,7), 
(4,8), 
(4,10);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(5,2), 
(5,3),
(5,1);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(6,5), 
(6,6);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(7,4), 
(7,9);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(8,1), 
(8,2), 
(8,3), 
(8,5), 
(8,6);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(9,8), 
(9,7), 
(9,9), 
(9,10);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(10,4), 
(10,5), 
(10,9);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(11,1), 
(11,2), 
(11,3), 
(11,6);
INSERT INTO PROJECT_WORKER  (PROJECT_ID , WORKER_ID) VALUES 
(12,1), 
(12,4), 
(12,5), 
(12,10), 
(12,9);
