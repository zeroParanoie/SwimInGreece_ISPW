SwimInGreece is the project for the Software Engineering course in Tor Vergata.

# To-do
- login use case; DONE
- implement logic from other use cases (beans, DAOs etc.); - fix simple bugs in the reviews DAO
  - sponsor tour - DONE
  - read/write reviews - DONE
  - book tour - level medium - DONE
  - add exceptions - in progress
- create second view; - in progress
- add file system functionality to users dao; - DONE
- test cases;
- technical documentation
- sonarcloud api;

# Current issues
- login will accept empty credentials and log in as a swimmer | will be solved adding exceptions
- stack trace is printed when there are empty fields in the booking view | this is ok, fixed with exceptions
- empty fields give exceptions on tour booking | this is ok,  fixed with exceptions
- need to fix view buttons gave from copy paste

# Possible improvements
- at the end of the implementation, make interfaces for graphical controllers that have the same operations (generally referred to the same use case)

