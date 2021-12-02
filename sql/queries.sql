-- Simple Query 1: Author Michael Misayah
SELECT body_fat, first_name, last_name
FROM client
WHERE body_fat < 21.0
ORDER BY body_fat DESC;

-- Simple Query 2: Author Melville Misayah
SELECT * from manager
WHERE id BETWEEN 2001 AND 2003;

-- Simple Query 3: Author Mitchell Misayah
select first_name,last_name, weight from client
WHERE weight < 180
ORDER BY weight DESC;

-- Aggregate Query 1 (uses a string function): Author Michael Misayah
SELECT CONCAT(UPPER(program_name), ': ', description)
FROM program;

-- Aggregate Query 2 (grouping rows with identical values in a set of summary rows and filter group results): Author Michael Misayah
SELECT location, COUNT(selected_prog)
FROM appointment
GROUP BY location
HAVING COUNT(selected_prog) > 1;

-- Aggregate Query 3 (Numeric query): Author Melville Misayah 
SELECT AVG(weight) from client
WHERE age > 18;

-- Aggregate Query 4 (uses date and time): Author Mitchell Misayah 
select DATE(`appointment_date`) = '2021-11-15'from appointment;

-- Complex Query 1 (correlated subquery without EXIST): The query identifies trainers that are training healthy male individuals within the age range of 20-39
SELECT first_name, last_name
FROM trainer
WHERE employee_id = ANY
	(SELECT trainer_id
	from client
	where body_fat >= 8.0 and body_fat <= 19.0 and age >= 20 and age <= 39);

-- Complex Query 2 (correlated subquery without EXIST): The query identifies trainers that are training unhealthy male individuals within the age range of 20-39
SELECT first_name, last_name
FROM trainer
WHERE employee_id = ANY
	(SELECT trainer_id
	from client
	where body_fat < 8.0 or body_fat > 19.0 and age >= 20 and age <= 39);

-- Complex Query 3 (Uses a join)
SELECT trainer.first_name as Trainer_name, client.first_name as Client_name
FROM trainer
INNER JOIN client
on trainer.employee_id = client.trainer_id;

-- Complex Query 4 (uses EXISTS)
SELECT first_name from trainer
WHERE EXISTS ( SELECT first_name from client WHERE client.trainer_id = trainer.employee_id and age = 19);