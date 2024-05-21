CREATE DEFINER=`root`@`localhost` PROCEDURE `get_org`()
BEGIN
	select Username, Body, Rating, Name
	from Reviews join Tours on Reviews.Tour = Tours.Name;
END