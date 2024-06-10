CREATE PROCEDURE `new_procedure` ()
BEGIN
	select Username, Body, Rating, Name
	from Reviews join Tours on Reviews.Tour = Tours.Name;
END
