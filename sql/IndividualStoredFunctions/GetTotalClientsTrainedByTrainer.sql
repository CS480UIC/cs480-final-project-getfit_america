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