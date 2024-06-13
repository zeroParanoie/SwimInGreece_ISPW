package engclasses.dao;

import model.Booking;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public class LogWriterDAO {
    private File log;
    Logger logger = Logger.getLogger(getClass().getName());
    private final static String logName = "log.txt";

    public void updateLog(List<Booking> bookings) throws IOException {
        init();
        BufferedWriter writer = new BufferedWriter(new FileWriter(logName));
        writer.write("These are the tour you booked: ");
        writer.newLine();
        for(Booking booking : bookings) {
            writer.write("You booked tour: " + booking.getTourName() + " on date: " + booking.getDate());
            writer.newLine();
        }
        writer.flush();
        writer.close();
    }

    public void init() throws IOException {
        this.log = new File(logName);
        if(log.createNewFile()) {
            logger.info("Log file created");
        } else {
            logger.info("Log file already exists");
        }

        new PrintWriter(logName).close();
    }
}
