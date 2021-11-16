
-- Stored Procedures 
-- Made my Melville Misayah
-- 11/15/2021
CREATE DEFINER=`root`@`localhost` PROCEDURE `clientOver18`()
BEGIN
	SELECT COUNT(*) from client
    WHERE age > 18;
END



