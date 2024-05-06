SwimInGreece is the project for the Software Engineering course in Tor Vergata.

# To-do
- login use case; DONE
- implement logic from other use cases (beans, DAOs etc.);
  - sponsor tour - DONE - needs sql syntax check
  - read/write reviews - level easy, just long
  - book tour - level medium - DONE
  - special use case - need to think about this later, but should be easy
  - add exceptions
- create second view;
- add file system functionality to users dao;
- test cases;
- design level diagram;
- activity and sequence diagram;
- sonarcloud api;

# Current issues
- login will accept empty credentials and log in as a swimmer | will be solved adding exceptions
- sponsoring trips on submit spawns all the submission views together | SOLVED
- need to alter the DB: swims and tours are kinda f'ed up with the attributes | SOLVED
- empty fields give exceptions on tour booking | this is ok

# Possible improvements
- at the end of the implementation, make interfaces for graphical controllers that have the same operations (generally referred to the same use case)
