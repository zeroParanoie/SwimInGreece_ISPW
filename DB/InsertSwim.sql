DELIMITER $$
USE `SwimInGreeceDB`$$
CREATE PROCEDURE `insertSwims` (in swimLen float, in place VARCHAR(45), in tour VARCHAR(45), in organiser VARCHAR(45))
BEGIN
	insert into Swims (Place, Tour, Organiser, Length) VALUES (place, tour, organiser, swimLen);
    update Tours SET TotalLength = TotalLength + swimLen WHERE Tours.Name = tour;
END$$

DELIMITER ;