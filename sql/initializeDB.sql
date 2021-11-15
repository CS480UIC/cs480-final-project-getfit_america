CREATE database getfitamerica;

use getfitamerica;


CREATE TABLE department ( 
            dept_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT,
            manager_id SMALLINT UNSIGNED NOT NULL,
            department_name varchar(24) DEFAULT NULL,
            PRIMARY KEY (dept_id)            
            );
            
CREATE TABLE trainer ( 
            employee_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            PRIMARY KEY (employee_id)
            );
            
CREATE TABLE manager ( 
            ID SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT,
            department_id SMALLINT UNSIGNED NOT NULL,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            created_at datetime,
            PRIMARY KEY (ID),
            FOREIGN KEY(department_id) REFERENCES department(dept_id)
            );
            
CREATE TABLE client ( 
            client_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT,
            trainer_id SMALLINT UNSIGNED NOT NULL,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            age SMALLINT UNSIGNED NOT NULL,
            weight DOUBLE UNSIGNED NOT NULL, 
            body_fat DOUBLE UNSIGNED NOT NULL,
            PRIMARY KEY (client_id),
            FOREIGN KEY (trainer_id) REFERENCES trainer(employee_id)
            );
            
		
            
CREATE TABLE receptionist ( 
            employee_id SMALLINT UNSIGNED NOT NULL  AUTO_INCREMENT,
            first_name varchar(24) DEFAULT NULL,
            last_name varchar(24) DEFAULT NULL, 
            PRIMARY KEY (employee_id)
            );
            


 CREATE TABLE program ( 
            enrollment_number SMALLINT UNSIGNED NOT NULL,
            program_id SMALLINT UNSIGNED NOT NULL,
            program_name varchar(24) DEFAULT NULL,
            description varchar(100) DEFAULT NULL,
            PRIMARY KEY (enrollment_number),
            FOREIGN KEY(program_id) REFERENCES department(dept_id)
            
            );
            
CREATE TABLE appointment ( 
            selected_prog SMALLINT UNSIGNED,
            date DATE NOT NULL,
            location varchar(50) NOT NULL,
            program_app_num SMALLINT UNSIGNED NOT NULL,
            PRIMARY KEY (selected_prog),
            FOREIGN KEY (program_app_num) REFERENCES program(enrollment_number)

            );
            
            
insert  into `client`(`client_id`,`trainer_id`,`first_name`,`last_name`,`age`,`weight`,`body_fat`) values 
(`36029`,`123`,`Sarah`,`White`,`38`,`150`,`30.2`),
(`89365`,`124`,`Lee`,`Chang`,`19`,`100`,`13.7`),
(`34173`,`125`,`Clayton`,`Young`,`42`,`58.2`,``),
(`62304`,`512`,`Myra`,`Willis`,`25`,`127`,`18.1`),
(`42930`,`127`,`Jason`,`Vorhees`,`35`,`125`,`20.2`);

insert  into `receptionist`(`employee_id`,`first_name`,`last_name`) values
(`employee_id`,`first_name`,`last_name`),
(`employee_id`,`first_name`,`last_name`),
(`employee_id`,`first_name`,`last_name`),
(`employee_id`,`first_name`,`last_name`),
(`employee_id`,`first_name`,`last_name`);

INSERT INTO `program`(`enrollment_number`,`program_id`,`program_name`,`description`) values
(`5400`,`1001`,`keto diet`,`keto diet lessons and discipline`),
(`5401`,`1002`,`foot massage`,`1 hour foot massage`),
(`5402`,`1003`,`road cycling`,`monthly group road cycling`),
(`5403`,`1004`,`calisthenics`,`strength training for a variety of muscles`),
(`5404`,`1005`,`zumba fitness`,`effective workout system through dancing`);

INSERT INTO `manager`(`manager_id`,`department_id`,`first_name`,`last_name`) values
(`2001`,`1001`,`Sam`,`White`),
(`2002`,`1002`,`Anne`,`Lee`),
(`2003`,`1003`,`Rick`,`Roll`),
(`2004`,`1004`,`Richard`,`Daley`),
(`2005`,`1005`,`Mitch`,`Hell`);

INSERT INTO `trainer`(`employee_id`,`first_name`,`last_name`) values
(`123`,`Melville`,`Misayah`),
(`124`,`Melissa`,`Man`),
(`125`,`Leeroy`,`Jenkins`),
(`127`,`Jimmy`,`Boy`),
(`512`,`Elissa`,`Chen`);

INSERT INTO `department`(`dept_id`,`manager_id`,`department_name`) values
(`1001`,`2001`,`nutrition`),
(`1002`,`2002`,`massage`),
(`1003`,`2003`,`cardio`),
(`1004`,`2004`,`strength`),
(`1005`,`2005`,`dance`);

INSERT INTO `appointment`(`select_program`,`appointment_date`,`location`,`program_appointment_number`) values
(`keto diet`,`11/15/2021`,`Chicago,IL`,`1001`),
(`foot massage`,`11/15/2021`,`Chicago,IL`,`1002`),
(`road cycling`,`11/15/2021`,`Skokie,IL`,`1003`),
(`calisthenics`,`11/15/2021`,`Chicago,IL`,`1004`),
(`zumba fitness`,`11/15/2021`,`Skokie,IL`,`1005`);



