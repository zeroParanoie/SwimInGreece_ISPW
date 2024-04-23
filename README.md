SwimInGreece is the project for the Software Engineering course in Tor Vergata.

# To-do
- login use case; DONE
- implement logic from other use cases (beans, DAOs etc.);
  - sponsor tour - ONGOING - level hard
  - read reviews - level medium
  - write reviews - level easy
  - book tour - level medium
  - special use case - need to think about this later, but should be easy
- create second view;
- test cases;
- design level diagram;
- activity and sequence diagram;
- sonarcloud api;

# Current issues:
- login will accept empty credentials and log in as a swimmer
- sponsoring trips on submit spawns all the submission views together | THIS IS OK, can be fixed later, or even not fixed
- need to alter the DB: swims and tours are kinda f'ed up with the attributes
