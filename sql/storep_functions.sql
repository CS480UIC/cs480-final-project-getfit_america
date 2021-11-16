
 -- Procedure 1: Author Michael Misayah  
CREATE DEFINER=`root`@`localhost` PROCEDURE `TotalClientAverageBodyFat`(OUT avgBodyFat float)
SELECT AVG(body_fat) AS ClientAverageBodyFat
    INTO avgBodyFat
	FROM client

-- Procedure 2: Author Mitchell Misayah
CREATE DEFINER=`root`@`localhost` PROCEDURE `get_appointment_location`()
BEGIN
	
	SELECT * FROM appointment
    WHERE location = 'Chicago,IL';

END
 
-- Procedure 3: Author Melville Misayah
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientOver18`()
BEGIN
	SELECT COUNT(*) from client
    WHERE age > 18;
END


-- Function 1: Author Michael Misayah  
CREATE DEFINER=`root`@`localhost` FUNCTION `GetTotalClientsTrainedByTrainer`(trainerFirstName VARCHAR(24), trainerLastName VARCHAR(24)) RETURNS int
    READS SQL DATA
BEGIN
	DECLARE trainerEmployeeID SMALLINT UNSIGNED;
	DECLARE clientCount INT;
    
    SELECT employee_id
    INTO trainerEmployeeID
    FROM trainer
    WHERE first_name = trainerFirstName and last_name = trainerLastName;
    
	SELECT COUNT(trainerEmployeeID) into clientCount
    FROM client
    WHERE trainer_id = trainerEmployeeID;
    
    IF clientCount <= 0 THEN
		RETURN 0;
	ELSE
		RETURN clientCount;
	END IF;
END




-- Function 2: Author Mitchell Misayah
CREATE DEFINER=`root`@`localhost` FUNCTION `determine_health`(bf NUMERIC(10)) RETURNS char(20) CHARSET utf8mb4
    DETERMINISTIC
BEGIN
	declare message char(20);
    if bf > 30 then
		set message = " Super Unhealthy";
	elseif(bf >= 20 and bf < 30.9) then
		set message = " Unhealthy";
	elseif (bf < 20  and bf >= 10) then
		set message = "Good";
	elseif bf < 10 then
		set message = "Underweight";    
	else
		set message = "N/A";
	end if;
		return(message);        

RETURN 1;
END



-- Function 3: Author Melville Misayah
CREATE DEFINER=`root`@`localhost` FUNCTION `maxBPM`(client_first_name VARCHAR(20),client_last_name VARCHAR(20)) RETURNS int
    READS SQL DATA
BEGIN
	DECLARE AgeC INT;
    SELECT age
    INTO AgeC
    FROM client
    WHERE client_first_name = first_name AND client_last_name = last_name;

	RETURN  220 - AgeC ;
	
-- RETURN 1;
END