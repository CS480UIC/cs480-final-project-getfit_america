CREATE database getfitamerica;

use getfitamerica;

CREATE TABLE manager ( 
            id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT UNIQUE,
            department_id SMALLINT UNSIGNED NOT NULL UNIQUE,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            created_at datetime,
            PRIMARY KEY (ID) 
            
            );

CREATE TABLE department ( 
            dept_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT UNIQUE,
            manager_id SMALLINT UNSIGNED NOT NULL UNIQUE,
            department_name varchar(24) DEFAULT NULL,
            PRIMARY KEY (dept_id),
            FOREIGN KEY(dept_id) REFERENCES manager(department_id)
				ON DELETE CASCADE
                ON UPDATE CASCADE
            );

            
CREATE TABLE trainer ( 
            employee_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT UNIQUE,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            PRIMARY KEY (employee_id)
            );
            

            

            
CREATE TABLE client ( 
            client_id SMALLINT UNSIGNED NOT NULL AUTO_INCREMENT UNIQUE,
            trainer_id SMALLINT UNSIGNED NOT NULL,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            age SMALLINT UNSIGNED NOT NULL,
            weight DOUBLE UNSIGNED NOT NULL, 
            body_fat DOUBLE UNSIGNED NOT NULL,
            PRIMARY KEY (client_id),
            FOREIGN KEY (trainer_id) REFERENCES trainer(employee_id)
				ON DELETE CASCADE
                ON UPDATE CASCADE
            );
            
		
            
CREATE TABLE receptionist ( 
            employee_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT UNIQUE,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            PRIMARY KEY (employee_id)
           
            );
            


 CREATE TABLE program ( 
            enrollment_number SMALLINT UNSIGNED NOT NULL UNIQUE,
            program_id SMALLINT UNSIGNED NOT NULL ,
            program_name varchar(24) DEFAULT NULL,
            description varchar(100) DEFAULT NULL,
            PRIMARY KEY (enrollment_number),
            FOREIGN KEY(program_id) REFERENCES department(dept_id)
				ON DELETE CASCADE
                ON UPDATE CASCADE
            
            );
            
CREATE TABLE appointment ( 
            selected_prog SMALLINT UNSIGNED,
            appointment_date DATE NOT NULL,
            location varchar(50) NOT NULL,
            program_app_num SMALLINT UNSIGNED NOT NULL,
            PRIMARY KEY (selected_prog),
            FOREIGN KEY (program_app_num) REFERENCES program(enrollment_number)
				ON DELETE CASCADE
                ON UPDATE CASCADE
            );

CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO manager(id,department_id,first_name,last_name) values (2001,1001,'Sam','White');
INSERT INTO department(dept_id,manager_id,department_name) values(1001,2001,'nutrition');
INSERT INTO trainer(employee_id,first_name,last_name) values (123,'Melville','Misayah');
INSERT INTO client(client_id,trainer_id,first_name,last_name,age,weight,body_fat) values (36029,123,'Sarah','White',38,150,30.2);
INSERT INTO receptionist(employee_id,first_name,last_name) values(4537,'Lyndon','Weaver');
INSERT INTO program(enrollment_number,program_id,program_name, description) values(5400,1001,'keto diet','keto diet lessons and discipline');
INSERT INTO appointment(selected_prog, appointment_date, location, program_app_num) values (1001,'2021-11-15','Chicago,IL', 5400);


INSERT INTO manager(id,department_id,first_name,last_name) values(2002,1002,'Anne','Lee');
INSERT INTO department(dept_id,manager_id,department_name) values(1002,2002,'massage');
INSERT INTO trainer(employee_id,first_name,last_name) values(124,'Melissa','Man');
INSERT INTO client(client_id,trainer_id,first_name,last_name,age,weight,body_fat) values(8936,124,'Lee','Chang',19,100,13.7);
INSERT INTO receptionist(employee_id,first_name,last_name) values(2836,'Neil','Bannister');
INSERT INTO program(enrollment_number,program_id,program_name, description) values(5402,1002,'foot massage','1 hour foot massage');
INSERT INTO appointment(selected_prog, appointment_date, location, program_app_num) values(1002,'2021-11-16','Chicago,IL', 5402);



INSERT INTO manager(id,department_id,first_name,last_name) values(2003,1003,'Rick','Roll');
INSERT INTO department(dept_id,manager_id,department_name) values(1003,2003,'cardio');
INSERT INTO trainer(employee_id,first_name,last_name) values(125,'Leeroy','Jenkins');
INSERT INTO client(client_id,trainer_id,first_name,last_name,age,weight,body_fat) values(3413,125,'Clayton','Young',368,150,58.2);
INSERT INTO receptionist(employee_id,first_name,last_name) values(2589,'Cadence','Blackburn');
INSERT INTO program(enrollment_number,program_id,program_name, description) values(5403,1003,'road cycling','monthly group road cycling');
INSERT INTO appointment(selected_prog, appointment_date, location, program_app_num) values(1003,'2021-11-17','Skokie,IL', 5403);

INSERT INTO manager(id,department_id,first_name,last_name) values(2004,1004,'Richard','Daley');
INSERT INTO department(dept_id,manager_id,department_name) values(1004,2004,'strength');
INSERT INTO trainer(employee_id,first_name,last_name) values(127,'Jimmy','Boy');
INSERT INTO client(client_id,trainer_id,first_name,last_name,age,weight,body_fat) values(6204,127,'Myra','Willis',25,127,18.1);
INSERT INTO receptionist(employee_id,first_name,last_name) values(8754,'Lacie','Johnsun');
INSERT INTO program(enrollment_number,program_id,program_name, description) values(5404,1004,'calisthenics','strength training for a variety of muscles');
INSERT INTO appointment(selected_prog, appointment_date, location, program_app_num) values(1004,'2021-11-18','Chicago,IL', 5404);

INSERT INTO manager(id,department_id,first_name,last_name) values(2005,1005,'Mitch','Hell');
INSERT INTO department(dept_id,manager_id,department_name) values(1005,2005,'dance');
INSERT INTO trainer(employee_id,first_name,last_name) values(512,'Elissa','Chen');
INSERT INTO client(client_id,trainer_id,first_name,last_name,age,weight,body_fat) values(4230,512,'Jason','Vorhees',35,274,20.2);
INSERT INTO receptionist(employee_id,first_name,last_name) values(9514,'Giulia','Bostock');
INSERT INTO program(enrollment_number,program_id,program_name, description) values(5405,1005,'zumba fitness','effective workout system through dancing');
INSERT INTO appointment(selected_prog, appointment_date, location, program_app_num) values(1005,'2021-11-19','Skokie,IL', 5405);

