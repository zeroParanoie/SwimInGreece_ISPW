SwimInGreece is the project for the Software Engineering course in Tor Vergata.

# To-do
- login use case; DONE
- implement logic from other use cases (beans, DAOs etc.); - fix simple bugs in the reviews DAO
  - sponsor tour - DONE
  - read/write reviews - DONE
  - book tour - level medium - DONE
  - add exceptions
- create second view;
- add file system functionality to users dao;
- test cases;
- technical documentation
- sonarcloud api;

# Current issues
- login will accept empty credentials and log in as a swimmer | will be solved adding exceptions
- sponsoring trips on submit spawns all the submission views together | SOLVED
- need to alter the DB: swims and tours are kinda f'ed up with the attributes | SOLVED
- stack trace is printed when there are empty fields in the booking view | this is ok, fixed with exceptions
- empty fields give exceptions on tour booking | this is ok,  fixed with exceptions

# Possible improvements
- at the end of the implementation, make interfaces for graphical controllers that have the same operations (generally referred to the same use case)

