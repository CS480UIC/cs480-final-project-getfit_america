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