CREATE DEFINER=`root`@`localhost` PROCEDURE `get_appointment_location`()
BEGIN
	
	SELECT * FROM appointment
    WHERE location = 'Chicago,IL';

END