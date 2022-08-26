
DROP TABLE IF EXISTS ers_reimbursements;
DROP TABLE IF EXISTS ers_reimbursements_status;
DROP TABLE IF EXISTS ers_reimbursements_types;
DROP TABLE IF EXISTS ers_verification;
DROP TABLE IF EXISTS ers_users;
DROP TABLE IF EXISTS ers_user_roles;



/*Creating the tables and adding the constraints*/
CREATE TABLE ers_users(
	ers_user_id serial PRIMARY KEY,
	ers_user_role_id int NOT NULL,
	ers_username varchar(50) UNIQUE NOT NULL,
	ers_user_password varchar(50) NOT NULL,
	ers_user_first_name varchar(50) NOT NULL,
	ers_user_last_name varchar(50) NOT NULL,
	ers_user_email varchar(100) UNIQUE NOT NULL,
	ers_user_hire_date date NOT NULL
);

CREATE TABLE ers_user_roles(
	ers_role_id serial PRIMARY KEY,
	ers_role_name varchar(50) NOT NULL 
);

/*ers_user_role_id is the foreign key within ers_users table*/
ALTER TABLE ers_users
ADD CONSTRAINT fk_constraint_usersToUserRoles
FOREIGN KEY (ers_user_role_id)
REFERENCES ers_user_roles (ers_role_id);

CREATE TABLE ers_verification(
	ers_ver_id int PRIMARY KEY,
	ers_ver_password varchar(50) NOT NULL,
	ers_ver_hash varchar(255) UNIQUE NOT NULL
);

ALTER TABLE ers_verification
ADD CONSTRAINT fk_constraint_verificationToUsers
FOREIGN KEY (ers_ver_id)
REFERENCES ers_users (ers_user_id);


CREATE TABLE ers_reimbursements(
	reimb_id serial NOT NULL,
	reimb_amount decimal(10, 2),
	reimb_submitted timestamp,
	reimb_resolved timestamp,
	reimb_description varchar(250),
	reimb_receipt bytea,
	reimb_author_id int,
	reimb_resolver_id int,
	reimb_status_id int,
	reimb_type_id int
	

);


CREATE TABLE ers_reimbursements_status(
	status_id serial PRIMARY KEY,
	status_name varchar(10)
);

CREATE TABLE ers_reimbursements_types(
	type_id serial PRIMARY KEY,
	type_name varchar(10)
);

/*status_id is a foreign key within ers_reimbursements table*/
ALTER TABLE ers_reimbursements
ADD CONSTRAINT fk_constraint_ersReimbToReimbStatus
FOREIGN KEY (reimb_status_id)
REFERENCES ers_reimbursements_status (status_id);

/*type_id is a foreign key within ers_reimbursements table*/
ALTER TABLE ers_reimbursements
ADD CONSTRAINT fk_constraint_ersReimbToReimbType
FOREIGN KEY (reimb_type_id)
REFERENCES ers_reimbursements_types (type_id);

/*author id is referring user table's user id */
ALTER TABLE ers_reimbursements
ADD CONSTRAINT fk_constraint_authorToErsUsers
FOREIGN KEY (reimb_author_id)
REFERENCES ers_users (ers_user_id);

/*resolver id is referring user table's user id */
ALTER TABLE ers_reimbursements
ADD CONSTRAINT fk_constraint_resolverToErsUsers
FOREIGN KEY (reimb_resolver_id)
REFERENCES ers_users (ers_user_id);

/*ers_user_roles table data*/
INSERT INTO ers_user_roles (ers_role_name) VALUES ('EMPLOYEE');
INSERT INTO ers_user_roles (ers_role_name) VALUES ('FINANCE MANAGER');

/*ers_users table data*/
INSERT INTO ers_users (ers_user_role_id, ers_username, ers_user_password, ers_user_first_name, ers_user_last_name, ers_user_email, ers_user_hire_date)
VALUES (1, 'admingod','password', 'Richard', 'le', 'richard.le@gmail.com', '2017-07-15');
INSERT INTO ers_users (ers_user_role_id, ers_username, ers_user_password, ers_user_first_name, ers_user_last_name, ers_user_email, ers_user_hire_date)
VALUES (1, 'usernamehello','password', 'Billy', 'Jean', 'jean.billy@outlook.com', '2018-10-03');
INSERT INTO ers_users (ers_user_role_id, ers_username, ers_user_password, ers_user_first_name, ers_user_last_name, ers_user_email, ers_user_hire_date)
VALUES (1, 'therealryan', 'impossiblerap', 'Ryan', 'Hyga', 'ryan.hygga@gmail.com', '2020-03-06');


/*ers ver table data*/
INSERT INTO ers_verification VALUES (1, 'password', '$9a$02$OORJzV8VsUP.EMBoSAvazOv
dfsuenruiehsniuhuirnb4ub3ib23');
INSERT INTO ers_verification VALUES (2, 'password', '$9a$02$UUEnjasnskH.UJNIUebnbds.dsakji43jkh4bq3kjhbbq4n5nkjn3');
INSERT INTO ers_verification VALUES (3, 'password', '$9a$02$JHKBNkjlwaj.HBYUgo3yy3h.jndfinsa43ubibn20niujbzandsiu');

/*ers_reimbursements_types table data*/
INSERT INTO ers_reimbursements_types(type_name) VALUES ('OTHER');
INSERT INTO ers_reimbursements_types(type_name) VALUES ('FOOD');
INSERT INTO ers_reimbursements_types(type_name) VALUES ('TRAVEL');
INSERT INTO ers_reimbursements_types(type_name) VALUES ('LODING');

/*ers_reimbursements_status table data*/
INSERT INTO ers_reimbursements_status(status_name) VALUES ('APPROVED');
INSERT INTO ers_reimbursements_status(status_name) VALUES ('PENDING');
INSERT INTO ers_reimbursements_status(status_name) VALUES ('DENIED');

/*ers_reimbursements table data*/
INSERT INTO ers_reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id) 
VALUES (420.69, '2019-04-19 04:20:04','2029-06-25 09:30:21', 'for the weed party', 'blazeitreceipt.jpg', 1, 3, 2, 2);
INSERT INTO ers_reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id)
VALUES (250.40, '2020-05-26 09:23:01','2020-09-09 08:30:21', 'for event party reservation', 'hotelreceipt.jpg', 2, 1, 2, 1);
INSERT INTO ers_reimbursements(reimb_amount, reimb_submitted, reimb_resolved, reimb_description, reimb_receipt, reimb_author_id, reimb_resolver_id, reimb_status_id, reimb_type_id)
VALUES (300.24, '2021-01-01 03:30:33', '2021-09-10 03:30:48', 'for crazy office party', 'receipt.jpg', 1, 3, 2, 3);

/*jdbc statements*/
select * from ers_users;
select * from ers_users where user_id = 1; 
select * from ers_users where username = 'admingod';

SELECT * FROM ers_users ORDER BY ers_user_id;
SELECT * FROM ers_user_roles ORDER BY ers_role_id;
SELECT * FROM ers_reimbursements ORDER BY reimb_id;
SELECT * FROM ers_reimbursements_status ORDER BY status_id;
SELECT * FROM ers_reimbursements_types ORDER BY type_id;


