CREATE DEFINER=`root`@`localhost` PROCEDURE `TotalClientAverageBodyFat`(OUT avgBodyFat float)
SELECT AVG(body_fat) AS ClientAverageBodyFat
    INTO avgBodyFat
	FROM client