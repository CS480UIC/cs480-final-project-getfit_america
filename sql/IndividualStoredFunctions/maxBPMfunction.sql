-- Made by Melville Misayah
-- 11/15/2021

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



