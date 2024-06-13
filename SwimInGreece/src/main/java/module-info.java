module SwimInGreece {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;
    requires com.opencsv;
    requires org.controlsfx.controls;
    requires org.testng;
    requires org.junit.jupiter.api;

    opens misc;
    opens controllers.graphical;
    opens controllers.graphical.login;
    opens controllers.graphical.sponsortrip;
    opens controllers.graphical.searchtrips;
    opens controllers.graphical.reviews;
    opens model;
    opens engclasses.pattern;
    exports engclasses.beans.login;
    exports engclasses.exceptions;
    exports controllers.application;
}
