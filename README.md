SwimInGreece is the project for the Software Engineering course in Tor Vergata.

# To-do
- login use case; DONE
- implement logic from other use cases (beans, DAOs etc.);
  - sponsor tour - DONE - needs sql syntax check
  - read/write reviews - level easy, just long
  - book tour - level medium
  - special use case - need to think about this later, but should be easy
  - add exceptions
- create second view;
- test cases;
- design level diagram;
- activity and sequence diagram;
- sonarcloud api;

# Current issues
- login will accept empty credentials and log in as a swimmer | will be solved adding exceptions
- sponsoring trips on submit spawns all the submission views together | SOLVED
- need to alter the DB: swims and tours are kinda f'ed up with the attributes | SOLVED
