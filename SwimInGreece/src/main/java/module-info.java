module SwimInGreece {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    opens misc;
    opens controllers.graphical;
    opens controllers.graphical.login;
    opens controllers.graphical.sponsorTrip;
    opens controllers.graphical.searchTrips;
    opens controllers.graphical.reviews;
    opens model;
}